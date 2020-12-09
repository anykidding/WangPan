package com.servlet;

import com.bean.User;
import com.google.gson.Gson;
import com.mapper.UserMapper;
import com.utils.GsonUtil;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonStr = request.getParameter("data");
        System.out.println(jsonStr);
        Gson gson = new Gson();
        int result;
        User user = GsonUtil.getInstance().getGson().fromJson(jsonStr, User.class);

        MybatisUtil mybatisUtil = MybatisUtil.getInstance();
        SqlSession session = mybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        System.out.println(user.getUseraccount() + user.getUserpwd());
        User user2 = userMapper.findUser(user);
        System.out.println(user2);
        if (user2 != null) {
            result = 1;
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
            printWriter.println(result);
            printWriter.flush();
        } else {
            result = 0;
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
            printWriter.println(result);
            printWriter.flush();
        }
        session.commit();
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

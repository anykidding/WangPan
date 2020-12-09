package com.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static MybatisUtil instance;
    private static final String CONFIG_PATH = "mybatis-config.xml";
    private SqlSessionFactory sessionFactory = null;
    private SqlSession session = null;

    private MybatisUtil() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(CONFIG_PATH);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession(false);//false为打开事务，取消自动提交，无参默认自动提交
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //获取MybatisUtil单例
    public static synchronized MybatisUtil getInstance() {
        if (instance == null) {
            synchronized (MybatisUtil.class) {
                instance = new MybatisUtil();
            }
        }
        return instance;
    }

    public SqlSession getSession() {
        return session;
    }
}

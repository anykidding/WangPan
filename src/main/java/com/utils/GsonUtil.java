package com.utils;

import com.google.gson.Gson;

public class GsonUtil
{
	private static GsonUtil util;
	private Gson g;
	private GsonUtil()
	{
		g = new Gson();
	}

	public static GsonUtil getInstance()
	{
		if (util == null)
		{
			util = new GsonUtil();
		}
		return  util;
	}

	public Gson getGson()
	{
		return g;
	}
}

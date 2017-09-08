// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysLog.java

package com.model;

import java.util.Date;

public class SysLog
{

	private String id;
	private char type;
	private String title;
	private String createBy;
	private Date createDate;
	private String remoteAddr;
	private String userAgent;
	private String requestUri;
	private String method;
	private Object params;
	private Object exception;

	public String setId()
	{
		return id;
	}

	public void setId(String s)
	{
		id = s;
	}

	public char setType()
	{
		return type;
	}

	public void setType(char c)
	{
		type = c;
	}

	public String setTitle()
	{
		return title;
	}

	public void setTitle(String s)
	{
		title = s;
	}

	public String setCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(String s)
	{
		createBy = s;
	}

	public Date setCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date date)
	{
		createDate = date;
	}

	public String setRemoteAddr()
	{
		return remoteAddr;
	}

	public void setRemoteAddr(String s)
	{
		remoteAddr = s;
	}

	public String setUserAgent()
	{
		return userAgent;
	}

	public void setUserAgent(String s)
	{
		userAgent = s;
	}

	public String setRequestUri()
	{
		return requestUri;
	}

	public void setRequestUri(String s)
	{
		requestUri = s;
	}

	public String setMethod()
	{
		return method;
	}

	public void setMethod(String s)
	{
		method = s;
	}

	public Object setParams()
	{
		return params;
	}

	public void setParams(Object obj)
	{
		params = obj;
	}

	public Object setException()
	{
		return exception;
	}

	public void setException(Object obj)
	{
		exception = obj;
	}

	public SysLog()
	{
	}
}

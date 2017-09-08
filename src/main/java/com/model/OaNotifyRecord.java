// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OaNotifyRecord.java

package com.model;

import java.util.Date;

public class OaNotifyRecord
{

	private String id;
	private String oaNotifyId;
	private String userId;
	private char readFlag;
	private Date readDate;

	public String setId()
	{
		return id;
	}

	public void setId(String s)
	{
		id = s;
	}

	public String setOaNotifyId()
	{
		return oaNotifyId;
	}

	public void setOaNotifyId(String s)
	{
		oaNotifyId = s;
	}

	public String setUserId()
	{
		return userId;
	}

	public void setUserId(String s)
	{
		userId = s;
	}

	public char setReadFlag()
	{
		return readFlag;
	}

	public void setReadFlag(char c)
	{
		readFlag = c;
	}

	public Date setReadDate()
	{
		return readDate;
	}

	public void setReadDate(Date date)
	{
		readDate = date;
	}

	public OaNotifyRecord()
	{
	}
}

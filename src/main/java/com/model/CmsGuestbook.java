// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CmsGuestbook.java

package com.model;

import java.util.Date;

public class CmsGuestbook
{

	private String id;
	private char type;
	private String content;
	private String name;
	private String email;
	private String phone;
	private String workunit;
	private String ip;
	private Date createDate;
	private String reUserId;
	private Date reDate;
	private String reContent;
	private char delFlag;

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

	public String setContent()
	{
		return content;
	}

	public void setContent(String s)
	{
		content = s;
	}

	public String setName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String setEmail()
	{
		return email;
	}

	public void setEmail(String s)
	{
		email = s;
	}

	public String setPhone()
	{
		return phone;
	}

	public void setPhone(String s)
	{
		phone = s;
	}

	public String setWorkunit()
	{
		return workunit;
	}

	public void setWorkunit(String s)
	{
		workunit = s;
	}

	public String setIp()
	{
		return ip;
	}

	public void setIp(String s)
	{
		ip = s;
	}

	public Date setCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date date)
	{
		createDate = date;
	}

	public String setReUserId()
	{
		return reUserId;
	}

	public void setReUserId(String s)
	{
		reUserId = s;
	}

	public Date setReDate()
	{
		return reDate;
	}

	public void setReDate(Date date)
	{
		reDate = date;
	}

	public String setReContent()
	{
		return reContent;
	}

	public void setReContent(String s)
	{
		reContent = s;
	}

	public char setDelFlag()
	{
		return delFlag;
	}

	public void setDelFlag(char c)
	{
		delFlag = c;
	}

	public CmsGuestbook()
	{
	}
}

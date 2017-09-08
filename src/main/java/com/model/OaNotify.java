// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OaNotify.java

package com.model;

import java.util.Date;

public class OaNotify
{

	private String id;
	private char type;
	private String title;
	private String content;
	private String files;
	private char status;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private String remarks;
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

	public String setTitle()
	{
		return title;
	}

	public void setTitle(String s)
	{
		title = s;
	}

	public String setContent()
	{
		return content;
	}

	public void setContent(String s)
	{
		content = s;
	}

	public String setFiles()
	{
		return files;
	}

	public void setFiles(String s)
	{
		files = s;
	}

	public char setStatus()
	{
		return status;
	}

	public void setStatus(char c)
	{
		status = c;
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

	public String setUpdateBy()
	{
		return updateBy;
	}

	public void setUpdateBy(String s)
	{
		updateBy = s;
	}

	public Date setUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date date)
	{
		updateDate = date;
	}

	public String setRemarks()
	{
		return remarks;
	}

	public void setRemarks(String s)
	{
		remarks = s;
	}

	public char setDelFlag()
	{
		return delFlag;
	}

	public void setDelFlag(char c)
	{
		delFlag = c;
	}

	public OaNotify()
	{
	}
}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GenTemplate.java

package com.model;

import java.util.Date;

public class GenTemplate
{

	private String id;
	private String name;
	private String category;
	private String filePath;
	private String fileName;
	private Object content;
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

	public String setName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String setCategory()
	{
		return category;
	}

	public void setCategory(String s)
	{
		category = s;
	}

	public String setFilePath()
	{
		return filePath;
	}

	public void setFilePath(String s)
	{
		filePath = s;
	}

	public String setFileName()
	{
		return fileName;
	}

	public void setFileName(String s)
	{
		fileName = s;
	}

	public Object setContent()
	{
		return content;
	}

	public void setContent(Object obj)
	{
		content = obj;
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

	public GenTemplate()
	{
	}
}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysDict.java

package com.model;

import java.util.Date;

public class SysDict
{

	private String id;
	private String value;
	private String label;
	private String type;
	private String description;
	private double sort;
	private String parentId;
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

	public String setValue()
	{
		return value;
	}

	public void setValue(String s)
	{
		value = s;
	}

	public String setLabel()
	{
		return label;
	}

	public void setLabel(String s)
	{
		label = s;
	}

	public String setType()
	{
		return type;
	}

	public void setType(String s)
	{
		type = s;
	}

	public String setDescription()
	{
		return description;
	}

	public void setDescription(String s)
	{
		description = s;
	}

	public double setSort()
	{
		return sort;
	}

	public void setSort(double d)
	{
		sort = d;
	}

	public String setParentId()
	{
		return parentId;
	}

	public void setParentId(String s)
	{
		parentId = s;
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

	public SysDict()
	{
	}
}

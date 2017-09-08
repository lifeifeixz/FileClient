// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GenTable.java

package com.model;

import java.util.Date;

public class GenTable
{

	private String id;
	private String name;
	private String comments;
	private String className;
	private String parentTable;
	private String parentTableFk;
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

	public String setComments()
	{
		return comments;
	}

	public void setComments(String s)
	{
		comments = s;
	}

	public String setClassName()
	{
		return className;
	}

	public void setClassName(String s)
	{
		className = s;
	}

	public String setParentTable()
	{
		return parentTable;
	}

	public void setParentTable(String s)
	{
		parentTable = s;
	}

	public String setParentTableFk()
	{
		return parentTableFk;
	}

	public void setParentTableFk(String s)
	{
		parentTableFk = s;
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

	public GenTable()
	{
	}
}

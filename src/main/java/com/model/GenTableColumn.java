// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   GenTableColumn.java

package com.model;

import java.util.Date;

public class GenTableColumn
{

	private String id;
	private String genTableId;
	private String name;
	private String comments;
	private String jdbcType;
	private String javaType;
	private String javaField;
	private char isPk;
	private char isNull;
	private char isInsert;
	private char isEdit;
	private char isList;
	private char isQuery;
	private String queryType;
	private String showType;
	private String dictType;
	private String settings;
	private double sort;
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

	public String setGenTableId()
	{
		return genTableId;
	}

	public void setGenTableId(String s)
	{
		genTableId = s;
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

	public String setJdbcType()
	{
		return jdbcType;
	}

	public void setJdbcType(String s)
	{
		jdbcType = s;
	}

	public String setJavaType()
	{
		return javaType;
	}

	public void setJavaType(String s)
	{
		javaType = s;
	}

	public String setJavaField()
	{
		return javaField;
	}

	public void setJavaField(String s)
	{
		javaField = s;
	}

	public char setIsPk()
	{
		return isPk;
	}

	public void setIsPk(char c)
	{
		isPk = c;
	}

	public char setIsNull()
	{
		return isNull;
	}

	public void setIsNull(char c)
	{
		isNull = c;
	}

	public char setIsInsert()
	{
		return isInsert;
	}

	public void setIsInsert(char c)
	{
		isInsert = c;
	}

	public char setIsEdit()
	{
		return isEdit;
	}

	public void setIsEdit(char c)
	{
		isEdit = c;
	}

	public char setIsList()
	{
		return isList;
	}

	public void setIsList(char c)
	{
		isList = c;
	}

	public char setIsQuery()
	{
		return isQuery;
	}

	public void setIsQuery(char c)
	{
		isQuery = c;
	}

	public String setQueryType()
	{
		return queryType;
	}

	public void setQueryType(String s)
	{
		queryType = s;
	}

	public String setShowType()
	{
		return showType;
	}

	public void setShowType(String s)
	{
		showType = s;
	}

	public String setDictType()
	{
		return dictType;
	}

	public void setDictType(String s)
	{
		dictType = s;
	}

	public String setSettings()
	{
		return settings;
	}

	public void setSettings(String s)
	{
		settings = s;
	}

	public double setSort()
	{
		return sort;
	}

	public void setSort(double d)
	{
		sort = d;
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

	public GenTableColumn()
	{
	}
}

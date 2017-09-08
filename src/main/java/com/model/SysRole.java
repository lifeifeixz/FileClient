// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SysRole.java

package com.model;

import java.util.Date;

public class SysRole
{

	private String id;
	private String officeId;
	private String name;
	private String enname;
	private String roleType;
	private char dataScope;
	private String isSys;
	private String useable;
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

	public String setOfficeId()
	{
		return officeId;
	}

	public void setOfficeId(String s)
	{
		officeId = s;
	}

	public String setName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String setEnname()
	{
		return enname;
	}

	public void setEnname(String s)
	{
		enname = s;
	}

	public String setRoleType()
	{
		return roleType;
	}

	public void setRoleType(String s)
	{
		roleType = s;
	}

	public char setDataScope()
	{
		return dataScope;
	}

	public void setDataScope(char c)
	{
		dataScope = c;
	}

	public String setIsSys()
	{
		return isSys;
	}

	public void setIsSys(String s)
	{
		isSys = s;
	}

	public String setUseable()
	{
		return useable;
	}

	public void setUseable(String s)
	{
		useable = s;
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

	public SysRole()
	{
	}
}

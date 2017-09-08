// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActReDeployment.java

package com.model;


public class ActReDeployment
{

	private String id_;
	private String name_;
	private String category_;
	private String tenantId;
	private Object deployTime;

	public String setId_()
	{
		return id_;
	}

	public void setId_(String s)
	{
		id_ = s;
	}

	public String setName_()
	{
		return name_;
	}

	public void setName_(String s)
	{
		name_ = s;
	}

	public String setCategory_()
	{
		return category_;
	}

	public void setCategory_(String s)
	{
		category_ = s;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public Object setDeployTime()
	{
		return deployTime;
	}

	public void setDeployTime(Object obj)
	{
		deployTime = obj;
	}

	public ActReDeployment()
	{
	}
}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActRuExecution.java

package com.model;


public class ActRuExecution
{

	private String id_;
	private int rev_;
	private String procInstId;
	private String businessKey;
	private String parentId;
	private String procDefId;
	private String superExec;
	private String actId;
	private int isActive;
	private int isConcurrent;
	private int isScope;
	private int isEventScope;
	private int suspensionState;
	private int cachedEntState;
	private String tenantId;

	public String setId_()
	{
		return id_;
	}

	public void setId_(String s)
	{
		id_ = s;
	}

	public int setRev_()
	{
		return rev_;
	}

	public void setRev_(int i)
	{
		rev_ = i;
	}

	public String setProcInstId()
	{
		return procInstId;
	}

	public void setProcInstId(String s)
	{
		procInstId = s;
	}

	public String setBusinessKey()
	{
		return businessKey;
	}

	public void setBusinessKey(String s)
	{
		businessKey = s;
	}

	public String setParentId()
	{
		return parentId;
	}

	public void setParentId(String s)
	{
		parentId = s;
	}

	public String setProcDefId()
	{
		return procDefId;
	}

	public void setProcDefId(String s)
	{
		procDefId = s;
	}

	public String setSuperExec()
	{
		return superExec;
	}

	public void setSuperExec(String s)
	{
		superExec = s;
	}

	public String setActId()
	{
		return actId;
	}

	public void setActId(String s)
	{
		actId = s;
	}

	public int setIsActive()
	{
		return isActive;
	}

	public void setIsActive(int i)
	{
		isActive = i;
	}

	public int setIsConcurrent()
	{
		return isConcurrent;
	}

	public void setIsConcurrent(int i)
	{
		isConcurrent = i;
	}

	public int setIsScope()
	{
		return isScope;
	}

	public void setIsScope(int i)
	{
		isScope = i;
	}

	public int setIsEventScope()
	{
		return isEventScope;
	}

	public void setIsEventScope(int i)
	{
		isEventScope = i;
	}

	public int setSuspensionState()
	{
		return suspensionState;
	}

	public void setSuspensionState(int i)
	{
		suspensionState = i;
	}

	public int setCachedEntState()
	{
		return cachedEntState;
	}

	public void setCachedEntState(int i)
	{
		cachedEntState = i;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public ActRuExecution()
	{
	}
}

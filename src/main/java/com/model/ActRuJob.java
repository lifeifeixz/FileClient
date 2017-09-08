// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActRuJob.java

package com.model;


public class ActRuJob
{

	private String id_;
	private int rev_;
	private String type_;
	private Object lockExpTime;
	private String lockOwner;
	private int exclusive_;
	private String executionId;
	private String processInstanceId;
	private String procDefId;
	private int retries_;
	private String exceptionStackId;
	private String exceptionMsg;
	private Object duedate_;
	private String repeat_;
	private String handlerType;
	private String handlerCfg;
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

	public String setType_()
	{
		return type_;
	}

	public void setType_(String s)
	{
		type_ = s;
	}

	public Object setLockExpTime()
	{
		return lockExpTime;
	}

	public void setLockExpTime(Object obj)
	{
		lockExpTime = obj;
	}

	public String setLockOwner()
	{
		return lockOwner;
	}

	public void setLockOwner(String s)
	{
		lockOwner = s;
	}

	public int setExclusive_()
	{
		return exclusive_;
	}

	public void setExclusive_(int i)
	{
		exclusive_ = i;
	}

	public String setExecutionId()
	{
		return executionId;
	}

	public void setExecutionId(String s)
	{
		executionId = s;
	}

	public String setProcessInstanceId()
	{
		return processInstanceId;
	}

	public void setProcessInstanceId(String s)
	{
		processInstanceId = s;
	}

	public String setProcDefId()
	{
		return procDefId;
	}

	public void setProcDefId(String s)
	{
		procDefId = s;
	}

	public int setRetries_()
	{
		return retries_;
	}

	public void setRetries_(int i)
	{
		retries_ = i;
	}

	public String setExceptionStackId()
	{
		return exceptionStackId;
	}

	public void setExceptionStackId(String s)
	{
		exceptionStackId = s;
	}

	public String setExceptionMsg()
	{
		return exceptionMsg;
	}

	public void setExceptionMsg(String s)
	{
		exceptionMsg = s;
	}

	public Object setDuedate_()
	{
		return duedate_;
	}

	public void setDuedate_(Object obj)
	{
		duedate_ = obj;
	}

	public String setRepeat_()
	{
		return repeat_;
	}

	public void setRepeat_(String s)
	{
		repeat_ = s;
	}

	public String setHandlerType()
	{
		return handlerType;
	}

	public void setHandlerType(String s)
	{
		handlerType = s;
	}

	public String setHandlerCfg()
	{
		return handlerCfg;
	}

	public void setHandlerCfg(String s)
	{
		handlerCfg = s;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public ActRuJob()
	{
	}
}

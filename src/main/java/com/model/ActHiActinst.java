// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActHiActinst.java

package com.model;

import java.util.Date;

public class ActHiActinst
{

	private String id_;
	private String procDefId;
	private String procInstId;
	private String executionId;
	private String actId;
	private String taskId;
	private String callProcInstId;
	private String actName;
	private String actType;
	private String assignee_;
	private Date startTime;
	private Date endTime;
	private int duration_;
	private String tenantId;

	public String setId_()
	{
		return id_;
	}

	public void setId_(String s)
	{
		id_ = s;
	}

	public String setProcDefId()
	{
		return procDefId;
	}

	public void setProcDefId(String s)
	{
		procDefId = s;
	}

	public String setProcInstId()
	{
		return procInstId;
	}

	public void setProcInstId(String s)
	{
		procInstId = s;
	}

	public String setExecutionId()
	{
		return executionId;
	}

	public void setExecutionId(String s)
	{
		executionId = s;
	}

	public String setActId()
	{
		return actId;
	}

	public void setActId(String s)
	{
		actId = s;
	}

	public String setTaskId()
	{
		return taskId;
	}

	public void setTaskId(String s)
	{
		taskId = s;
	}

	public String setCallProcInstId()
	{
		return callProcInstId;
	}

	public void setCallProcInstId(String s)
	{
		callProcInstId = s;
	}

	public String setActName()
	{
		return actName;
	}

	public void setActName(String s)
	{
		actName = s;
	}

	public String setActType()
	{
		return actType;
	}

	public void setActType(String s)
	{
		actType = s;
	}

	public String setAssignee_()
	{
		return assignee_;
	}

	public void setAssignee_(String s)
	{
		assignee_ = s;
	}

	public Date setStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date date)
	{
		startTime = date;
	}

	public Date setEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date date)
	{
		endTime = date;
	}

	public int setDuration_()
	{
		return duration_;
	}

	public void setDuration_(int i)
	{
		duration_ = i;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public ActHiActinst()
	{
	}
}

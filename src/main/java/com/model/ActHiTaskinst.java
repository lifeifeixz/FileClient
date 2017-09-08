// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActHiTaskinst.java

package com.model;

import java.util.Date;

public class ActHiTaskinst
{

	private String id_;
	private String procDefId;
	private String taskDefKey;
	private String procInstId;
	private String executionId;
	private String name_;
	private String parentTaskId;
	private String description_;
	private String owner_;
	private String assignee_;
	private Date startTime;
	private Date claimTime;
	private Date endTime;
	private int duration_;
	private String deleteReason;
	private int priority_;
	private Date dueDate;
	private String formKey;
	private String category_;
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

	public String setTaskDefKey()
	{
		return taskDefKey;
	}

	public void setTaskDefKey(String s)
	{
		taskDefKey = s;
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

	public String setName_()
	{
		return name_;
	}

	public void setName_(String s)
	{
		name_ = s;
	}

	public String setParentTaskId()
	{
		return parentTaskId;
	}

	public void setParentTaskId(String s)
	{
		parentTaskId = s;
	}

	public String setDescription_()
	{
		return description_;
	}

	public void setDescription_(String s)
	{
		description_ = s;
	}

	public String setOwner_()
	{
		return owner_;
	}

	public void setOwner_(String s)
	{
		owner_ = s;
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

	public Date setClaimTime()
	{
		return claimTime;
	}

	public void setClaimTime(Date date)
	{
		claimTime = date;
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

	public String setDeleteReason()
	{
		return deleteReason;
	}

	public void setDeleteReason(String s)
	{
		deleteReason = s;
	}

	public int setPriority_()
	{
		return priority_;
	}

	public void setPriority_(int i)
	{
		priority_ = i;
	}

	public Date setDueDate()
	{
		return dueDate;
	}

	public void setDueDate(Date date)
	{
		dueDate = date;
	}

	public String setFormKey()
	{
		return formKey;
	}

	public void setFormKey(String s)
	{
		formKey = s;
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

	public ActHiTaskinst()
	{
	}
}

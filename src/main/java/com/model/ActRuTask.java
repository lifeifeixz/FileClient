// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActRuTask.java

package com.model;

import java.util.Date;

public class ActRuTask
{

	private String id_;
	private int rev_;
	private String executionId;
	private String procInstId;
	private String procDefId;
	private String name_;
	private String parentTaskId;
	private String description_;
	private String taskDefKey;
	private String owner_;
	private String assignee_;
	private String delegation_;
	private int priority_;
	private Object createTime;
	private Date dueDate;
	private String category_;
	private int suspensionState;
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

	public String setExecutionId()
	{
		return executionId;
	}

	public void setExecutionId(String s)
	{
		executionId = s;
	}

	public String setProcInstId()
	{
		return procInstId;
	}

	public void setProcInstId(String s)
	{
		procInstId = s;
	}

	public String setProcDefId()
	{
		return procDefId;
	}

	public void setProcDefId(String s)
	{
		procDefId = s;
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

	public String setTaskDefKey()
	{
		return taskDefKey;
	}

	public void setTaskDefKey(String s)
	{
		taskDefKey = s;
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

	public String setDelegation_()
	{
		return delegation_;
	}

	public void setDelegation_(String s)
	{
		delegation_ = s;
	}

	public int setPriority_()
	{
		return priority_;
	}

	public void setPriority_(int i)
	{
		priority_ = i;
	}

	public Object setCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Object obj)
	{
		createTime = obj;
	}

	public Date setDueDate()
	{
		return dueDate;
	}

	public void setDueDate(Date date)
	{
		dueDate = date;
	}

	public String setCategory_()
	{
		return category_;
	}

	public void setCategory_(String s)
	{
		category_ = s;
	}

	public int setSuspensionState()
	{
		return suspensionState;
	}

	public void setSuspensionState(int i)
	{
		suspensionState = i;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public ActRuTask()
	{
	}
}

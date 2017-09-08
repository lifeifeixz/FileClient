// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActHiProcinst.java

package com.model;

import java.util.Date;

public class ActHiProcinst
{

	private String id_;
	private String procInstId;
	private String businessKey;
	private String procDefId;
	private Date startTime;
	private Date endTime;
	private int duration_;
	private String startUserId;
	private String startActId;
	private String endActId;
	private String superProcessInstanceId;
	private String deleteReason;
	private String tenantId;

	public String setId_()
	{
		return id_;
	}

	public void setId_(String s)
	{
		id_ = s;
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

	public String setProcDefId()
	{
		return procDefId;
	}

	public void setProcDefId(String s)
	{
		procDefId = s;
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

	public String setStartUserId()
	{
		return startUserId;
	}

	public void setStartUserId(String s)
	{
		startUserId = s;
	}

	public String setStartActId()
	{
		return startActId;
	}

	public void setStartActId(String s)
	{
		startActId = s;
	}

	public String setEndActId()
	{
		return endActId;
	}

	public void setEndActId(String s)
	{
		endActId = s;
	}

	public String setSuperProcessInstanceId()
	{
		return superProcessInstanceId;
	}

	public void setSuperProcessInstanceId(String s)
	{
		superProcessInstanceId = s;
	}

	public String setDeleteReason()
	{
		return deleteReason;
	}

	public void setDeleteReason(String s)
	{
		deleteReason = s;
	}

	public String setTenantId()
	{
		return tenantId;
	}

	public void setTenantId(String s)
	{
		tenantId = s;
	}

	public ActHiProcinst()
	{
	}
}

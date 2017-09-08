// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OaLeave.java

package com.model;

import java.util.Date;

public class OaLeave
{

	private String id;
	private String processInstanceId;
	private Date startTime;
	private Date endTime;
	private String leaveType;
	private String reason;
	private Date applyTime;
	private Date realityStartTime;
	private Date realityEndTime;
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

	public String setProcessInstanceId()
	{
		return processInstanceId;
	}

	public void setProcessInstanceId(String s)
	{
		processInstanceId = s;
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

	public String setLeaveType()
	{
		return leaveType;
	}

	public void setLeaveType(String s)
	{
		leaveType = s;
	}

	public String setReason()
	{
		return reason;
	}

	public void setReason(String s)
	{
		reason = s;
	}

	public Date setApplyTime()
	{
		return applyTime;
	}

	public void setApplyTime(Date date)
	{
		applyTime = date;
	}

	public Date setRealityStartTime()
	{
		return realityStartTime;
	}

	public void setRealityStartTime(Date date)
	{
		realityStartTime = date;
	}

	public Date setRealityEndTime()
	{
		return realityEndTime;
	}

	public void setRealityEndTime(Date date)
	{
		realityEndTime = date;
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

	public OaLeave()
	{
	}
}

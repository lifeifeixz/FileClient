// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActHiComment.java

package com.model;

import java.util.Date;

public class ActHiComment
{

	private String id_;
	private String type_;
	private Date time_;
	private String userId;
	private String taskId;
	private String procInstId;
	private String action_;
	private String message_;
	private Object fullMsg;

	public String setId_()
	{
		return id_;
	}

	public void setId_(String s)
	{
		id_ = s;
	}

	public String setType_()
	{
		return type_;
	}

	public void setType_(String s)
	{
		type_ = s;
	}

	public Date setTime_()
	{
		return time_;
	}

	public void setTime_(Date date)
	{
		time_ = date;
	}

	public String setUserId()
	{
		return userId;
	}

	public void setUserId(String s)
	{
		userId = s;
	}

	public String setTaskId()
	{
		return taskId;
	}

	public void setTaskId(String s)
	{
		taskId = s;
	}

	public String setProcInstId()
	{
		return procInstId;
	}

	public void setProcInstId(String s)
	{
		procInstId = s;
	}

	public String setAction_()
	{
		return action_;
	}

	public void setAction_(String s)
	{
		action_ = s;
	}

	public String setMessage_()
	{
		return message_;
	}

	public void setMessage_(String s)
	{
		message_ = s;
	}

	public Object setFullMsg()
	{
		return fullMsg;
	}

	public void setFullMsg(Object obj)
	{
		fullMsg = obj;
	}

	public ActHiComment()
	{
	}
}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CmsComment.java

package com.model;

import java.util.Date;

public class CmsComment
{

	private String id;
	private String categoryId;
	private String contentId;
	private String title;
	private String content;
	private String name;
	private String ip;
	private Date createDate;
	private String auditUserId;
	private Date auditDate;
	private char delFlag;

	public String setId()
	{
		return id;
	}

	public void setId(String s)
	{
		id = s;
	}

	public String setCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String s)
	{
		categoryId = s;
	}

	public String setContentId()
	{
		return contentId;
	}

	public void setContentId(String s)
	{
		contentId = s;
	}

	public String setTitle()
	{
		return title;
	}

	public void setTitle(String s)
	{
		title = s;
	}

	public String setContent()
	{
		return content;
	}

	public void setContent(String s)
	{
		content = s;
	}

	public String setName()
	{
		return name;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String setIp()
	{
		return ip;
	}

	public void setIp(String s)
	{
		ip = s;
	}

	public Date setCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date date)
	{
		createDate = date;
	}

	public String setAuditUserId()
	{
		return auditUserId;
	}

	public void setAuditUserId(String s)
	{
		auditUserId = s;
	}

	public Date setAuditDate()
	{
		return auditDate;
	}

	public void setAuditDate(Date date)
	{
		auditDate = date;
	}

	public char setDelFlag()
	{
		return delFlag;
	}

	public void setDelFlag(char c)
	{
		delFlag = c;
	}

	public CmsComment()
	{
	}
}

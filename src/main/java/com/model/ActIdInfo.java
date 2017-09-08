// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ActIdInfo.java

package com.model;


public class ActIdInfo
{

	private String id_;
	private int rev_;
	private String userId;
	private String type_;
	private String key_;
	private String value_;
	private Object password_;
	private String parentId;

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

	public String setUserId()
	{
		return userId;
	}

	public void setUserId(String s)
	{
		userId = s;
	}

	public String setType_()
	{
		return type_;
	}

	public void setType_(String s)
	{
		type_ = s;
	}

	public String setKey_()
	{
		return key_;
	}

	public void setKey_(String s)
	{
		key_ = s;
	}

	public String setValue_()
	{
		return value_;
	}

	public void setValue_(String s)
	{
		value_ = s;
	}

	public Object setPassword_()
	{
		return password_;
	}

	public void setPassword_(Object obj)
	{
		password_ = obj;
	}

	public String setParentId()
	{
		return parentId;
	}

	public void setParentId(String s)
	{
		parentId = s;
	}

	public ActIdInfo()
	{
	}
}

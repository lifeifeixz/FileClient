// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CmsArticleData.java

package com.model;


public class CmsArticleData
{

	private String id;
	private Object content;
	private String copyfrom;
	private String relation;
	private char allowComment;

	public String setId()
	{
		return id;
	}

	public void setId(String s)
	{
		id = s;
	}

	public Object setContent()
	{
		return content;
	}

	public void setContent(Object obj)
	{
		content = obj;
	}

	public String setCopyfrom()
	{
		return copyfrom;
	}

	public void setCopyfrom(String s)
	{
		copyfrom = s;
	}

	public String setRelation()
	{
		return relation;
	}

	public void setRelation(String s)
	{
		relation = s;
	}

	public char setAllowComment()
	{
		return allowComment;
	}

	public void setAllowComment(char c)
	{
		allowComment = c;
	}

	public CmsArticleData()
	{
	}
}

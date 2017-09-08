// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CmsArticle.java

package com.model;

import java.util.Date;

public class CmsArticle
{

	private String id;
	private String categoryId;
	private String title;
	private String link;
	private String color;
	private String image;
	private String keywords;
	private String description;
	private int weight;
	private Date weightDate;
	private int hits;
	private String posid;
	private String customContentView;
	private Object viewConfig;
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

	public String setCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String s)
	{
		categoryId = s;
	}

	public String setTitle()
	{
		return title;
	}

	public void setTitle(String s)
	{
		title = s;
	}

	public String setLink()
	{
		return link;
	}

	public void setLink(String s)
	{
		link = s;
	}

	public String setColor()
	{
		return color;
	}

	public void setColor(String s)
	{
		color = s;
	}

	public String setImage()
	{
		return image;
	}

	public void setImage(String s)
	{
		image = s;
	}

	public String setKeywords()
	{
		return keywords;
	}

	public void setKeywords(String s)
	{
		keywords = s;
	}

	public String setDescription()
	{
		return description;
	}

	public void setDescription(String s)
	{
		description = s;
	}

	public int setWeight()
	{
		return weight;
	}

	public void setWeight(int i)
	{
		weight = i;
	}

	public Date setWeightDate()
	{
		return weightDate;
	}

	public void setWeightDate(Date date)
	{
		weightDate = date;
	}

	public int setHits()
	{
		return hits;
	}

	public void setHits(int i)
	{
		hits = i;
	}

	public String setPosid()
	{
		return posid;
	}

	public void setPosid(String s)
	{
		posid = s;
	}

	public String setCustomContentView()
	{
		return customContentView;
	}

	public void setCustomContentView(String s)
	{
		customContentView = s;
	}

	public Object setViewConfig()
	{
		return viewConfig;
	}

	public void setViewConfig(Object obj)
	{
		viewConfig = obj;
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

	public CmsArticle()
	{
	}
}

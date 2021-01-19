package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

	@SerializedName("modhash")
	private String modhash;

	@SerializedName("children")
	private List<ChildrenItem> children;

	@SerializedName("before")
	private String before;

	@SerializedName("dist")
	private int dist;

	@SerializedName("after")
	private String after;


	public String getModhash(){
		return modhash;
	}

	public List<ChildrenItem> getChildren(){
		return children;
	}

	public Object getBefore(){
		return before;
	}

	public int getDist(){
		return dist;
	}

	public String getAfter(){
		return after;
	}
}
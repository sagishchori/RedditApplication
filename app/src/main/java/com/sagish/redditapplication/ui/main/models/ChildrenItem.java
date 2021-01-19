package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class ChildrenItem{

	@SerializedName("data")
	private ChildrenData data;

	@SerializedName("kind")
	private String kind;

	public ChildrenData getData(){
		return data;
	}

	public String getKind(){
		return kind;
	}
}
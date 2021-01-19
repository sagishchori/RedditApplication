package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class MainResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("kind")
	private String kind;

	public Data getData(){
		return data;
	}

	public String getKind(){
		return kind;
	}
}
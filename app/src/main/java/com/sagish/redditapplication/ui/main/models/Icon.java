package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class Icon{

	@SerializedName("width")
	private int width;

	@SerializedName("format")
	private String format;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public int getWidth(){
		return width;
	}

	public String getFormat(){
		return format;
	}

	public String getUrl(){
		return url;
	}

	public int getHeight(){
		return height;
	}
}
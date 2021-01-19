package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Preview{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("enabled")
	private boolean enabled;

	public List<ImagesItem> getImages(){
		return images;
	}

	public boolean isEnabled(){
		return enabled;
	}
}
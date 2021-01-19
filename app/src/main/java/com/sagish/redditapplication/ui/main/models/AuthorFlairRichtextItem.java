package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class AuthorFlairRichtextItem{

	@SerializedName("t")
	private String T;

	@SerializedName("e")
	private String E;

	@SerializedName("a")
	private String A;

	@SerializedName("u")
	private String U;

	public String getT(){
		return T;
	}

	public String getE(){
		return E;
	}

	public String getA(){
		return A;
	}

	public String getU(){
		return U;
	}
}
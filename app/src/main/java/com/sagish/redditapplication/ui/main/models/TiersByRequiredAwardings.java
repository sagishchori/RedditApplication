package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class TiersByRequiredAwardings{

	@SerializedName("0")
	private JsonMember0 jsonMember0;

	@SerializedName("25")
	private JsonMember25 jsonMember25;

	@SerializedName("5")
	private JsonMember5 jsonMember5;

	@SerializedName("10")
	private JsonMember10 jsonMember10;

	public JsonMember0 getJsonMember0(){
		return jsonMember0;
	}

	public JsonMember25 getJsonMember25(){
		return jsonMember25;
	}

	public JsonMember5 getJsonMember5(){
		return jsonMember5;
	}

	public JsonMember10 getJsonMember10(){
		return jsonMember10;
	}
}
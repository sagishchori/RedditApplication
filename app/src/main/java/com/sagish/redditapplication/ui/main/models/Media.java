package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class Media{

	@SerializedName("reddit_video")
	private RedditVideo redditVideo;

	public RedditVideo getRedditVideo(){
		return redditVideo;
	}
}
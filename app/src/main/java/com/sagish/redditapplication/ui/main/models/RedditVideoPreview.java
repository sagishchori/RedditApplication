package com.sagish.redditapplication.ui.main.models;

import com.google.gson.annotations.SerializedName;

public class RedditVideoPreview{

	@SerializedName("duration")
	private int duration;

	@SerializedName("is_gif")
	private boolean isGif;

	@SerializedName("bitrate_kbps")
	private int bitrateKbps;

	@SerializedName("dash_url")
	private String dashUrl;

	@SerializedName("fallback_url")
	private String fallbackUrl;

	@SerializedName("width")
	private int width;

	@SerializedName("scrubber_media_url")
	private String scrubberMediaUrl;

	@SerializedName("hls_url")
	private String hlsUrl;

	@SerializedName("transcoding_status")
	private String transcodingStatus;

	@SerializedName("height")
	private int height;

	public int getDuration(){
		return duration;
	}

	public boolean isIsGif(){
		return isGif;
	}

	public int getBitrateKbps(){
		return bitrateKbps;
	}

	public String getDashUrl(){
		return dashUrl;
	}

	public String getFallbackUrl(){
		return fallbackUrl;
	}

	public int getWidth(){
		return width;
	}

	public String getScrubberMediaUrl(){
		return scrubberMediaUrl;
	}

	public String getHlsUrl(){
		return hlsUrl;
	}

	public String getTranscodingStatus(){
		return transcodingStatus;
	}

	public int getHeight(){
		return height;
	}
}
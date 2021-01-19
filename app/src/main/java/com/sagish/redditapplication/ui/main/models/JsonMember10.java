package com.sagish.redditapplication.ui.main.models;

import java.util.List;

public class JsonMember10 {
	private int awardingsRequired;
	private List<ResizedStaticIconsItem> resizedStaticIcons;
	private Icon icon;
	private StaticIcon staticIcon;
	private List<ResizedIconsItem> resizedIcons;

	public int getAwardingsRequired(){
		return awardingsRequired;
	}

	public List<ResizedStaticIconsItem> getResizedStaticIcons(){
		return resizedStaticIcons;
	}

	public Icon getIcon(){
		return icon;
	}

	public StaticIcon getStaticIcon(){
		return staticIcon;
	}

	public List<ResizedIconsItem> getResizedIcons(){
		return resizedIcons;
	}
}
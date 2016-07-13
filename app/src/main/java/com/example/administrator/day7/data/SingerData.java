package com.example.administrator.day7.data;

public class SingerData {

	String imageRes;

	String name;

	String introduce;

	public SingerData(String imageRes, String name, String introduce) {
		super();
		this.imageRes = imageRes;
		this.name = name;
		this.introduce = introduce;

	}

	public String getImageRes() {
		return imageRes;
	}

	public void setImageRes(String imageRes) {
		this.imageRes = imageRes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}

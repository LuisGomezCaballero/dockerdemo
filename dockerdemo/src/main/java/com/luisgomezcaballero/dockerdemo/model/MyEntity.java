package com.luisgomezcaballero.dockerdemo.model;

public class MyEntity {
	private long myLong;
	private String myString;

	public MyEntity() {
		super();
	}

	public MyEntity(long myLong, String myString) {
		super();
		this.myLong = myLong;
		this.myString = myString;
	}

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	@Override
	public String toString() {
		return "MyEntity [myLong=" + myLong + ", myString=" + myString + "]";
	}

}

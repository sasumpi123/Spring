package com.test07;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");

	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");

	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
	}
	
	public SamsungTV() {
		System.out.println("SamsungTV 생성");
	}

}

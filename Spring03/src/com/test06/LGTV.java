package com.test06;

public class LGTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("LGTV powerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("LGTV powerOff");

	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV volumeUp");

	}

	@Override
	public void volumeDown() {
		System.out.println("LGTV volumeDown");
	}
}

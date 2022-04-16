package com.practice.parkinglot;

class Pair<F, S> {
	F floor;
	S slot;
	public Pair(F floor, S slot) {
		this.floor = floor;
		this.slot = slot;
	}
}
public class CommonUtils {
	static <F, S> Pair<F, S> setGetPair(F floor, S slot) {
		return new Pair<F, S>(floor, slot);
	}
}

package com.aqb.entities;

import java.util.Random;

public class Dice {

	private static final int minDiceCount = 2;
	private static final int maxDiceCount = 12;

	public static int roll() {
		Random r = new Random();
		return r.nextInt((maxDiceCount - minDiceCount) + 1) + minDiceCount;
	}
}

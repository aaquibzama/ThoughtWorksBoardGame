package com.aqb.entities;

public class Treasure implements Cell{

	private static final int BOUNTY = 200;
	private final int cellNumber;

	public Treasure(int cellNumber) {
		this.cellNumber = cellNumber;
	}

	public int getCellNumber() {
		return cellNumber;
	}
	public void land(Player player) {
		player.updateWorth(BOUNTY);
		
	}
}

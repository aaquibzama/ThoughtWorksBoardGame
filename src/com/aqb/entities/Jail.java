package com.aqb.entities;

public class Jail implements Cell {

	private static final int FINE = -150;
	private final int cellNumber;

	public Jail(int cellNumber) {
		this.cellNumber = cellNumber;
	}

	public int getCellNumber() {
		return cellNumber;
	}
	public void land(Player player) {
		player.updateWorth(FINE);
		
	}

	
}

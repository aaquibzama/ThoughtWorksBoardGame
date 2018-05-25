package com.aqb.entities;

public class EmptyCell implements Cell {

	private final int cellNumber;
	private static final int BOUNTY = 0;

	public EmptyCell(int cellNumber) {
		this.cellNumber = cellNumber;
	}

	public int getCellNumber() {
		return cellNumber;
	}

	public void land(Player player) {
		player.updateWorth(BOUNTY);
	}
}

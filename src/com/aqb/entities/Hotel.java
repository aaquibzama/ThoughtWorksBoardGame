package com.aqb.entities;

public class Hotel implements Cell {

	private static final int RENT = 50;
	private static final int WORTH = 200;
	private Player owner = null;
	private final int cellNumber;

	public Hotel(int cellNumber) {
		this.cellNumber = cellNumber;
	}

	public int getCellNumber() {
		return cellNumber;
	}

	public void land(Player player) {
		if (owner == null) {
			if (player.getWorth() > WORTH) {
				owner = player;
				player.purchaseHotel(this);
				player.updateWorth(-WORTH);
			} else {
				player.updateWorth(-player.getWorth());
			}
		} else {
			owner.updateWorth(RENT);
			player.updateWorth(-RENT);
		}
	}

}

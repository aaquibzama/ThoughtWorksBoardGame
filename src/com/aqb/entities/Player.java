package com.aqb.entities;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable{

	private final int id;
	private int worth;
	private int currentBlock;
	private List<Hotel> ownedHotels;
	
	public Player(int id) {
		this.id = id;
		this.worth = 0;
		this.currentBlock = 0;
		ownedHotels = new ArrayList<Hotel>();
	}
	
	public void purchaseHotel(Hotel hotel) {
		ownedHotels.add(hotel);
	}
	
	public void play() {
		Board board = Board.getInstance();
		int diceCount = Dice.roll();
		int nextCellIndex = getNextCellIndex(diceCount, board.getNumberOfCells());
		Cell nextCell = board.getCellAt(nextCellIndex);
		nextCell.land(this);
		currentBlock = nextCell.getCellNumber();
	}
	
	private int getNextCellIndex(int diceCount, int boardSize) {
		if(diceCount + currentBlock >= boardSize) {
			return (diceCount + currentBlock) - boardSize;
		} else {
			return diceCount + currentBlock;
		}
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public void updateWorth(int amount) {
		worth = worth + amount;
	}

	public int getWorth() {
		return worth + (ownedHotels.size() * 200);
	}

	public int compareTo(Object obj) {
		if(!(obj instanceof Player)) {
			return -1;
		}
		Player p = (Player) obj;
		if(this.worth > p.worth) {
			return -1;
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Player [worth=" + worth + ", currentBlock=" + currentBlock + "]";
	}

	public int getId() {
		return id;
	}
}

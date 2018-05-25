package com.aqb.entities;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private static Board board;
	private List<Cell> boardCells;
	private int numberOfCells;

	private Board() {
		boardCells = new ArrayList<Cell>();
		numberOfCells = 0;
	}
	
	public static Board getInstance() {
		if(board == null) {
			board = new Board();
		}
		return board;
	}

	public Board addNextCell(char cellIdentifier) {
		CellFactory factory = new CellFactory();
		Cell newCell = factory.getCell(cellIdentifier, numberOfCells++);
		boardCells.add(newCell);
		return this;
	}

	public Cell getCellAt(int index) {
		return boardCells.get(index);
	}

	public int getNumberOfCells() {
		return numberOfCells;
	}
}

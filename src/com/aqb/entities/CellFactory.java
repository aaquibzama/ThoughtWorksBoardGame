package com.aqb.entities;

public class CellFactory {

	public Cell getCell(char cellIdentifier, int cellNumber) {
		switch(cellIdentifier) {
		case 'E':
			return new EmptyCell(cellNumber);
		case 'J':
			return new Jail(cellNumber);
		case 'T':
			return new Treasure(cellNumber);
		case 'H':
			return new Hotel(cellNumber);
		}
		return new EmptyCell(cellNumber);
	}
}

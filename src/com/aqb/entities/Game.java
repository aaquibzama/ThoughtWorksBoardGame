package com.aqb.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

	private static final int NUMBER_OF_PLAYERS = 3;
	private static final String CELL_POSITIONS_AND_TYPES = "E,E,J,H,E,T,J,T,E,E,H,J,T,H,E";
	private static int numberOfTotalMoves = 30;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			playerList.add(new Player(i));
		}
		Board board = Board.getInstance();
		String[] strArray = CELL_POSITIONS_AND_TYPES.split(",");
		for (int i = 0; i < strArray.length; i++) {
			char cellIdentifier = strArray[i].charAt(0);
			board.addNextCell(cellIdentifier);
		}

		while (numberOfTotalMoves > 0) {
			int playerTurn = numberOfTotalMoves % NUMBER_OF_PLAYERS;
			if (playerTurn == 0) {
				playerList.get(NUMBER_OF_PLAYERS - playerTurn - 1).play();
			}
			numberOfTotalMoves--;
		}

		Collections.sort(playerList);
		for (int i = 0; i < playerList.size(); i++) {
			Player pl = playerList.get(i);
			System.out.println("Player-" + (pl.getId() + 1) + " has total worth " + pl.getWorth());

		}
	}

}

package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

public class GameImpl implements Game {
    private static final int MAXIMUM_GAME_POINT = 11;
    private int gamePointPlayerOne = 0;
    private int gamePointPlayerTwo = 0;

    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            playerOneTurn(playerOne, pingPongTable);

            if (gamePointPlayerTwo == MAXIMUM_GAME_POINT) {
                System.out.println("Игрок 2 одержал победу! Поздравляем!");
                gameIsRunning = false;
            } else {
                playerTwoTurn(playerTwo, pingPongTable);
            }

            if (gamePointPlayerOne == MAXIMUM_GAME_POINT) {
                System.out.println("Игрок 1 одержал победу! Поздравляем!");
                gameIsRunning = false;
            }
        }
    }

    private void playerOneTurn(Player playerOne, PingPongTableImpl pingPongTable) {
        TablePoint hit = playerOne.hit();
        if (pingPongTable.getPlayerTwoTablePoints().contains(hit)) {
            System.out.println("\nИгрок 1 попал по столу соперника." +
                    "\nМяч попал в точку " + hit);
        } else {
            System.out.println("\nИгрок 1 не попал по столу соперника." +
                    "\nМяч попал в точку " + hit);
            gamePointPlayerTwo++;
            System.out.println("Счет становится " + gamePointPlayerOne + " - " + gamePointPlayerTwo);
        }
    }

    private void playerTwoTurn(Player playerTwo, PingPongTableImpl pingPongTable) {
        TablePoint hit = playerTwo.hit();
        if (pingPongTable.getPlayerOneTablePoints().contains(hit)) {
            System.out.println("\nИгрок 2 попал по столу соперника." +
                    "\nМяч попал в точку " + hit);
        } else {
            System.out.println("\nИгрок 2 не попал по столу соперника." +
                    "\nМяч попал в точку " + hit);
            gamePointPlayerOne++;
            System.out.println("Счет становится " + gamePointPlayerOne + " - " + gamePointPlayerTwo);
        }
    }
}

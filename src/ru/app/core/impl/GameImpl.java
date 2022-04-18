package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

public class GameImpl implements Game {
    private static final int MAXIMUM_GAME_POINT = 11;
    private boolean shift = true;
    private int gamePointFirstPlayer = 0;
    private int gamePointSecondPlayer = 0;
    private Player playerOne;
    private Player playerTwo;

    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {
        this.playerOne=playerOne;
        this.playerTwo = playerTwo;
        while (gamePointFirstPlayer < MAXIMUM_GAME_POINT && gamePointSecondPlayer < MAXIMUM_GAME_POINT) {
            if (shift) {
                gamePointSecondPlayer = hitPlayer(playerOne, playerTwo, gamePointSecondPlayer);
            } else {
                gamePointFirstPlayer = hitPlayer(playerTwo, playerOne, gamePointFirstPlayer);
            }
        }
        Player winePlayer = gamePointFirstPlayer == MAXIMUM_GAME_POINT ? playerOne : playerTwo;

        System.out.println("Поздравляем," + winePlayer + " выиграл в турнире среди космонавтов.Общий счет игры: "
                + gamePointFirstPlayer + "-" + gamePointSecondPlayer);
    }

    private int hitPlayer(Player hitter, Player survivor, int gamePointPlayer) {
        TablePoint hitFirst = hitter.hit();
        if (survivor.getPlayerTablePoints().contains(hitFirst)) {
            System.out.println(hitter + " попал.Удар зафиксирован в точке " + hitFirst);
        } else {
            System.out.println(hitter + " промахнулся.Удар зафиксирован в точке " + hitFirst);
            gamePointPlayer++;
            if (hitter.equals(playerTwo)) {
                System.out.println("Cчет игры:" + gamePointPlayer + "-" + gamePointSecondPlayer);
            } else {
                System.out.println("Cчет игры:" + gamePointFirstPlayer + "-" + gamePointPlayer);
            }
        }
        shift = !shift;
        return gamePointPlayer;
    }
}
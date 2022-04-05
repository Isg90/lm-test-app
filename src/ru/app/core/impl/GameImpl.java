package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

public class GameImpl implements Game {
    private static final int MAXIMUM_GAME_POINT = 11;

    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {

        int pointPlayerOne = 0;
        int pointPlayerTwo = 0;
        boolean turn = true;

        while (pointPlayerOne < MAXIMUM_GAME_POINT && pointPlayerTwo < MAXIMUM_GAME_POINT) {
            TablePoint hitPoint;
            if (turn) {
                hitPoint = playerOne.hit();
                if (playerTwo.getPlayerTablePoints().contains(hitPoint)) {
                    System.out.println("Игрок 1 попал, координаты броска: " + hitPoint);
                    pointPlayerOne++;
                } else {
                    System.out.println("Игрок 1 промазал, координаты броска: " + hitPoint);
                    pointPlayerTwo++;
                    turn = false;
                }
            } else {
                hitPoint = playerTwo.hit();
                if (playerOne.getPlayerTablePoints().contains(hitPoint)) {
                    System.out.println("Игрок 2 попал, координаты броска: " + hitPoint);
                    pointPlayerTwo++;
                } else {
                    System.out.println("Игрок 2 промазал, координаты броска: " + hitPoint);
                    pointPlayerOne++;
                    turn = true;
                }
            }
            System.out.println("Общий счет: игрок 1: " + pointPlayerOne + " игрок 2: " + pointPlayerTwo);
        }
        System.out.println("Победил игрок №" + (pointPlayerOne == MAXIMUM_GAME_POINT ? 1 : 2));
    }
}
        //TODO напиши здесь реализацию игры в пинг-понг двух игроков, используя их имплементации
        // алгоритм реализации:
        // При каждом ударе игрока производится проверка, попал ли игрок по столу соперника или нет.
        // Факт удара фиксируется в console (попал или не попал и по какой точке был совершен удар).
        // В случае, если игрок не попадает по столу соперника, очко присуждается его оппонента (общий счет выводится в консоль).
        // Очко разыгрывается до тех пор, пока один из игроков не промахнется по столу соперника.
        // Очки суммируются и тот, кто наберет первым 11 очков, будет победителем.


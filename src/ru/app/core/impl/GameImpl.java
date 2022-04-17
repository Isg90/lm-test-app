package ru.app.core.impl;

import ru.app.core.Game;
import ru.app.core.Player;

public class GameImpl implements Game {
    private static int MAXIMUM_GAME_POINT = 11;
    private static int PLAYER_ONE_SCORE = 0;
    private static int PLAYER_TWO_SCORE = 0;

    @Override
    public void run(PingPongTableImpl pingPongTable, Player playerOne, Player playerTwo) {
        //TODO напиши здесь реализацию игры в пинг-понг двух игроков, используя их имплементации
        // алгоритм реализации:
        // При каждом ударе игрока производится проверка, попал ли игрок по столу соперника или нет.
        // Факт удара фиксируется в console (попал или не попал и по какой точке был совершен удар).
        // В случае, если игрок не попадает по столу соперника, очко присуждается его оппонента (общий счет выводится в консоль).
        // Очко разыгрывается до тех пор, пока один из игроков не промахнется по столу соперника.
        // Очки суммируются и тот, кто наберет первым 11 очков, будет победителем.
        while (PLAYER_ONE_SCORE < MAXIMUM_GAME_POINT || PLAYER_TWO_SCORE < MAXIMUM_GAME_POINT) {

            firstPlayerHit(playerOne, pingPongTable);
            secondPlayerHit(playerTwo, pingPongTable);

            if(PLAYER_ONE_SCORE == MAXIMUM_GAME_POINT){
                System.out.println("Победил первый игрок! Игра окончена");
                break;
            }
            else if (PLAYER_TWO_SCORE == MAXIMUM_GAME_POINT){
                System.out.println("Победил второй игрок! Игра окончена!");
                break;
            }
        }
    }
    public static void firstPlayerHit(Player playerOne,PingPongTableImpl pingPongTable){
        TablePoint gamePoing;
        System.out.println("Удар первого игрока!");
        gamePoing = playerOne.hit();
        if(pingPongTable.getPlayerTwoTablePoints().contains(gamePoing)){
            System.out.println("Первый игрок попал!");
            return;
        }
        else{
            System.out.println("Первый игрок промахнулся!");
            if(PLAYER_TWO_SCORE == MAXIMUM_GAME_POINT){
                return;
            }
            PLAYER_TWO_SCORE++;
            System.out.println("Очко присуждается второму игроку. Счет первого игрока: " + PLAYER_ONE_SCORE + " Счет второго игрока: " + PLAYER_TWO_SCORE);

        }
    }
    public static void secondPlayerHit(Player playerTwo, PingPongTableImpl pingPongTable) {
        TablePoint gamePoing;
        System.out.println("Удар второго игрока!");
        gamePoing = playerTwo.hit();
        if (pingPongTable.getPlayerOneTablePoints().contains(gamePoing)) {
            System.out.println("Второй игрок попал!");
            return;
        } else {
            System.out.println("Второй игрок промахнулся!");
            if (PLAYER_ONE_SCORE == MAXIMUM_GAME_POINT){
                return;
            }
            PLAYER_ONE_SCORE++;
            System.out.println("Очко присуждается первому игроку. Счет первого игрока: " + PLAYER_ONE_SCORE + " Счет второго игрока: " + PLAYER_TWO_SCORE);

        }
    }
}



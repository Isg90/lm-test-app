package ru.app;

import ru.app.core.impl.GameImpl;
import ru.app.core.impl.PingPongTableImpl;
import ru.app.core.impl.PlayerImpl;

public class Main {

    public static void main(String[] args) {
        var pingPongTable = new PingPongTableImpl();
        var game = new GameImpl();

        var playerOne = new PlayerImpl("Гагарин",
                pingPongTable.getPlayerOneTablePoints(),
                pingPongTable.getPlayerOneTablePointsForShouting()
        );

        var playerTwo = new PlayerImpl("Титов",
                pingPongTable.getPlayerTwoTablePoints(),
                pingPongTable.getPlayerTwoTablePointsForShouting()
        );

        game.run(pingPongTable, playerOne, playerTwo);
    }
}

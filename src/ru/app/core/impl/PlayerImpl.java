package ru.app.core.impl;

import ru.app.core.Player;

import java.util.Random;
import java.util.Set;

public class PlayerImpl implements Player {

    private Set<TablePoint> playerTablePoints;
    private Set<TablePoint> pointsForShouting;

    public PlayerImpl(Set<TablePoint> playerTablePoints, Set<TablePoint> pointsForShouting) {
        this.playerTablePoints = playerTablePoints;
        this.pointsForShouting = pointsForShouting;
    }

    @Override
    public TablePoint hit() {
        //TODO напиши здесь реализацию удара ракеткой,
        // возвращающего рандомную точку из pointsForShouting
        Random random = new Random();
        TablePoint[] tablePoints =  pointsForShouting.toArray(new TablePoint[pointsForShouting.size()]);
        TablePoint tablePoint = tablePoints[random.nextInt(tablePoints.length)];
        System.out.println("Удар по точке " + tablePoint);
        return tablePoint;
    }
}

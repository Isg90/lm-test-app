package ru.app.core.impl;

import ru.app.core.PingPongTable;

import java.util.HashSet;
import java.util.Set;

public class PingPongTableImpl implements PingPongTable {

    private Set<TablePoint> tablePoints;
    private Set<TablePoint> playerOneTablePoints;
    private Set<TablePoint> playerTwoTablePoints;
    private Set<TablePoint> playerOneTablePointsForShouting;
    private Set<TablePoint> playerTwoTablePointsForShouting;
    private static final int TABLE_SIZE_IN_POINTS = 10;
    private static final TablePoint LEFT_TOP_POINT = new TablePoint(1, 1);

    public PingPongTableImpl() {
        System.out.println("Generate table");
        tablePoints = buildTablePoints(LEFT_TOP_POINT, TABLE_SIZE_IN_POINTS, TABLE_SIZE_IN_POINTS);
        playerOneTablePoints = buildTablePoints(new TablePoint(3, 2), 6, 4);
        playerTwoTablePoints = buildTablePoints(new TablePoint(3, 6), 6, 4);

        playerOneTablePointsForShouting = getPointForShouting(tablePoints, playerOneTablePoints);
        playerTwoTablePointsForShouting = getPointForShouting(tablePoints, playerTwoTablePoints);
        System.out.println("Table generated successfully");
    }

    @Override
    public Set<TablePoint> getPlayerOneTablePoints() {
        return playerOneTablePoints;
    }

    @Override
    public Set<TablePoint> getPlayerTwoTablePoints() {
        return playerTwoTablePoints;
    }

    @Override
    public Set<TablePoint> getPlayerOneTablePointsForShouting() {
        return playerOneTablePointsForShouting;
    }

    @Override
    public Set<TablePoint> getPlayerTwoTablePointsForShouting() {
        return playerTwoTablePointsForShouting;
    }

    private Set<TablePoint> getPointForShouting(Set<TablePoint> allPoints, Set<TablePoint> excludedPoints) {
        Set<TablePoint> pointForShouting = new HashSet<>(allPoints);
        pointForShouting.removeAll(excludedPoints);

        System.out.println("Player points for shouting" + pointForShouting);
        return pointForShouting;
    }

    private Set<TablePoint> buildTablePoints(TablePoint startPoint, int pointsByX, int pointsByY) {
        Set<TablePoint> tablePoints = new HashSet<>();
        for(int i = startPoint.x; i < startPoint.x + pointsByX; i++) {
            for (int j = startPoint.y; j < startPoint.y + pointsByY; j++) {
                tablePoints.add(new TablePoint(i, j));
            }
        }

        System.out.println("Created tablePoints: " + tablePoints);
        return tablePoints;
    }
}
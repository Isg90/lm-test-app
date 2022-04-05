package ru.app.core.impl;

import ru.app.core.Player;

import java.util.Set;

public class PlayerImpl implements Player {

    private Set<TablePoint> playerTablePoints;
    private Set<TablePoint> pointsForShouting;

    public PlayerImpl(Set<TablePoint> playerTablePoints, Set<TablePoint> pointsForShouting) {
        this.playerTablePoints = playerTablePoints;
        this.pointsForShouting = pointsForShouting;
    }

    @Override
    public Set<TablePoint> getPlayerTablePoints() {
        return playerTablePoints;
    }

    public Set<TablePoint> getPointsForShouting() {
        return pointsForShouting;
    }

    @Override
    public TablePoint hit() {

        TablePoint hitPoint = null;
        int sizeSet = getPointsForShouting().size();
        int random = (int) (Math.random() * sizeSet);
        int i = 0;
        for (TablePoint point : getPointsForShouting()) {
            if (i == random) {
                hitPoint = point;
                break;
            }
            i++;
        }
        return hitPoint;
    }
}
        //TODO напиши здесь реализацию удара ракеткой,
        // возвращающего рандомную точку из pointsForShouting


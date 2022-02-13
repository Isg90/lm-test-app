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
    public TablePoint hit() {
        int randomTablePoint = (int) (Math.random() * pointsForShouting.size());
        return pointsForShouting.stream().toList().get(randomTablePoint);
    }
}

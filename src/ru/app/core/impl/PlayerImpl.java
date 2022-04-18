package ru.app.core.impl;

import ru.app.core.Player;
import ru.app.core.errors.HitException;

import java.util.Random;
import java.util.Set;

public class PlayerImpl implements Player {
    private final String name;

    private final Set<TablePoint> playerTablePoints;

    public PlayerImpl(String name, Set<TablePoint> playerTablePoints, Set<TablePoint> pointsForShouting) {
        this.name = name;
        this.playerTablePoints = playerTablePoints;
        this.pointsForShouting = pointsForShouting;
    }

    public Set<TablePoint> getPlayerTablePoints() {
        return playerTablePoints;
    }

    public Set<TablePoint> getPointsForShouting() {
        return pointsForShouting;
    }

    private final Set<TablePoint> pointsForShouting;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public TablePoint hit() {
        return getPointsForShouting().stream()
                .skip(new Random().nextInt(getPointsForShouting().size()))
                .findFirst().orElseThrow(HitException::new);
    }
}

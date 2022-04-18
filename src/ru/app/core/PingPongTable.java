package ru.app.core;

import ru.app.core.impl.TablePoint;

import java.util.Set;

public interface PingPongTable {
    Set<TablePoint> getPlayerOneTablePoints();
    Set<TablePoint> getPlayerTwoTablePoints();
    Set<TablePoint> getPlayerOneTablePointsForShouting();
    Set<TablePoint> getPlayerTwoTablePointsForShouting();
}

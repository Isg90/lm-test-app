package ru.app.core;

import ru.app.core.impl.TablePoint;

import java.util.Set;

public interface Player {
    TablePoint hit();

    Set<TablePoint> getPlayerTablePoints();
}

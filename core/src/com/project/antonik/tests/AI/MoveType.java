package com.project.antonik.tests.AI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by VladimirE on 16.03.2016.
 */
public enum MoveType {
    TOP, RIGHT, BOTTOM, LEFT, INSPECT, IDLE, EMPTY;

    private static final List<MoveType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MoveType random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

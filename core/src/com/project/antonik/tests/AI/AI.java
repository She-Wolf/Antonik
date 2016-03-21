package com.project.antonik.tests.AI;

import com.project.antonik.tests.Units.Unit;
import java.util.List;
import java.util.Random;

/**
 * Created by VladimirE on 16.03.2016.
 */

public class AI {

    Unit unit;

    AI(Unit unit){
        this.unit = unit;
    }

    public Move getNextMove(){
        Random rnd = new Random();
        List<Move> legalMoves = this.unit.getLegalMoves();
        return legalMoves.get(rnd.nextInt(legalMoves.size()));
    }

}

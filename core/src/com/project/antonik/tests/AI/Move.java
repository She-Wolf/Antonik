package com.project.antonik.tests.AI;

/**
 * Created by VladimirE on 16.03.2016.
 */

public class Move {
    private MoveType type;

    /*implement unit's move model here*/
    public Move(MoveType type){
        this.type = type;
    }

    public void setMoveType(MoveType type){
        this.type = type;
    }

    public MoveType getMoveType(){
        return this.type;
    }

    public static Move emptyMove(){
        return new Move(MoveType.EMPTY);
    }

    public static Move randomMove(){
        return new Move(MoveType.random());
    }
}

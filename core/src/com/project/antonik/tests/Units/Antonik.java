package com.project.antonik.tests.Units;

import com.project.antonik.tests.AI.Move;
import com.project.antonik.tests.Location.World;

import java.util.List;

/**
 * Created by GeneA on 08.03.2016.
 */

public class Antonik extends Unit {

    public Antonik(int x, int y, int viewLen, int viewAngle){
        X = x;
        Y = y;
        this.viewLen = viewLen; //дальность видимости
        this.viewAngle = viewAngle; //угол видимости
    }

    public int viewLen;
    public int viewAngle;

    public int arrestedCount = 0; //количнство пойманных

    public void moveUp() { } //ход
    public void moveRight() { }
    public void moveLeft() { }
    public void moveDown() { }


    @Override
    public List<Move> getLegalMoves(){
        return World.getLegalMovesAntonik();
    }
   /* public boolean hasMoveUp() { } //проверка возможности ходить
    public boolean hasMoveRight() { }
    public boolean hasMoveLeft() { }
    public boolean hasMoveDown() { }

    public Boolean inspectOpportunity() {  } // проверяет, может ли кого-нибудь шманать Антоник, т.е. есть ли студент рядом
*/
}

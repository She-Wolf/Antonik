package com.project.antonik.android.Units;

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

    public boolean hasMoveUp() { } //проверка возможности ходить
    public boolean hasMoveRight() { }
    public boolean hasMoveLeft() { }
    public boolean hasMoveDown() { }

    public Boolean inspectOpportunity() {  } // проверяет, может ли кого-нибудь шманать Антоник, т.е. есть ли студент рядом

}

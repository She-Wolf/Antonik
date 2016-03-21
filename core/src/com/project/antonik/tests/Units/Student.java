package com.project.antonik.tests.Units;

import com.project.antonik.tests.AI.Move;
import com.project.antonik.tests.Location.World;

import java.util.List;

/**
 * Created by GeneA on 08.03.2016.
 */

public class Student extends Unit {

    public Student(int x, int y, int disguise){
        X = x;  //начальные координаты
        Y = y;
        this.disguise = disguise;  //навык маскировки
    }

    /*public Boolean inspectOpportunity() { }  //может лди шманаться сейчас игрок? Шмон может вестись из любой из 8 соседник клеток
*/
    public int disguise; //навык маскировки

    public Boolean writeOffNowState = false; //списывает ли мейчас игрок?
    public Boolean arrestedState    = false; //арестован ли игрок антоником, т.е. проиграл
    public Boolean winState         = false; //успех

    public Boolean inAntonikViewState; //описывает, в зоне видимости Антоника ли игрок

    public int writeOffProgress = 0; //прогресс успеха

    public void writeOffStart() {  } //начинает списывание, тут должна вызываться случайная миниигра, и меняться состояние

    public void writeOffStop() {  } //заканчивает списывание

    public void luck(int k) { //увеличивает успех в зависимости от успеха в миниигре на k процентов
        writeOffProgress += k;
    }

    public void arrested() { } //рест игрока, Антоник рад

    @Override
    public List<Move> getLegalMoves(){
        return World.getLegalMovesStudent(this);
    }
}

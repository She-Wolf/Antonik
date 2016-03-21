package com.project.antonik.tests.Units;

/*import com.project.antonik.android.Location.Position;*/

import com.project.antonik.tests.AI.Move;
import com.project.antonik.tests.Location.World;

import java.util.Collections;
import java.util.List;

//базовый класс игрового юнита
public class Unit {

    public int X;
    public int Y;


    public List<Move> getLegalMoves(){
        return Collections.emptyList();
    }
    /*public Position getPosition() { }*/

}

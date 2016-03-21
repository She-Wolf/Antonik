package com.project.antonik.tests.Location;

import com.project.antonik.tests.AI.Move;
import com.project.antonik.tests.Units.Antonik;
import com.project.antonik.tests.Units.Student;

import java.util.Collections;
import java.util.List;

/**
 * Created by VladimirE on 16.03.2016.
 */
public class World {

    private Antonik antonik;
    private List<Student> students;

    public static List<Move> getLegalMovesAntonik(){
        return Collections.emptyList();
    }

    public static List<Move> getLegalMovesStudent(Student student){
        return Collections.emptyList();
    }

    public static List<Student> getVisibleStudentsForAntonik(){
        return Collections.emptyList();
    }
}

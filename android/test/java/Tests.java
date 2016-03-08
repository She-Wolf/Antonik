package java;

import com.project.antonik.android.Location.Map;
import com.project.antonik.android.Location.Position;
import com.project.antonik.android.Location.Size;
import com.project.antonik.android.Location.Table;
import com.project.antonik.android.Units.Antonik;
import com.project.antonik.android.Units.Student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Tests {

    Map map;
    Antonik antonik;
    Student student_1;
    Student student_2;
    Student student_3;

    @Before
    public void before() {
        Map map = new Map(10, 10);

        Student student_1 = new Student(1, 1, 5);
        Student student_2 = new Student(2, 1, 5);
        Student student_3 = new Student(3, 1, 5);

        Antonik antonik   = new Antonik(2, 2, 5, 90);
    }

    @Test
    public void inspectAntonikMoveWithTable() {
        antonik.X = 3;
        assertEquals(antonik.hasMoveUp(), true);
        antonik.moveUp();
        assertEquals(antonik.hasMoveUp(), false);
    }

    @Test
    public void inspectAntonikMoveWithMap() {
        antonik.X = 1;
        antonik.Y = 5;
        assertEquals(antonik.hasMoveUp(), true);
        antonik.moveUp();
        assertEquals(antonik.hasMoveUp(), false);
    }

    @Test
    public void inspectAntonikHasMove() {
        Table table = new Table(2,2,1,2);

        antonik.moveDown();
        antonik.moveRight();
        assertEquals(antonik.getPosition(), new Position(1,3));
    }

    @Test
    public void inspectInViewState() {
        antonik.X = 2;
        antonik.Y = 4;
        antonik.moveUp();
        assertEquals(student_1.inAntonikViewState, true);
        assertEquals(student_2.inAntonikViewState, true);
        assertEquals(student_3.inAntonikViewState, true);

        Student student_4 = new Student(4, 4, 5);
        assertEquals(student_4.inAntonikViewState, false);
    }

    @Test
    public void inspectOpportunityAntonik() {
        assertEquals(antonik.inspectOpportunity(), true);
        antonik.moveUp();
        assertEquals(antonik.inspectOpportunity(), false);
    }

    @Test
    public void inspectOpportunityStudent() {
        assertEquals(student_1.inspectOpportunity(), true);
        assertEquals(student_2.inspectOpportunity(), true);
        assertEquals(student_1.inspectOpportunity(), true);
        antonik.moveLeft();
        assertEquals(student_1.inspectOpportunity(), true);
        assertEquals(student_2.inspectOpportunity(), true);
        assertEquals(student_1.inspectOpportunity(), false);

    }

    @Test
    public void inspectStudentLuck() {
        student_1.luck(3);
        student_1.luck(1);
        assertEquals(student_1.writeOffProgress, 4);
    }

    @Test
    public void inspectwriteOffStates() {
        student_1.writeOffStart();
        student_2.writeOffStart();
        student_1.writeOffStop();
        assertEquals(student_1.writeOffNowState, false);
        assertEquals(student_1.writeOffNowState, true);
    }

    @Test
    public void inspectArrestedCount() {
        student_1.arrested();
        student_3.arrested();
        assertEquals(antonik.arrestedCount, 2);
    }

    @Test
    public void inspectMap() {
        assertEquals(map.getSize(), new Size(10, 10));
    }

    @Test(expected = OutSizeException.class)
    public void inspectMapOutSize1() {
        map = new Map(-1, 1);
    }

    @Test(expected = OutSizeException.class)
    public void inspectMapOutSize2() {
        map = new Map(0, 0);
    }


}

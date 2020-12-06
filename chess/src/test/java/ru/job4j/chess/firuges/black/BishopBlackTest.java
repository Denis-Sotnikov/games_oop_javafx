package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.position();
        assertThat(bishopBlack.position(),is(Cell.A1));
    }

    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack = (BishopBlack) bishopBlack.copy(Cell.A3);
        assertThat(bishopBlack.position(),is(Cell.A3));
    }


    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] array = bishopBlack.way(Cell.G5);
        Cell[] box = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(array,is(box));


    }

    public void testIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean flag = bishopBlack.isDiagonal(bishopBlack.position(), Cell.G5);
        assertThat(flag,is(true));
    }
}
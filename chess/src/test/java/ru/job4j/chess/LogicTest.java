package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Test
    public void WhenOpenWaymove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
            Logic logic = new Logic();
            BishopBlack bishopBlack = new BishopBlack(Cell.C1);
            logic.add(bishopBlack);
            logic.move(Cell.C1, Cell.E3);
        }

    @Test(expected = OccupiedCellException.class)
    public void WhenClosedWaymove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.add(new KingBlack(Cell.D2));
        logic.move(Cell.C1, Cell.E3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void WhenFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.E3);
    }
}
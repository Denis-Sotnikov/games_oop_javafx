package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", this.position, dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int x = this.position.getX();
        int y = this.position.getY();
        int deltaX = this.position.getX() > dest.getX()?-1:1;
        int deltaY = this.position.getY() > dest.getY()?-1:1;
        for (int index = 0; index < size; index++) {
            x = x + deltaX;
            y = y + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean diagonal = true;
        int size_X = Math.abs(this.position.getX() - dest.getX());
        int size_Y = Math.abs(this.position.getY() - dest.getY());
        return diagonal = size_X == size_Y ? true : false;
}

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

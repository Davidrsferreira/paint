package org.academiadecodigo.whiledlins.cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.whiledlins.paint.Paint.*;

public class Cell {

    private Rectangle cell;
    private Color color;
    private int x;
    private int y;
    private boolean painted;

    public Cell(int col, int row, Color color) {

        cell = new Rectangle(PADDING + (CELL_SIZE * col), PADDING + (CELL_SIZE * row), CELL_SIZE, CELL_SIZE);
        cell.setColor(color);
        painted = true;
        x = col;
        y = row;

    }

    public void moveLeft() {

        if ((cell.getX() - CELL_SIZE) < 0) return;

        cell.translate(-CELL_SIZE, 0);
        y = getY() - 1;

    }

    public void moveRight() {

        if ((cell.getX() + CELL_SIZE) > WIDTH) return;

        cell.translate(CELL_SIZE, 0);
        y = getY() + 1;

    }

    public void moveUp() {

        if ((cell.getY() - CELL_SIZE) < 0) return;

        cell.translate( 0, -CELL_SIZE);
        x = getX() - 1;

    }

    public void moveDown() {

        if ((cell.getY() + CELL_SIZE) > HEIGHT) return;

        cell.translate(0, CELL_SIZE);
        x = getX() + 1;

    }

    public void paint(){

        if (painted){
            cell.draw();
            painted = false;
            return;
        }

        cell.fill();
        painted = true;
    }

    public void clear(){
        cell.draw();
        painted = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPainted() {
        return painted;
    }
}

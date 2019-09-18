package org.academiadecodigo.whiledlings.cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.whiledlings.paint.Paint.*;

public class Cell {

    private Rectangle cell;
    private char color;
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

    public void paint(Color color){

        cell.setColor(color);

        setColor(color);

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

    private void setColor(Color color) {

        if (color == Color.BLACK){
            this.color = 'B';
            return;
        }

        if (color == Color.YELLOW){
            this.color = 'Y';
            return;
        }

        if (color == Color.RED){
            this.color = 'R';
            return;
        }

        if (color == Color.ORANGE){
            this.color = 'O';
            return;
        }
    }

    public char getColor() {
        return color;
    }
}

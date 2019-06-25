package org.academiadecodigo.whiledlins.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlins.cell.Cell;

import static org.academiadecodigo.whiledlins.paint.Paint.*;

public class PaintGfx {

    public Cell[][] drawPanel(){

        Rectangle view = new Rectangle(PADDING,PADDING, 25 * CELL_SIZE, 25 * CELL_SIZE);
        view.setColor(Color.GRAY);
        view.draw();

        Cell[][] cells = new Cell[ROWS][COLS];

        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells.length; j++){
                cells[i][j] = new Cell(j, i, Color.BLACK);
                cells[i][j].paint();
            }
        }

        return cells;

    }
}

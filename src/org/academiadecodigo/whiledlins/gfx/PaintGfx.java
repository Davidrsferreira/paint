package org.academiadecodigo.whiledlins.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PaintGfx {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 15;

    public void drawPainel(Rectangle[][] cells){

        Rectangle view = new Rectangle(PADDING,PADDING, 25 * CELL_SIZE, 25 * CELL_SIZE);
        view.setColor(Color.GRAY);
        view.draw();

        Rectangle cell;

        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells.length; j++){
                cell = new Rectangle(PADDING + (CELL_SIZE * j), PADDING + (CELL_SIZE * i), CELL_SIZE, CELL_SIZE);
                cell.setColor(Color.BLACK);
                cell.draw();
                cells[i][j] = cell;
            }
        }

    }
}

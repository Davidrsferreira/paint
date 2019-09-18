package org.academiadecodigo.whiledlings.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.whiledlings.paint.Paint.*;

public class PaintGfx {

    
    public Rectangle[][] drawPanel(){

        Rectangle view = new Rectangle(PADDING,PADDING, 25 * CELL_SIZE, 25 * CELL_SIZE);
        view.setColor(Color.GRAY);
        view.draw();

        Rectangle[][] cells = new Rectangle[ROWS][COLS];

        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells.length; j++){
                cells[i][j] = new Rectangle(PADDING + (CELL_SIZE * j), PADDING + (CELL_SIZE * i), CELL_SIZE, CELL_SIZE);
                cells[i][j].setColor(Color.BLACK);
                cells[i][j].draw();
            }
        }

        return cells;

    }
}

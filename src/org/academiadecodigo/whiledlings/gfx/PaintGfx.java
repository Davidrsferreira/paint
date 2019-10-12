package org.academiadecodigo.whiledlings.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.cell.Cell;

import static org.academiadecodigo.whiledlings.paint.Paint.*;

public class PaintGfx {

    public Cell[][] drawPanel(){

        Rectangle view = new Rectangle(PADDING,PADDING, ROWS * CELL_SIZE, COLS * CELL_SIZE);
        view.setColor(Color.GRAY);
        view.draw();

        drawButtons();

        Cell[][] cells = new Cell[ROWS][COLS];

        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells.length; j++){
                cells[i][j] = new Cell(j, i, Color.BLACK);
                cells[i][j].paint(Color.BLACK);
            }
        }

        return cells;

    }

    private void drawButtons(){

        Picture pic = new Picture((26 * CELL_SIZE) + 4, PADDING + 2, "./resources/disk.png");
        pic.draw();

        pic = new Picture((26 * CELL_SIZE) + 4, (PADDING * 4) + 2, "./resources/folder.png");
        pic.draw();

    }

}

package org.academiadecodigo.whiledlings.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.whiledlings.gfx.PaintGfx;
import org.academiadecodigo.whiledlings.gfx.Pointer;
import org.academiadecodigo.whiledlings.cell.Cell;

public class Paint {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 15;
    public static final int HEIGHT = 25 * CELL_SIZE;
    public static final int WIDTH = 25 * CELL_SIZE;
    public static final int ROWS = 25;
    public static final int COLS = 25;

    private Cell[][] cells;
    private PaintGfx paintGfx;

    public void init(){

        cells = new Cell[ROWS][COLS];
        paintGfx = new PaintGfx();

    }

    public void startGame() {

        cells = paintGfx.drawPanel();

        Pointer pointer = new Pointer(PADDING, PADDING, cells, Color.BLACK);
        pointer.paint(Color.BLACK);

    }
}

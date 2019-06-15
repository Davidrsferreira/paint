package org.academiadecodigo.whiledlins.paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlins.gfx.PaintGfx;
import org.academiadecodigo.whiledlins.gfx.Pencil;

public class Paint {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 15;
    public static final int HEIGHT = 25 * CELL_SIZE;
    public static final int WIDTH = 25 * CELL_SIZE;
    public static final int ROWS = 25;
    public static final int COLS = 25;

    private Rectangle[][] cells;
    private PaintGfx paintGfx;

    public void init(){

        cells = new Rectangle[ROWS][COLS];
        paintGfx = new PaintGfx();
        cells = paintGfx.drawPanel();

    }

    public void startGame() {

        Pencil pencil = new Pencil(PADDING, PADDING, CELL_SIZE, CELL_SIZE, cells);
        pencil.setColor(Color.GREEN);
        pencil.fill();

    }
}

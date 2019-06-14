package org.academiadecodigo.whiledlins.paint;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlins.gfx.PaintGfx;

public class Paint {

    private Rectangle[][] cells;
    private PaintGfx paintGfx;

    public void init(){

        cells = new Rectangle[25][25];
        paintGfx = new PaintGfx();
        paintGfx.drawPainel(cells);

    }

    public void startGame() {


    }
}

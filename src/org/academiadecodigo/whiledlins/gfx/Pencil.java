package org.academiadecodigo.whiledlins.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.whiledlins.paint.Paint.CELL_SIZE;
import static org.academiadecodigo.whiledlins.paint.Paint.HEIGHT;
import static org.academiadecodigo.whiledlins.paint.Paint.WIDTH;

public class Pencil extends Rectangle implements KeyboardHandler {
    
    private Keyboard keyboard;
    private Rectangle[][] cells;
    private int x;
    private int y;

    public Pencil(int x, int y, int cols, int rows, Rectangle[][] cells){
        super(x, y, cols, rows);
        keyboard = new Keyboard(this);
        this.cells = cells;
        init();

    }

    private void init() {

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(save);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if ((getX() - CELL_SIZE) < 0) return;
                this.translate(-CELL_SIZE,0);
                this.y = this.y - 1;
                break;

            case KeyboardEvent.KEY_RIGHT:
                if ((getX() + CELL_SIZE) > WIDTH) return;
                this.translate(CELL_SIZE,0);
                this.y = this.y + 1;
                break;

            case KeyboardEvent.KEY_UP:
                if ((getY() - CELL_SIZE) < 0) return;
                this.translate(0, -CELL_SIZE);
                this.x = this.x - 1;
                break;

            case KeyboardEvent.KEY_DOWN:
                if ((getY() + CELL_SIZE) > HEIGHT) return;
                this.translate(0, CELL_SIZE);
                this.x = this.x + 1;
                break;

            case KeyboardEvent.KEY_SPACE:
                if(cells[x][y].isFilled()){
                    cells[x][y].draw();
                } else {
                    cells[x][y].fill();
                }
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

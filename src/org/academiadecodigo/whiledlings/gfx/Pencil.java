package org.academiadecodigo.whiledlings.gfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.academiadecodigo.whiledlings.paint.Paint.*;

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

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(clear);

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
                break;

            case KeyboardEvent.KEY_S:

                FileOutputStream fileOutputStream;

                try {
                    fileOutputStream = new FileOutputStream("./resources/file.txt");
                    byte[] buffer = new byte[ROWS];

                    for (int i = 0; i < cells.length; i++){
                        for (int j = 0; j < cells.length; j++){
                            if (cells[i][j].isFilled()) {
                                buffer[j] = 1;
                            } else {
                                buffer[j] = 0;
                            }
                        }

                        fileOutputStream.write(buffer);
                    }

                    fileOutputStream.close();
                    clear();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case KeyboardEvent.KEY_L:

                FileInputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream("./resources/file.txt");

                    byte[] buffer = new byte[ROWS];
                    int row = 0;

                    while (fileInputStream.read(buffer) != -1) {

                        for (int i = 0; i < cells.length; i++) {
                            if (buffer[i] == 0) {
                                cells[row][i].draw();
                            } else {
                                cells[row][i].fill();
                            }
                        }
                        row++;
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case KeyboardEvent.KEY_C:
                clear();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //Not used.
    }

    private void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j].draw();
            }
        }
    }
}
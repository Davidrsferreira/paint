package org.academiadecodigo.whiledlings.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.whiledlings.cell.Cell;
import org.academiadecodigo.whiledlings.file.FileManager;

import static org.academiadecodigo.whiledlings.paint.Paint.CELL_SIZE;

public class Pointer extends Cell implements KeyboardHandler {

    private Keyboard keyboard;
    private Cell[][] cells;
    private FileManager fileManager;
    private Rectangle colorBlack;
    private Rectangle colorRed;
    private Rectangle colorYellow;
    private Rectangle colorOrange;
    private Rectangle select;
    private Color color;


    public Pointer(int x, int y, Cell[][] cells, Color color){
        super(x, y, color);
        drawColorButtons();
        paint(Color.GREEN);
        keyboard = new Keyboard(this);
        this.cells = cells;
        fileManager = new FileManager("./resources/file.txt");
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

        KeyboardEvent black = new KeyboardEvent();
        black.setKey(KeyboardEvent.KEY_B);
        black.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent red = new KeyboardEvent();
        red.setKey(KeyboardEvent.KEY_R);
        red.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent yellow = new KeyboardEvent();
        yellow.setKey(KeyboardEvent.KEY_Y);
        yellow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent orange = new KeyboardEvent();
        orange.setKey(KeyboardEvent.KEY_O);
        orange.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(clear);
        keyboard.addEventListener(black);
        keyboard.addEventListener(red);
        keyboard.addEventListener(yellow);
        keyboard.addEventListener(orange);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;

            case KeyboardEvent.KEY_UP:
                moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;

            case KeyboardEvent.KEY_SPACE:
                cells[getX()][getY()].paint(color);
                break;

            case KeyboardEvent.KEY_S:
                fileManager.save(cells);
                clear();
                break;

            case KeyboardEvent.KEY_L:
                clear();
                fileManager.load(cells);
                break;

            case KeyboardEvent.KEY_C:
                clear();
                break;

            case KeyboardEvent.KEY_B:
                selectBlack();
                break;

            case KeyboardEvent.KEY_R:
                selectRed();
                break;

            case KeyboardEvent.KEY_Y:
                selectYellow();
                break;

            case KeyboardEvent.KEY_O:
                selectOrange();
                break;

        }

    }

    private void selectRed() {
        select.translate(0,colorRed.getY() - (select.getY() + 2));
        color = Color.RED;
    }

    private void selectBlack() {
        select.translate(0, colorBlack.getY() - (select.getY() + 2));
        color = Color.BLACK;
    }

    private void selectYellow() {
        select.translate(0, colorYellow.getY() - (select.getY() + 2));
        color = Color.YELLOW;
    }

    private void selectOrange() {
        select.translate(0, colorOrange.getY() - (select.getY() + 2));
        color = Color.ORANGE;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //Not used.
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j].clear();
            }
        }
    }

    private void drawColorButtons(){

        colorBlack = new Rectangle((CELL_SIZE * 26) + 4, CELL_SIZE * 18, 25, 25);
        select = new Rectangle((CELL_SIZE * 26) + 2, (CELL_SIZE * 18) - 2, 29, 29);

        select.setColor(Color.GREEN);
        select.fill();

        colorBlack.setColor(Color.BLACK);
        colorBlack.fill();

        colorRed = new Rectangle((CELL_SIZE * 26) + 4, CELL_SIZE * 20, 25, 25);
        colorRed.setColor(Color.RED);
        colorRed.fill();

        colorYellow = new Rectangle((CELL_SIZE * 26) + 4, CELL_SIZE * 22, 25, 25);
        colorYellow.setColor(Color.YELLOW);
        colorYellow.fill();

        colorOrange = new Rectangle((CELL_SIZE * 26) + 4, CELL_SIZE * 24, 25, 25);
        colorOrange.setColor(Color.ORANGE);
        colorOrange.fill();

    }
}
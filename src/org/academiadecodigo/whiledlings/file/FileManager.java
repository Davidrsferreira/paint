package org.academiadecodigo.whiledlings.file;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.whiledlings.cell.Cell;

import java.io.*;

import static org.academiadecodigo.whiledlings.paint.Paint.ROWS;

public class FileManager {

    private String path;

    public FileManager(String path) {
        this.path = path;
    }


    public void save(Cell[][] cells) {

        FileWriter writer;

        try {

            writer = new FileWriter(path);
            BufferedWriter bWriter = new BufferedWriter(writer);
            String buffer = "";

            for (int i = 0; i < cells.length; i++) {

                for (int j = 0; j < cells.length; j++) {

                    if (cells[i][j].isPainted()) {

                        buffer += cells[i][j].getColor();

                    } else {

                        buffer += "B";

                    }
                }

                bWriter.write(buffer);
                bWriter.newLine();
                buffer = "";
            }

            bWriter.flush();
            bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(Cell[][] cells){

        FileReader fileReader;

        try {

            fileReader = new FileReader(path);

            char[] buffer = new char[ROWS + 2];
            int row = 0;

            while (fileReader.read(buffer) != -1) {

                for (int i = 0; i < cells.length; i++) {

                    if (buffer[i] == 'B'){

                        cells[row][i].setPainted();

                    }

                    cells[row][i].paint(getColor(buffer[i]));
                }

                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Color getColor(char color) {

        switch (color){

            case 'D':
                return Color.DARK_GRAY;

            case 'R':
                return Color.RED;

            case 'Y':
                return Color.YELLOW;

            case 'M':
                return Color.MAGENTA;
        }

        return Color.BLACK;
    }
}

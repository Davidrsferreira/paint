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
                        buffer = buffer + cells[i][j].getColor();
                    } else {
                        buffer = buffer + "W";
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

            char[] buffer = new char[ROWS + 1];
            int row = 0;

            while (fileReader.read(buffer) != -1) {

                for (int i = 0; i <= cells.length; i++) {

                    if (buffer[i] == '\n') continue;

                    if (buffer[i] == 'F') {
                        cells[row][i].paint(Color.GREEN);
                    }
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package org.academiadecodigo.whiledlins.file;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

import static org.academiadecodigo.whiledlins.paint.Paint.ROWS;

public class FileManager {

    private String path;

    public FileManager(String path) {
        this.path = path;
    }


    public void save(Rectangle[][] cells) {

        FileWriter writer;
        try {

            writer = new FileWriter(path);
            BufferedWriter bWriter = new BufferedWriter(writer);
            String buffer = "";

            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells.length; j++) {
                    if (cells[i][j].isFilled()) {
                        buffer = buffer;//getColor(cells[i][j]);
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

    public void load(Rectangle[][] cells){

        FileReader fileReader;
        try {
            fileReader = new FileReader(path);

            char[] buffer = new char[ROWS];
            int row = 0;

            while (fileReader.read(buffer) != -1) {

                for (int i = 0; i < cells.length; i++) {
                    if (buffer[i] == 0) {
                        cells[row][i].draw();
                    } else {
                        cells[row][i].fill();
                    }
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

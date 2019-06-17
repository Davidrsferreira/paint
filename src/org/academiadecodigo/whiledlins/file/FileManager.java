package org.academiadecodigo.whiledlins.file;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.academiadecodigo.whiledlins.paint.Paint.ROWS;

public class FileManager {

    private String path;

    public FileManager(String path) {
        this.path = path;
    }


    public void save(Rectangle[][] cells) {

        FileOutputStream fileOutputStream;
        try {

            fileOutputStream = new FileOutputStream(path);

            byte[] buffer = new byte[ROWS];

            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells.length; j++) {
                    if (cells[i][j].isFilled()) {
                        buffer[j] = 1;
                    } else {
                        buffer[j] = 0;
                    }
                }

                fileOutputStream.write(buffer);
            }

            fileOutputStream.close();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void load(Rectangle[][] cells){

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(path);

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
    }
}

package main;

import windows.FirstWindow;

import javax.swing.*;

/**
 * Created by roman on 11.08.16.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstWindow();
            }
        });
    }
}

// TODO: 15.08.16 Убрать хардкод 
// TODO: 15.08.16 Реализовать поддержку регулярных выражений, либо wildcard-символов
// TODO: 15.08.16 Реализовать поиск всех файлов с помощью символа * 
// TODO: 15.08.16 Создать файл readme, в котором описать возможности программы и все изменения 
// TODO: 15.08.16 Сделать javadoc'и


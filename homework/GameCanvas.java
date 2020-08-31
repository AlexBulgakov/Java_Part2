package ru.geekbrains.alexbulgakov.java_part2.lection1.homework;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private MainCircles controller;

    GameCanvas(MainCircles controller) {
        this.controller = controller;

        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;

        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }  // геттер левой границы холста
    public int getRight() { return getWidth() - 1; }  // геттер левой границы холста
    public int getTop() { return 0; }  // геттер верхней границы холста
    public int getBottom() { return getHeight() - 1; }  // геттер нижней границы холста
}

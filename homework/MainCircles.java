package ru.geekbrains.alexbulgakov.java_part2.lection1.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }


    private Sprite[] sprites = new Sprite[1];
    private int spriteCount;

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addSprite(new Ball(e.getX(), e.getY())); // не до конца понятно откуда взялись эти координаты
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite();
            }
        });

        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void addSprite(Sprite s) {
        if (spriteCount == sprites.length) {
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length);
            sprites = temp;
        }
        sprites[spriteCount++] = s;
    }

    private void removeSprite() {
        if (spriteCount > 1) spriteCount--;
    }
    
    private void initApplication() {
        sprites[0] = new Background();
        spriteCount++;
    }

    // Главный метод контроллера
    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spriteCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < spriteCount; i++) {
            sprites[i].render(canvas, g);
        }
    }


}

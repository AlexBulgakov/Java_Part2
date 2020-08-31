package ru.geekbrains.alexbulgakov.java_part2.lection1.homework;

import java.awt.*;

public class Background extends Sprite {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color bgColor;


    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        time += deltaTime;
        
        int r = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int g = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int b = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));

        bgColor = new Color(r, g, b);
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(bgColor);
    }
}

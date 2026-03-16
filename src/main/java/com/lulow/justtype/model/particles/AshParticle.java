package com.lulow.justtype.model.particles;

import javafx.scene.shape.Rectangle;

public class AshParticle extends ParticleAdapter {

    private final double xDrift;
    private final double ySpeed;
    private final double fadeRate;
    private double       opacity;

    public AshParticle(double xPos, double yPos, double xDrift, double ySpeed,
                       double opacity, double fadeRate, Rectangle render) {
        super(xPos, yPos, render);
        this.xDrift   = xDrift;
        this.ySpeed   = ySpeed;
        this.opacity  = opacity;
        this.fadeRate = fadeRate;
    }

    @Override
    public void update() {
        xPos    += xDrift;
        yPos    -= ySpeed;
        opacity -= fadeRate;

        render.setX(xPos);
        render.setY(yPos);
        render.setOpacity(Math.max(opacity, 0));
    }

    @Override
    public boolean isDead() { return opacity <= 0; }
}
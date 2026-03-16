package com.lulow.justtype.model.particles;

import javafx.scene.shape.Rectangle;

public class ConfettiParticle extends ParticleAdapter {

    private static final double GRAVITY        = 0.16;
    private static final double ROTATION_SPEED = 4.0;

    private double xVelocity;
    private double yVelocity;

    private static final double BASE_X_VELOCITY     = 1.0;
    private static final double BASE_Y_VELOCITY     = 2.0;
    private static final double X_VELOCITY_VARIANCE = 3.0;
    private static final double Y_VELOCITY_VARIANCE = 4.0;

    public ConfettiParticle(double xPos, double yPos, int direction, Rectangle render) {
        super(xPos, yPos, render);
        this.xVelocity = -direction * (BASE_X_VELOCITY + Math.random() * X_VELOCITY_VARIANCE);
        this.yVelocity = -(BASE_Y_VELOCITY + Math.random() * Y_VELOCITY_VARIANCE);
    }

    @Override
    public void update() {
        yVelocity += GRAVITY;
        xPos      += xVelocity;
        yPos      += yVelocity;

        render.setX(xPos);
        render.setY(yPos);
        render.setRotate(render.getRotate() + ROTATION_SPEED);
    }

    @Override
    public boolean isDead() { return false; }
}
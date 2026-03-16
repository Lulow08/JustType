package com.lulow.justtype.view.particles;

public interface IParticleEmitter {
    void play(double seconds);
    void stop();
    void setIntensity(int particlesPerFrame, double speedMultiplier);
}
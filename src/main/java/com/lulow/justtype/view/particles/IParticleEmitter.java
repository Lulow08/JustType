package com.lulow.justtype.view.particles;

public interface IParticleEmitter {
    void play(double seconds);
    void pause();
    void resume();
    void clear();
}

package com.lulow.justtype.view.particles;

import javafx.scene.shape.Rectangle;

public interface IParticleEmitter {
    void play(double seconds);
    void pause();
    void resume();
    void clear();
}

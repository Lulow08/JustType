package com.lulow.justtype.view.particles;

import javafx.scene.shape.Rectangle;

public abstract class ParticleEmitterAdapter implements IParticleEmitter {

    @Override public void play(double seconds) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void clear() {}
}

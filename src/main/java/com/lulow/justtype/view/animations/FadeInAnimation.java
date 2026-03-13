package com.lulow.justtype.view.animations;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeInAnimation extends AnimatorAdapter {

    private static final int FADE_DURATION_MS = 1000;

    private final FadeTransition fadeTransition;

    public FadeInAnimation(Node target) {
        fadeTransition = new FadeTransition(Duration.millis(FADE_DURATION_MS), target);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
    }

    @Override
    public void play() {
        fadeTransition.playFromStart();
    }
}
package com.lulow.justtype.view.animations;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class OvershootAnimation extends AnimatorAdapter {

    private static final int    EXPANDED_DURATION_MS = 90;
    private static final int    SHRINK_DURATION_MS = 90;
    private static final int    BACK_DURATION_MS = 80;

    private final ScaleTransition expand;
    private final ScaleTransition shrink;
    private final ScaleTransition settle;

    public OvershootAnimation(Node target, double overshootScale, double undershootScale) {
        expand = new ScaleTransition(Duration.millis(EXPANDED_DURATION_MS), target);
        expand.setFromX(overshootScale);
        expand.setFromY(overshootScale);
        expand.setToX(overshootScale);
        expand.setToY(overshootScale);

        shrink = new ScaleTransition(Duration.millis(SHRINK_DURATION_MS), target);
        shrink.setToX(undershootScale);
        shrink.setToY(undershootScale);

        settle = new ScaleTransition(Duration.millis(BACK_DURATION_MS), target);
        settle.setToX(1.0);
        settle.setToY(1.0);

        expand.setOnFinished(e -> shrink.play());
        shrink.setOnFinished(e -> settle.play());
    }

    @Override
    public void play() {
        shrink.stop();
        settle.stop();
        expand.play();
    }
}
package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;

    @FXML
    private Circle stopLight;

    @FXML
    private Circle holdLight;

    @FXML
    private Circle goLight;

    @FXML
    public void initialize() {
        // Setup and start the timeline
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        updateLights();
    }

    public void onTimerChange() {
        // Cycle through the traffic light colors
        switch (currentColor) {
            case STOP:
                currentColor = TrafficLightColor.HOLD;
                break;
            case HOLD:
                currentColor = TrafficLightColor.GO;
                break;
            case GO:
                currentColor = TrafficLightColor.STOP;
                break;
        }

        updateLights();
    }

    private void updateLights() {
        stopLight.setFill(currentColor == TrafficLightColor.STOP ? Color.RED : Color.web("#575757"));
        holdLight.setFill(currentColor == TrafficLightColor.HOLD ? Color.YELLOW : Color.web("#575757"));
        goLight.setFill(currentColor == TrafficLightColor.GO ? Color.GREEN : Color.web("#575757"));
    }
}
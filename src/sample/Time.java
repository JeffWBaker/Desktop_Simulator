package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Time {
    public Label timeLabel(){
        final Label clock = new Label();
        final DateFormat format = DateFormat.getInstance();
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
                        ZonedDateTime zdt = ZonedDateTime.now();
                        String zdtString  = formatter.format(zdt);
                        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        clock.setText(zdtString + "\n" + formatterDate.format(zdt));
                    }
                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        return clock;
    }
}

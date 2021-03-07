package dev.vultureweb.sample.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import dev.vultureweb.sample.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.function.Function;

public class ClockPresenter extends GluonPresenter<Main> {

    @FXML
    private View clock;

    @FXML
    private Text date;

    @FXML
    private Text time;

    @FXML
    private Arc hourHand;

    @FXML
    private Arc minuteHand;

    private final Function<Integer, Integer> startAngleMinute = (minutes) -> {
        int degrees = (60 - minutes) * 6;
        return degrees + 90;
    };

    private final Function<Integer, Integer> extentAngleMinute = (minutes) -> {
        int degrees = (60 - minutes) * 6;
        return 360 - degrees;
    };

    private final Function<Integer, Integer> startAngleHour = (hours) -> {
        int degrees = (12 - hours) * 30;
        return degrees + 90;
    };

    private final Function<Integer, Integer> extentAngleHour = (hours) -> {
        int degrees = (12 - hours) * 30;
        return 360 - degrees;
    };

    private final SimpleStringProperty timeProperty = new SimpleStringProperty();
    private final SimpleStringProperty dateProperty = new SimpleStringProperty();
    private final SimpleIntegerProperty minuteProperty = new SimpleIntegerProperty();
    private final SimpleIntegerProperty hourProperty = new SimpleIntegerProperty();

    public void initialize() {
        clock.setOnShowing(event -> {
            AppBar appBar = getApp().getAppBar();
            appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
            appBar.setTitleText("Clock");
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalDateTime now = LocalDateTime.now();
            timeProperty.setValue(DateTimeFormatter.ofPattern("HH:mm:ss").format(now.toLocalTime()));
            dateProperty.setValue(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now()));
            hourProperty.setValue(now.getHour());
            minuteProperty.set(now.getMinute());
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        LocalTime now = LocalTime.now();

        time.textProperty().bind(timeProperty);
        date.textProperty().bind(dateProperty);

        hourProperty.addListener(((obs, ov, nv) -> {
            int hours = normalizeHours(nv.intValue());
            System.out.println(hours);
            hourHand.setStartAngle(startAngleHour.apply(hours));
            hourHand.setLength(extentAngleHour.apply(hours));
        }));

        minuteProperty.addListener((observable, ov, nv) -> {
            minuteHand.setStartAngle(startAngleMinute.apply(nv.intValue()));
            minuteHand.setLength(extentAngleMinute.apply(nv.intValue()));
        });
    }

    private int normalizeHours(int hours) {
        return hours % 12;
    }

}

package dev.vultureweb.sample.views;

import com.gluonhq.attach.position.PositionService;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import javafx.scene.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import dev.vultureweb.sample.Main;
import javafx.fxml.FXML;

public class PositionPresenter extends GluonPresenter<Main> {

    @FXML
    private View position;

    @FXML
    private TextField longitude;

    @FXML
    private TextField latitude;

    @FXML
    private TextField altitude;

    public void initialize() {
        position.setOnShowing(event -> {
            AppBar appBar = getApp().getAppBar();
            appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
            appBar.setTitleText("Position");
        });

        PositionService.create().ifPresent(positionService -> {
            positionService.positionProperty().addListener((obs, ov, nv) -> {
                longitude.setText("" + nv.getLongitude());
                latitude.setText("" + nv.getLatitude());
                altitude.setText("" + nv.getAltitude());
            });
            positionService.start();
        });
    }
}

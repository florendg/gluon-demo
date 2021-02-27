package dev.vultureweb.sample.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import dev.vultureweb.sample.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class HomePresenter extends GluonPresenter<Main> {

    @FXML
    private View home;

    @FXML
    private Button button;

    @FXML
    private Label positionLabel;

    public void initialize() {
        home.showingProperty().addListener((obs,ov,nv)->{
            if(nv) {
                AppBar appBar = getApp().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
                appBar.setTitleText("Home");
            }
        });

    }

    @FXML
    public void onClick() {
        System.out.println("Hello");
    }



}

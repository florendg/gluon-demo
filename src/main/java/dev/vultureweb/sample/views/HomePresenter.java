package dev.vultureweb.sample.views;

import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import dev.vultureweb.sample.Main;
import javafx.fxml.FXML;


public class HomePresenter extends GluonPresenter<Main> {

    @FXML
    private View home;

    public void initialize() {
        home.showingProperty().addListener((obs,ov,nv)->{
            if(nv) {
                AppBar appBar = getApp().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApp().getDrawer().open()));
                appBar.setTitleText("Home");
            }
        });

        final FloatingActionButton floatingActionButton = new FloatingActionButton(MaterialDesignIcon.ADD.text,
                e->AppViewManager.HOME_VIEW.switchView());
        floatingActionButton.showOn(home);
    }

    @FXML
    public void onClick() {
        System.out.println("Hello");
    }



}

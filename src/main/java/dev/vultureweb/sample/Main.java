package dev.vultureweb.sample;

import com.gluonhq.attach.util.Constants;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;

public class Main extends MobileApplication {

    @Override
    public void init() {
        System.setProperty(Constants.ATTACH_DEBUG,"true");
        AppViewManager.registerViews(this);
    }

    @Override
    public void postInit(Scene scene) {
        AppViewManager.registerDrawer(this);
        Swatch.BLUE.assignTo(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

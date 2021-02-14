package dev.vultureweb.sample;

import com.gluonhq.charm.glisten.afterburner.AppView;
import com.gluonhq.charm.glisten.afterburner.AppViewRegistry;
import com.gluonhq.charm.glisten.afterburner.Utils;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import javafx.scene.image.Image;


public class AppViewManager {

    private static final AppViewRegistry REGISTRY = new AppViewRegistry();

    public static void registerViews(MobileApplication application) {
        for (AppView view : REGISTRY.getViews()) {
            view.registerView(application);
        }
    }

    public static void registerDrawer(MobileApplication app) {

    }
}

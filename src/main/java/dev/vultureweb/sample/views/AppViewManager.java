package dev.vultureweb.sample.views;

import com.gluonhq.charm.glisten.afterburner.AppView;
import com.gluonhq.charm.glisten.afterburner.AppViewRegistry;
import com.gluonhq.charm.glisten.afterburner.GluonPresenter;
import com.gluonhq.charm.glisten.afterburner.Utils;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import java.util.Locale;

public class AppViewManager {
    public static final AppViewRegistry REGISTRY = new AppViewRegistry();

    public static final AppView HOME_VIEW = view("Demo",HomePresenter.class,MaterialDesignIcon.HOME, AppView.Flag.SHOW_IN_DRAWER, AppView.Flag.SKIP_VIEW_STACK, AppView.Flag.HOME_VIEW);

    private static AppView view(String title, Class<? extends GluonPresenter<?>> presenterClass, MaterialDesignIcon menuIcon, AppView.Flag... flags) {
        return REGISTRY.createView(name(presenterClass), title, presenterClass, menuIcon, flags);
    }

    private static String name(Class<? extends GluonPresenter<?>> presenterClass) {
        return presenterClass.getSimpleName().toUpperCase(Locale.ROOT).replace("PRESENTER", "");
    }

    public static void registerViews(MobileApplication app) {
        REGISTRY.getViews().
                forEach(view -> view.registerView(app));
    }

    public static void registerDrawer(MobileApplication app) {
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Mobile",
                "Demo App",
                new Avatar(21, new Image(AppViewManager.class.getResourceAsStream("/icon.png"))));
        Utils.buildDrawer(app.getDrawer(),header,REGISTRY.getViews());
    }
}

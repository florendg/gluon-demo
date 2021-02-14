module dev.vultureweb.sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;
    requires com.gluonhq.attach.util;
    requires com.gluonhq.attach.storage;
    requires com.gluonhq.glisten.afterburner;
    opens dev.vultureweb.sample to javafx.graphics;
}
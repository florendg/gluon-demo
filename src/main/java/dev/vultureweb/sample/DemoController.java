package dev.vultureweb.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoController implements Initializable {

    public static final String DEMO_VIEW = "demo";

    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onClick() {
        System.out.println("click");
    }
}

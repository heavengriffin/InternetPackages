package org.dzenan;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class InternetPackagesController {
    InternetPackages internetPackages;

    public InternetPackagesController() {

    }
    @FXML
    private SplitPane splitPane = new SplitPane();
    @FXML
    private TextField fn, ln, a;
    @FXML
    private ToggleButton s2, s5, s10, s20, s50, s100, b1, b5, b10, b100, flat, oneY, twoY;
    @FXML
    private ToggleGroup speed = new ToggleGroup();
    @FXML
    private ToggleGroup bandwidth = new ToggleGroup();
    @FXML
    private ToggleGroup years = new ToggleGroup();
    @FXML
    private TableView<InternetPackages> table;
    private final ObservableList<InternetPackages> data = FXCollections.observableArrayList();



    private void getSelectedSpeed() {
        speed.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if (t1 != null) {
                ToggleButton toggleButton = (ToggleButton) t1;
                internetPackages.speedProperty().set(toggleButton.getText());
            } else internetPackages.speedProperty().set(null);
        });
    }
    private void getSelectedBandwidth() {
        bandwidth.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if (t1 != null) {
                ToggleButton toggleButton = (ToggleButton) t1;
                internetPackages.bandwidthProperty().set(toggleButton.getText());
            } else internetPackages.bandwidthProperty().set(null);
        });
    }
    private void getYears() {

        years.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if (t1 != null) {
                ToggleButton toggleButton = (ToggleButton) t1;
                internetPackages.yearsProperty().set(toggleButton.getText());
            } else internetPackages.yearsProperty().set(null);
        });
    }

    @FXML
    private void initialize() {
        internetPackages = new InternetPackages();

        fn.textProperty().bindBidirectional(internetPackages.firstNameProperty());
        ln.textProperty().bindBidirectional(internetPackages.lastNameProperty());
        a.textProperty().bindBidirectional(internetPackages.addressProperty());
        getSelectedSpeed();
        getSelectedBandwidth();
        getYears();

        splitPane.setDividerPosition(1, 0.28523936170212766);
        SplitPane.Divider divider = splitPane.getDividers().get(0);
        divider.positionProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                divider.setPosition(0.28523936170212766);
            }
        });
    }
    @FXML
    private void savePackage() {
        if (internetPackages.isValid()) {
            InternetPackages ip = new InternetPackages(internetPackages.getFirstName(), internetPackages.getLastName(), internetPackages.getAddress(), internetPackages.getSpeed(), internetPackages.getBandwidth(), internetPackages.getYears());
            data.add(ip);
            table.setItems(data);
            clear();
        } else {
            StringBuilder errMsg = new StringBuilder();
            ArrayList<String> errList = internetPackages.errorsProperty().get();
            for (String e : errList)
                errMsg.append(e);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internet-package cannot be saved!");
            alert.setHeaderText(null);
            alert.setContentText(errMsg.toString());
            alert.showAndWait();
            errList.clear();
        }
    }
    @FXML
    private void clear() {

        s2.setSelected(false);
        s5.setSelected(false);
        s10.setSelected(false);
        s20.setSelected(false);
        s50.setSelected(false);
        s100.setSelected(false);

        b1.setSelected(false);
        b5.setSelected(false);
        b10.setSelected(false);
        b100.setSelected(false);
        flat.setSelected(false);

        oneY.setSelected(false);
        twoY.setSelected(false);

        fn.clear();
        ln.clear();
        a.clear();

        fn.requestFocus();

        internetPackages.firstNameProperty().set("");
        internetPackages.lastNameProperty().set("");
        internetPackages.addressProperty().set("");
        internetPackages.speedProperty().set(null);
        internetPackages.bandwidthProperty().set(null);
        internetPackages.yearsProperty().set(null);

    }
    @FXML
    private void delete() {
        int row = table.getSelectionModel().getSelectedIndex();
        if (row >= 0) {
            table.getItems().remove(row);
            table.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void close() {
        Platform.exit();
    }

}

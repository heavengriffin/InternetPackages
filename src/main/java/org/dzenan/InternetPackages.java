package org.dzenan;

import javafx.beans.property.*;
import java.util.ArrayList;

public class InternetPackages {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty address = new SimpleStringProperty(this, "address", "");
    private final StringProperty speed = new SimpleStringProperty(this, "speed", "");
    private final StringProperty bandwidth = new SimpleStringProperty(this, "bandwidth", "");
    private final StringProperty years = new SimpleStringProperty(this, "years", "");

    public InternetPackages() {

    }

    public InternetPackages(String firstName, String lastName, String address, String speed, String bandwidth, String years) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.years.set(years);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getSpeed() {
        return speed.get();
    }

    public StringProperty speedProperty() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public String getBandwidth() {
        return bandwidth.get();
    }

    public StringProperty bandwidthProperty() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth.set(bandwidth);
    }

    public String getYears() {
        return years.get();
    }

    public StringProperty yearsProperty() {
        return years;
    }

    public void setYears(String years) {
        this.years.set(years);
    }

    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    public boolean isValid() {
        boolean isValid = true;

        if (firstName.get() != null && firstName.get().equals("")) {
            errorList.getValue().add("First name cannot be empty. ");
            isValid = false;
        }
        if (lastName.get().equals("")) {
            errorList.getValue().add("Last name cannot be empty. ");
            isValid = false;
        }
        if (address.get().equals("")) {
            errorList.getValue().add("Address cannot be empty. ");
            isValid = false;
        }
        if (speed.get() == null) {
            errorList.getValue().add("You must choose the speed. ");
            isValid = false;
        }
        if (bandwidth.get() == null) {
            errorList.getValue().add("You must choose the bandwidth. ");
            isValid = false;
        }
        if (years.get() == null) {
            errorList.getValue().add("You must choose the duration of the contract. ");
            isValid = false;
        }
        return isValid;

    }
}

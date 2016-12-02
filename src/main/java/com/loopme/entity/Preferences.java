package com.loopme.entity;

/**
 * Created by gunther on 10/20/16.
 */
public class Preferences {

    private String distanceUnit;
    private Boolean useHomeAddress;

    public Preferences(){}

    public Preferences(String distanceUnit, Boolean useHomeAddress){
        this.distanceUnit = distanceUnit;
        this.useHomeAddress = useHomeAddress;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public Boolean getUseHomeAddress() {
        return useHomeAddress;
    }

    public void setUseHomeAddress(Boolean useHomeAddress) {
        this.useHomeAddress = useHomeAddress;
    }
}


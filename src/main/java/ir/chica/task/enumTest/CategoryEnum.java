package ir.chica.task.enumTest;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryEnum {
    SAVE("save"),DELETE("delete"),UPDATE("update"),SELECT("read");

    private final String Activities;

    CategoryEnum(String activities) {
       this.Activities = activities;
    }

    @JsonValue
    private String getActivities(){
        return Activities;
    }





}

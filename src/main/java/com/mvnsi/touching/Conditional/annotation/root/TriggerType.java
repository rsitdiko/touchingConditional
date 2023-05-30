package com.mvnsi.touching.Conditional.annotation.root;

public enum TriggerType {

    CRON("CRON"),
    SIMPLE("SIMPLE");

    private String type;

    TriggerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

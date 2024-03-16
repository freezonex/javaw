package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ID {
    @JsonProperty("id")
    private long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}

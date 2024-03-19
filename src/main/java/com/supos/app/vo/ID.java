package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ID {
    @JsonProperty("id")
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}

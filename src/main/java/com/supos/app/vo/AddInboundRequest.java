package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AddInboundRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("source")
    private String source; // PDA or manual

    @JsonProperty("shelf_records")
    private List<ShelfInventory> shelfRecords;

    @JsonProperty("note")
    private String note;

    @JsonProperty("status")
    private String status;

    // Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<ShelfInventory> getShelfRecords() {
        return shelfRecords;
    }

    public void setShelfRecords(List<ShelfInventory> shelfRecords) {
        this.shelfRecords = shelfRecords;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

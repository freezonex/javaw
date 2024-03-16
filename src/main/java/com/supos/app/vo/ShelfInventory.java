package com.supos.app.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ShelfInventory {
    @JsonProperty("storage_location_id")
    private String storageLocationId;

    @JsonProperty("inventory")
    private List<Inventory> inventory;

    @JsonProperty("storage_location")
    private String storageLocation;

    // Getters and Setters

    public String getStorageLocationId() {
        return storageLocationId;
    }

    public void setStorageLocationId(String storageLocationId) {
        this.storageLocationId = storageLocationId;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}


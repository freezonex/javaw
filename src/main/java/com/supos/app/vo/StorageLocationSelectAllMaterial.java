package com.supos.app.vo;

import com.supos.app.entity.WmsMaterialTransaction;

public class StorageLocationSelectAllMaterial {
    long material_id;
    String material_name;
    int quantity;

    public StorageLocationSelectAllMaterial(WmsMaterialTransaction materialTransactionquery) {
        this.quantity = materialTransactionquery.getQuantity();
        this.material_id = materialTransactionquery.getMaterial_id();
    }

    public long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(long material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

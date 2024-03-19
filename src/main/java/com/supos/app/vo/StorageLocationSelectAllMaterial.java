package com.supos.app.vo;

import com.supos.app.entity.WmsMaterialTransaction;

public class StorageLocationSelectAllMaterial {
    String material_code;
    String material_name;
    int quantity;

    public StorageLocationSelectAllMaterial(WmsMaterialTransaction materialTransactionquery) {
        this.quantity = materialTransactionquery.getQuantity();
        this.material_code = materialTransactionquery.getMaterial_code();
    }

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
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

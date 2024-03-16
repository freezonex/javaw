package com.supos.app.vo;

import com.supos.app.entity.WmsMaterialTransaction;
import com.supos.app.entity.WmsWarehouse;

public class WarehouseSelectAllMaterial {
    public WarehouseSelectAllMaterial(WmsMaterialTransaction materialTransactionquery) {
        this.quantity = materialTransactionquery.getQuantity();
        this.material_id = materialTransactionquery.getMaterial_id();
    }
    long material_id;
    String material_name;
    int quantity;

    public long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(long material_id) {
        this.material_id = material_id;
    }

    public String getMaterialName() {
        return material_name;
    }

    public void setMaterialName(String materialName) {
        material_name = materialName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantity = quantity;
    }
}

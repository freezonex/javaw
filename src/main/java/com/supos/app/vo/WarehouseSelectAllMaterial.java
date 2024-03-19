package com.supos.app.vo;

import com.supos.app.entity.WmsMaterialTransaction;
import com.supos.app.entity.WmsWarehouse;

public class WarehouseSelectAllMaterial {
    public WarehouseSelectAllMaterial(WmsMaterialTransaction materialTransactionquery) {
        this.quantity = materialTransactionquery.getQuantity();
        this.material_code = materialTransactionquery.getMaterial_code();
    }
    String material_code;
    String material_name;
    int quantity;

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String materialName) {
        material_name = materialName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantity = quantity;
    }
}

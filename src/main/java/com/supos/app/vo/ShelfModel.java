package com.supos.app.vo;


import java.util.List;

public class ShelfModel{
    private int sn;
    private int shelfId;
    private String shelfName;
    private List<ShelfColModel> shelfCols;

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public List<ShelfColModel> getShelfCols() {
        return shelfCols;
    }

    public void setShelfCols(List<ShelfColModel> shelfCols) {
        this.shelfCols = shelfCols;
    }


}


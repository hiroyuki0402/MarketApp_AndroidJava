package com.example.marketapp;

import android.media.Image;

public class ItemData {
    // プロパティー

    int imageInt;
    String itemName;
    String itemDesc;

    // コンストラクター

    public ItemData(int imageInt, String itemName, String itemDesc) {
        this.imageInt = imageInt;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    // ゲッターセッター

    public int getImageInt() {
        return imageInt;
    }

    public void setImageInt(int imageInt) {
        this.imageInt = imageInt;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}

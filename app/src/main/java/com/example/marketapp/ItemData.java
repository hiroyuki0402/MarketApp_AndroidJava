package com.example.marketapp;

/**
 * アイテムデータを保持するクラス。
 * 画像、アイテム名、アイテムの説明をプロパティとして持つ。
 */
public class ItemData {
    // プロパティ

    /**
     * 画像のリソースID。
     */
    int imageInt;

    /**
     * アイテムの名前。
     */
    String itemName;

    /**
     * アイテムの説明。
     */
    String itemDesc;

    // コンストラクター

    /**
     * コンストラクタ。
     *
     * @param imageInt  画像のリソースID。
     * @param itemName  アイテムの名前。
     * @param itemDesc  アイテムの説明。
     */
    public ItemData(int imageInt, String itemName, String itemDesc) {
        this.imageInt = imageInt;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    // ゲッターセッター

    /**
     * 画像のリソースIDを取得する。
     *
     * @return 画像のリソースID。
     */
    public int getImageInt() {
        return imageInt;
    }

    /**
     * 画像のリソースIDを設定する。
     *
     * @param imageInt 画像のリソースID。
     */
    public void setImageInt(int imageInt) {
        this.imageInt = imageInt;
    }

    /**
     * アイテム名を取得する。
     *
     * @return アイテム名。
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * アイテム名を設定する。
     *
     * @param itemName アイテム名。
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * アイテムの説明を取得する。
     *
     * @return アイテムの説明。
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * アイテムの説明を設定する。
     *
     * @param itemDesc アイテムの説明。
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}

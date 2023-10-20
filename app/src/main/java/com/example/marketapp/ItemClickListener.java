package com.example.marketapp;

import android.view.View;

/**
 * ItemClickListenerはRecyclerViewのアイテムがクリックされた際の挙動を定義するインターフェース
 */
public interface ItemClickListener {

    /**
     * アイテムがクリックされた際に呼び出されるメソッド
     *
     * @param view クリックされたアイテムのビュー
     * @param position クリックされたアイテムのポジション
     */
    void onClick(View view, int position);
}


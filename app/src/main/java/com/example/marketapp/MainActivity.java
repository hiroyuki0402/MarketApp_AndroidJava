package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * メインアクティビティクラス。
 * RecyclerViewとそのアダプターを設定し、各種アイテムのクリックイベントを処理
 */
public class MainActivity extends AppCompatActivity implements ItemClickListener {

    /**
     * RecyclerViewのインスタンス
     */
    RecyclerView recyclerView;

    /**
     * ヘッダー用のImageView
     */
    ImageView imageView;

    /**
     * フルーツの名前リスト
     */
    ArrayList<String> fruitsNames;

    /**
     * 画像のリソースIDリスト
     */
    ArrayList<Integer> imageNames;

    /**
     * アイテムの説明リスト
     */
    ArrayList<String> descriptions;

    /**
     * アイテムデータリスト
     */
    ArrayList<ItemData> itemDatas;

    /**
     * CustomAdapterのインスタンス
     */
    CustomAdapter adapter;

    /**
     * アクティビティが生成された時の処理
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reciclerView);
        imageView = findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.header);

        fruitsItemSetUP();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CustomAdapter(itemDatas);
        recyclerView.setAdapter(adapter);

        adapter.setItemClickListener(this);
    }

    /**
     * アイテムデータを設定するメソッド
     */
    private void fruitsItemSetUP() {
        fruitsNames = new ArrayList<>();
        imageNames = new ArrayList<>();
        descriptions = new ArrayList<>();
        itemDatas = new ArrayList<>();

        fruitsNames.add("Fruits");
        fruitsNames.add("Vegetables");
        fruitsNames.add("Bakery");
        fruitsNames.add("Beverage");
        fruitsNames.add("Milk");
        fruitsNames.add("Snacks");

        descriptions.add("庭から採れた新鮮な果物");
        descriptions.add("おいしい野菜");
        descriptions.add("パン、小麦、豆");
        descriptions.add("ジュース、紅茶、コーヒー、ソーダ");
        descriptions.add("ミルク、シェイク、ヨーグルト");
        descriptions.add("ポップコーン、ドーナツ、ドリンク");

        imageNames.add(R.drawable.fruit);
        imageNames.add(R.drawable.vegitables);
        imageNames.add(R.drawable.bread);
        imageNames.add(R.drawable.beverage);
        imageNames.add(R.drawable.milk);
        imageNames.add(R.drawable.popcorn);

        for (int i = 0; i < 6; i++) {
            ItemData data = new ItemData(imageNames.get(i), fruitsNames.get(i), descriptions.get(i));
            itemDatas.add(data);
        }
    }

    /**
     * アイテムがクリックされた時の処理。
     */
    @Override
    public void onClick(View view, int posion) {
        Toast.makeText(
                this,
                "アイテム " + itemDatas.get(posion).itemName,
                Toast.LENGTH_SHORT).show();
    }
}

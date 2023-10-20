package com.example.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * CustomAdapterはRecyclerViewでItemDataのリストを処理するためのアダプター
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    /**
     * 各アイテムのデータを保持するItemDataのリスト。
     */
    private List<ItemData> itemData;

    /**
     * アイテムクリックのリスナー。
     */
    public ItemClickListener itemClickListener;

    /**
     * アイテムクリックリスナーを設定する。
     *
     * @param clickListener クリックリスナー
     */
    public void setItemClickListener(ItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    /**
     * コンストラクタ
     *
     * @param itemData アイテムデータのリスト
     */
    public CustomAdapter(List<ItemData> itemData) {
        this.itemData = itemData;
    }

    /**
     * ViewHolderを作成して返す
     *
     * @param parent 親のビューグループ
     * @param viewType ビュータイプ
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * ViewHolderをバインドしする
     *
     * @param holder ViewHolder
     * @param position ポジション
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemData data = itemData.get(position);
        holder.itemNameView.setText(data.itemName);
        holder.itemDescView.setText(data.itemDesc);
        holder.imageView.setImageResource(data.getImageInt());
    }

    /**
     * アイテム数を返す
     *
     * @return アイテム数
     */
    @Override
    public int getItemCount() {
        return itemData.size();
    }

    /**
     * ViewHolderクラス
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView itemNameView;
        TextView itemDescView;

        /**
         * ViewHolderのコンストラクタ
         *
         * @param itemView アイテムのビュー
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            itemNameView = itemView.findViewById(R.id.titleView);
            itemDescView = itemView.findViewById(R.id.descriptionText);
            itemView.setOnClickListener(this);
        }

        /**
         * アイテムがクリックされた際の処理
         *
         * @param view クリックされたビュー
         */
        @Override
        public void onClick(View view) {
            if (view != null) {
                itemClickListener.onClick(view, getAdapterPosition());
            }
        }
    }
}


/** Swift で書いたら
 import UIKit

 class CustomTableViewCell: UITableViewCell {

@IBOutlet weak var imageView: UIImageView!
@IBOutlet weak var itemNameLabel: UILabel!
@IBOutlet weak var itemDescLabel: UILabel!

// UITableViewCellが初期化された時に呼ばれる
override func awakeFromNib() {
super.awakeFromNib()
// セルがクリックされたときのアクションを設定（オプション）
self.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(onCellClicked)))
}

@objc func onCellClicked() {
// セルがクリックされたときの処理
}
}

 class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

@IBOutlet weak var tableView: UITableView!

// データ
var itemData: [ItemData] = []

override func viewDidLoad() {
super.viewDidLoad()

tableView.dataSource = self
tableView.delegate = self

// データの設定（例）
itemData = [
ItemData(image: UIImage(named: "fruit")!, name: "Fruits", desc: "Fresh fruits from the garden"),
// ...他のデータ
]
}

// セルの数
func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
return itemData.count
}

// セルの内容
func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
let cell = tableView.dequeueReusableCell(withIdentifier: "CustomCell", for: indexPath) as! CustomTableViewCell
let data = itemData[indexPath.row]

cell.imageView?.image = data.image
cell.itemNameLabel.text = data.name
cell.itemDescLabel.text = data.desc

return cell
}

// セルがクリックされたとき
func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
let data = itemData[indexPath.row]
print("Item clicked: \(data.name)")
}
}

 struct ItemData {
 var image: UIImage
 var name: String
 var desc: String
 }


 */

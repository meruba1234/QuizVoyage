package to.msn.wings.quizvoyage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    // フィールド変数
    private final List<Data_Tab> data;
    ViewPager2 viewPager2;

    // コンストラクタ
    public MyListAdapter(List<Data_Tab> data, ViewPager2 viewPager2) {
        this.data = data;
        this.viewPager2 = viewPager2;
    }


    // ビューホルダーを生成
    /*MyViewHolderインスタンスを作成し、activity_pager2のレイアウトを変換する。*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pager2, parent, false);
        return new MyViewHolder(view);
    }

    // ビューにデータを割り当てて、ページを生成
    /*データ（ListItem）をViewHolder（MyViewHolder）のビューに結びつける*/
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data_Tab currentItem = data.get(position);
        holder.settingButton.setImageResource(R.drawable.setting);
        holder.point.setText(currentItem.getPoint());
        holder.searchButton.setImageResource(R.drawable.search);

        // JSONのデータ構造に基づいて、ボタンに問題をバインド
        holder.bind(currentItem); // QuizDataオブジェクトをbindメソッドに渡す

        // ボタンのタイトルを設定
        List<String> buttonTitles = currentItem.getButtonTitles();
        for (int i = 0; i < holder.getButtons().size(); i++) {
            if (i < buttonTitles.size()) {
                holder.getButtons().get(i).setText(buttonTitles.get(i));
            } else {
                //holder.getButtons().get(i).setVisibility(View.GONE); // ボタンのタイトルがない場合、ボタンを非表示にする
            }
        }
    }

    /*データセット内のアイテムの合計数を返す*/
    @Override
    public int getItemCount() {
        return data.size();
    }
}


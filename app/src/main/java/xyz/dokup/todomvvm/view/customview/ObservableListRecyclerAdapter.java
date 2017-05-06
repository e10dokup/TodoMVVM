package xyz.dokup.todomvvm.view.customview;

import android.content.Context;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by e10dokup on 2017/05/05.
 */

public abstract class ObservableListRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends ArrayRecyclerAdapter<T, VH> {

    public ObservableListRecyclerAdapter(@NonNull Context context, @NonNull ObservableList<T> list) {
        super(context, list);

        list.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<T>>() {
            @Override
            public void onChanged(ObservableList<T> ts) {
                notifyDataSetChanged(); //データセットの変更をすべてのobserverに通知
            }

            @Override
            public void onItemRangeChanged(ObservableList<T> ts, int i, int i1) {
                notifyItemRangeChanged(i, i1); // iからi1の範囲において、データの変更があったことをすべてのobserverに通知
            }

            @Override
            public void onItemRangeInserted(ObservableList<T> ts, int i, int i1) {
                notifyDataSetChanged(); //データセットの変更をすべてのobserverに通知
//                notifyItemRangeInserted(i, i1); // iからi1の範囲において、データの挿入があったことをすべてのobserverに通知
            }

            @Override
            public void onItemRangeMoved(ObservableList<T> ts, int i, int i1, int i2) {
                notifyItemMoved(i, i1); // iからi1へitemが移動したことをobserverに通知
            }

            @Override
            public void onItemRangeRemoved(ObservableList<T> ts, int i, int i1) {
                notifyItemRangeRemoved(i, i1); // iからi1の範囲のitemがデータセットから削除されたことを通知
            }
        });
    }
}

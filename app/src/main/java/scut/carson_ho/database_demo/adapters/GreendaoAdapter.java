package scut.carson_ho.database_demo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import scut.carson_ho.database_demo.R;
import scut.carson_ho.database_demo.greendao.utils.StudentBean;

/**
 * Created by ${lixiang} on 2018/6/27.
 */

public class GreendaoAdapter extends RecyclerView.Adapter<GreendaoAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<StudentBean> mWords; // Cached copy of words

    public GreendaoAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            StudentBean current = mWords.get(position);
            holder.wordItemView.setText(current.getId()+","+current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No FirstName");
        }
    }

    public void setWords(List<StudentBean> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null) {
            return mWords.size();
        } else {
            return 0;
        }
    }
}
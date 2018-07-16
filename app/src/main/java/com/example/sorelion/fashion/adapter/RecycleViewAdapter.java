package com.example.sorelion.fashion.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.sorelion.fashion.R;

import java.util.List;

/**
 * Created by pact on 2018/5/18.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private List<String> mlist;
    private RecyclerView mainRecycleView;


    public RecycleViewAdapter(Context context, List<String> mlist, RecyclerView mainRecycleView) {
        this.mContext = context;
        this.mlist = mlist;
        this.mainRecycleView = mainRecycleView;
    }

    public  interface itemOnClickListener {
        void clickItem(int position);
    }

    public void setItemOnClickListener(itemOnClickListener itemOnClickListener) {
        mItemOnClickListener = itemOnClickListener;
    }

    private itemOnClickListener mItemOnClickListener;

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_recycleview, mainRecycleView, false);
        RecyclerHolder holder = new RecyclerHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ((RecyclerHolder) holder).mTv_content.setText(mlist.get(position));
        ((RecyclerHolder) holder).mTv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemOnClickListener != null) {
                    mItemOnClickListener.clickItem(position+1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    static class RecyclerHolder extends ViewHolder {

        private TextView mTv_content;

        public RecyclerHolder(View itemView) {
            super(itemView);
            mTv_content = itemView.findViewById(R.id.item_main_recycle_content);
        }
    }
}

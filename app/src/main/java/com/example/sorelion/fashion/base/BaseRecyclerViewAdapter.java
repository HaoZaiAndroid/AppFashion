package com.example.sorelion.fashion.base;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    protected List<T> data = new ArrayList<>();

    public void addAll(List<T> data) {
        this.data.addAll(data);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

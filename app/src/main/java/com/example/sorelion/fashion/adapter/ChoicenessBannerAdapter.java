package com.example.sorelion.fashion.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.app.GlideApp;
import com.example.sorelion.fashion.base.BaseRecyclerViewAdapter;
import com.example.sorelion.fashion.base.BaseRecyclerViewHolder;
import com.example.sorelion.fashion.bean.ChoicenessBannerBean;
import com.example.sorelion.fashion.databinding.ItemChoicenessBannerBinding;

public class ChoicenessBannerAdapter extends BaseRecyclerViewAdapter<ChoicenessBannerBean>{

    private Context context;

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(parent, R.layout.item_choiceness_banner);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        holder.onBindViewHolder(data.get(position), position);
    }

    private class ViewHolder extends BaseRecyclerViewHolder<ChoicenessBannerBean, ItemChoicenessBannerBinding>{

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(ChoicenessBannerBean object, int position) {
            GlideApp.with(context).load(object.getUrl())
                    .placeholder(R.mipmap.img_two_bi_one)
                    .error(R.mipmap.img_two_bi_one)
                    .transforms(new CenterCrop())
                    .into(itemBinding.ivItem);
        }
    }
}

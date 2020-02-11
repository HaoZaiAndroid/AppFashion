package com.android.fashion.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.android.fashion.R;
import com.android.fashion.app.GlideApp;
import com.android.fashion.base.BaseRecyclerViewAdapter;
import com.android.fashion.base.BaseRecyclerViewHolder;
import com.android.fashion.bean.BannerBean;
import com.android.fashion.databinding.ItemChoicenessBannerBinding;

public class ChoicenessBannerAdapter extends BaseRecyclerViewAdapter<BannerBean.DataBean>{

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

    private class ViewHolder extends BaseRecyclerViewHolder<BannerBean.DataBean, ItemChoicenessBannerBinding>{

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(BannerBean.DataBean object, int position) {
            GlideApp.with(context).load(object.getImagePath())
                    .placeholder(R.mipmap.img_two_bi_one)
                    .error(R.mipmap.img_two_bi_one)
                    .transforms(new CenterCrop())
                    .into(itemBinding.ivItem);
        }
    }
}

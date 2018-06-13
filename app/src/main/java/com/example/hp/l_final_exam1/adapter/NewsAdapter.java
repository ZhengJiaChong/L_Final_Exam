package com.example.hp.l_final_exam1.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hp.l_final_exam1.R;
import com.example.hp.l_final_exam1.bean.News;

import java.util.List;

/**
 * Created by HP on 2018/6/12.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder> {
    public NewsAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.news_title,item.getTitle());
        helper.setText(R.id.news_content,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView)helper.getView(R.id.news_thumb));
    }
}

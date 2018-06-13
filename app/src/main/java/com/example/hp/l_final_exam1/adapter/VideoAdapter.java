package com.example.hp.l_final_exam1.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hp.l_final_exam1.R;
import com.example.hp.l_final_exam1.bean.Video;

import java.util.List;

/**
 * Created by HP on 2018/6/12.
 */

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder>{
    public VideoAdapter(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
        helper.setText(R.id.tv_video_name,item.getName());
        Glide.with(mContext).load(item.getVideoThumbUrl()).into((ImageView)helper.getView(R.id.video_thumb));
    }
}

package com.example.hp.l_final_exam1.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.l_final_exam1.R;
import com.example.hp.l_final_exam1.adapter.NewsAdapter;
import com.example.hp.l_final_exam1.bean.News;
import com.example.hp.l_final_exam1.loader.GlideImageLoader;
import com.example.hp.l_final_exam1.net.HttpResult;
import com.example.hp.l_final_exam1.net.RetrofitUtil;
import com.example.hp.l_final_exam1.util.Const;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mView;
    private List<News> mNews;
    private NewsAdapter mNewsAdapter;
    private Banner mBanner;
    private List<String> mBannerImage;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_news, container, false);

        initView();
        init();
        return mView;
    }

    private void init() {
        mNews = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsAdapter = new NewsAdapter(R.layout.item_view_news,mNews);
        mRecyclerView.setAdapter(mNewsAdapter);

        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
                mNewsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });

        mBannerImage = new ArrayList<>();
        for (int i=0;i< Const.BANNER_IMAGE_URL.length;i++){
            mBannerImage.add(Const.BANNER_IMAGE_URL[i]);
        }
        mBanner.setImages(mBannerImage)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    private void initView() {
        mRecyclerView = (RecyclerView)mView.findViewById(R.id.recycler_view);
        mBanner = (Banner)mView.findViewById(R.id.banner);
    }

}

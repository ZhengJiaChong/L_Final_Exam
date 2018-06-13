package com.example.hp.l_final_exam1.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hp.l_final_exam1.R;
import com.example.hp.l_final_exam1.adapter.VideoAdapter;
import com.example.hp.l_final_exam1.bean.Video;
import com.example.hp.l_final_exam1.net.HttpResult;
import com.example.hp.l_final_exam1.net.RetrofitUtil;
import com.example.hp.l_final_exam1.ui.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private View mView;
    private List<Video> mVideo;
    private VideoAdapter mVideoAdapter;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_video, container, false);

        initView();
        init();

        return mView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView)mView.findViewById(R.id.recycler_view);
    }

    private void init() {
        mVideo = new ArrayList<>();
        mVideoAdapter = new VideoAdapter(R.layout.item_view_video,mVideo);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mVideoAdapter);

        mVideoAdapter.setOnItemClickListener(this);

        RetrofitUtil.getVideo(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List<Video>>> response) {
                mVideoAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Video video = (Video)adapter.getItem(position);
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra("video_url",video.getUrl());
        intent.putExtra("video_name",video.getName());
        startActivity(intent);
    }
}

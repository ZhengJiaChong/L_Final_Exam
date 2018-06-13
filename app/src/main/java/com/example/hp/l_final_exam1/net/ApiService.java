package com.example.hp.l_final_exam1.net;

import com.example.hp.l_final_exam1.bean.News;
import com.example.hp.l_final_exam1.bean.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 2018/6/12.
 */

public interface ApiService {
    @GET("getNews.php")
    Call<HttpResult<List<News>>> getNews();
    @GET("getVideo.php")
    Call<HttpResult<List<Video>>> getVideo();
}

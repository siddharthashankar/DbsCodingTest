package com.dbs.test.requests;


import com.dbs.test.model.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleApiService {

    @GET("article")
    Call<List<Article>> getArticle();

}

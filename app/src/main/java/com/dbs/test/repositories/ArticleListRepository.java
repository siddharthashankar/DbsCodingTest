package com.dbs.test.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.dbs.test.model.Article;
import com.dbs.test.requests.ArticleApiService;
import com.dbs.test.requests.RetrofitInstance;
import com.dbs.test.utils.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListRepository {
    private MutableLiveData<List<Article>> mutableLiveData = new MutableLiveData<>();

    private Context mContext;

    public ArticleListRepository(Context context) {
        mContext = context;

    }
    public MutableLiveData<List<Article>> getMutableLiveData() {
        ArticleApiService apiService = RetrofitInstance.getApiService();
        Call<List<Article>> call = apiService.getArticle();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }else{
                    new Util(mContext).showAlertDialog("Server Error","Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                new Util(mContext).showAlertDialog("Server Error","Something went wrong");
            }
        });
        return mutableLiveData;
    }
}
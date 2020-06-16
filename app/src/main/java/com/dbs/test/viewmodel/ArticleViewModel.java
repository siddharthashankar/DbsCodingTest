package com.dbs.test.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.dbs.test.repositories.ArticleListRepository;
import com.dbs.test.model.Article;
import java.util.List;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleListRepository articleListRepository;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleListRepository = new ArticleListRepository(application.getApplicationContext());
    }

    public LiveData<List<Article>> getArticleList(){
        return articleListRepository.getMutableLiveData();
    }
}

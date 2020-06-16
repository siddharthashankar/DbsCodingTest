package com.dbs.test.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dbs.test.R;
import com.dbs.test.model.Article;
import com.dbs.test.utils.LoadingDialog;
import com.dbs.test.view.adapter.ArticleAdapter;
import com.dbs.test.viewmodel.ArticleViewModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter mAdapter;
    private Article article;
    private ArticleViewModel articleViewModel;
    private List<Article> articleList = new ArrayList<>();
    LoadingDialog loadingDialog;
    Dialog dialog ;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        loadingDialog = new LoadingDialog(MainActivity.this);
        loadingDialog.startLoadingDialog();
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        // set the value through observer
        articleViewModel.getArticleList().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articleList) {
                if(articleList != null && articleList.size() > 0){
                    setValueToAdapter(articleList);
                }else {
                    setValueFromAssets();
                }
            }
        });

    }

    void setValueFromAssets(){
        try {
            JSONArray obj = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < obj.length(); i++) {
                JSONObject jsonObject = obj.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                int lastUpdate = jsonObject.getInt("last_update");
                String shortDescription = jsonObject.getString("short_description");
                String avatar = jsonObject.getString("avatar");
                article = new Article(id,title,lastUpdate,shortDescription,avatar);
                articleList.add(article);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setValueToAdapter(articleList);
    }

    void setValueToAdapter(List<Article> articleList){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadingDialog.dismissDialog();
        mAdapter = new ArticleAdapter(articleList,MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("articles.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
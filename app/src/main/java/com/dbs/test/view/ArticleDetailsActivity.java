package com.dbs.test.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dbs.test.R;
import com.dbs.test.utils.Constant;
import com.dbs.test.view.fragments.ArticleDetailsFragment;

public class ArticleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        Bundle bundle=new Bundle();
        bundle.putString(Constant.KEY_DES, getIntent().getStringExtra(Constant.KEY_DES));
        bundle.putString(Constant.KEY_IMG, getIntent().getStringExtra(Constant.KEY_IMG));
        ArticleDetailsFragment articleDetailsFragment = new ArticleDetailsFragment();
        articleDetailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, articleDetailsFragment).commit();

    }
}

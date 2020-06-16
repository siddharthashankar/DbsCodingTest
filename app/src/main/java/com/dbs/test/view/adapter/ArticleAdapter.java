package com.dbs.test.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.dbs.test.R;
import com.dbs.test.model.Article;
import com.dbs.test.utils.Constant;
import com.dbs.test.view.ArticleDetailsActivity;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private List<Article> articleList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView id, title, date, des;
        private CircleImageView avatar;
        private CardView cvParent;

        public MyViewHolder(View view) {
            super(view);
            cvParent = (CardView) view.findViewById(R.id.cvParent);
            avatar = (CircleImageView) view.findViewById(R.id.avatar);
            title = (TextView) view.findViewById(R.id.tvTitle);
            date = (TextView) view.findViewById(R.id.tvDate);
            des = (TextView) view.findViewById(R.id.tvDescription);
        }
    }

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.mContext = context;
    }

    @Override
    public ArticleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new ArticleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Article article = articleList.get(position);
        holder.title.setText(article.getTitle());
        Glide.with(mContext)
                .load(article.getAvatar())
                .into(holder.avatar);
        holder.date.setText(article.getLast_update().toString());
        holder.des.setText(article.getShort_description());
        holder.cvParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Adapter--", "clicked on: " + position);
                Intent intent = new Intent(mContext, ArticleDetailsActivity.class);
                intent.putExtra(Constant.KEY_IMG, articleList.get(position).getAvatar());
                intent.putExtra(Constant.KEY_DES, articleList.get(position).getShort_description());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}


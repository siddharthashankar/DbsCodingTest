package com.dbs.test.view.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dbs.test.R;
import com.dbs.test.utils.Constant;
import com.dbs.test.utils.Util;

public class ArticleDetailsFragment extends Fragment {
    private TextView tvDescription;
    private ImageView ivAvatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final String des = getArguments().getString(Constant.KEY_DES);
        final String avatar = getArguments().getString(Constant.KEY_IMG);
        View view = inflater.inflate(R.layout.fragment_article_details, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        tvDescription = view.findViewById(R.id.tvDescription);
        ivAvatar = view.findViewById(R.id.ivAvatar);
        TextView toolbarEditText = (TextView) toolbar.findViewById(R.id.toolbarEditText);
        toolbarEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleEditFragment articleEditFragment = new ArticleEditFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constant.KEY_DES, des);
                articleEditFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, articleEditFragment).addToBackStack(null).commit();

            }
        });

        ImageView ivBackButton = (ImageView) toolbar.findViewById(R.id.ivBackButton);
        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
                getActivity().finish();
            }
        });

        Glide.with(getActivity()).load(avatar).into(ivAvatar);
        tvDescription.setText(des);
        return view;
    }
}

package com.dbs.test.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dbs.test.R;
import com.dbs.test.utils.Constant;

public class ArticleEditFragment extends Fragment {
    private EditText etDescription;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_article_edit, container, false);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        etDescription = (EditText)view.findViewById(R.id.etDescription);

        final String strResult = getArguments().getString(Constant.KEY_DES);
        etDescription.setText(strResult);
        TextView toolbarEditText = (TextView) toolbar.findViewById(R.id.toolbarEditText);
        toolbarEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        Button toolbarSaveBtn = (Button) view.findViewById(R.id.btnSave);
        toolbarSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        ImageView ivBackButton = (ImageView)toolbar.findViewById(R.id.ivBackButton);
        ivBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return view;
    }
}

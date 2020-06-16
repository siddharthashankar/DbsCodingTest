package com.dbs.test.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.dbs.test.R;

public class LoadingDialog {
   private Activity activity;
   private AlertDialog alertDialog;
   private AlertDialog.Builder builder;
   private static LoadingDialog instance = null;

   public LoadingDialog(Activity myActivity){
      activity = myActivity;
      builder = new AlertDialog.Builder(activity);
   }

   public void startLoadingDialog(){
       LayoutInflater inflater = activity.getLayoutInflater();
       builder.setView(inflater.inflate(R.layout.custom_dialog,null));
       builder.setCancelable(true);
       alertDialog = builder.create();
       alertDialog.show();
   }

   public void dismissDialog(){
       alertDialog.dismiss();
   }
}

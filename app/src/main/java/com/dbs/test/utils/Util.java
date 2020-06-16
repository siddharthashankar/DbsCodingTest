package com.dbs.test.utils;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.dbs.test.R;

public class Util {

	static Context context;

	public Util(Context context) {
		this.context = context;
	}
	public static void showAlertDialog(String title,String msg){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
			alertDialogBuilder.setTitle(title);
			alertDialogBuilder
				.setMessage(msg)
				.setCancelable(false)
				.setPositiveButton("OK",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {

					}
				  });
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
}

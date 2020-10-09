package com.example.mystruct.util;

import android.widget.Toast;

import com.example.mystruct.MyApp;

public class ToastUtil {

    private static Toast toast;
    public static void showToast(String text){
        if (null == toast){
            toast = Toast.makeText(MyApp.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}

package com.noida.authority.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetCheck extends BroadcastReceiver {

    Context context;
    public static InterCheckInterface interCheckInterface = null;

    public InternetCheck(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;

        if (isConnect()) {

            if (interCheckInterface != null) {
                interCheckInterface.isNetConnected(true);
            } else {
                Toast.makeText(context, "Internet Connection Lost.", Toast.LENGTH_SHORT).show();

                if (interCheckInterface != null) {
                    interCheckInterface.isNetConnected(false);
                }
            }
        }
    }

    public boolean isConnect() {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();

            return info != null && info.isConnectedOrConnecting();
        }

        return false;
    }


    public interface InterCheckInterface {
        void isNetConnected(boolean isConnected);
    }
}
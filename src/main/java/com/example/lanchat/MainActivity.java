package com.example.lanchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lanchat.engine.lan.LANClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LANClient lanClient = LANClient.Builder.create()
                .port(18020)
                .build();


        lanClient.listen((action,success,code) ->
                Log.e(TAG, "onCreate: success: "+success+", code: "+code));
    }
}

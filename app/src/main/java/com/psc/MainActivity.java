package com.psc;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AudioRecorder audioRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constants.init();
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission("android.permission.RECORD_AUDIO") == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {"android.permission.RECORD_AUDIO"};
                requestPermissions(permissions, 424242);
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        audioRecorder = new AudioRecorder(44100, 10, 5);
        audioRecorder.start();
    }


    @Override
    protected void onStop() {
        super.onStop();
        audioRecorder.stop();
    }

    @Override
    protected void onDestroy() {
        audioRecorder.release();
    }

}

package com.tutoriales.simplelooperthread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class SimpleHandler extends Handler {
    private static final String TAG = "SimpleHandler";
    public static final int TASK_A=1;
    public static final int TASK_B=2;

    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what){
            case TASK_A:
                Log.d(TAG, "handleMessage: TASK A EXE");
                break;
            case TASK_B:
                Log.d(TAG, "handleMessage: TASK B EXE");
                break;
        }
    }
}

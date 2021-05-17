package com.tutoriales.simplelooperthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import static com.tutoriales.simplelooperthread.SimpleHandler.TASK_A;
import static com.tutoriales.simplelooperthread.SimpleHandler.TASK_B;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SimpleThreadLoop simpleThreadLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleThreadLoop = new SimpleThreadLoop();
    }

    public void startThread(View view){
        simpleThreadLoop.start();
    }

    public void stopThread(View view){
        simpleThreadLoop.getLooper().quit(); //deja de ejecutar el loop y los threads, quitsafe espera a que acaben todas las tareas
    }
    public void taskA(View view){
        Message message = Message.obtain();
        message.what=TASK_A;
        simpleThreadLoop.getHandler().sendMessage(message);
    }
    public void taskB(View view){
        Message message = Message.obtain();
        message.what=TASK_B;
        simpleThreadLoop.getHandler().sendMessage(message);
    }
}
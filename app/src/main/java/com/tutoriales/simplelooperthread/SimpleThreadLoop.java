package com.tutoriales.simplelooperthread;

import android.nfc.Tag;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


public class SimpleThreadLoop extends Thread{
    private static final String TAG = "SimpleThreadLoop";
    private Handler handler;
    private Looper looper;

    public SimpleThreadLoop() {
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Looper getLooper() {
        return looper;
    }

    public void setLooper(Looper looper) {
        this.looper = looper;
    }

    @Override
    public synchronized void start() {
        super.start();
        Log.d(TAG, "start: thread");
    }

    @Override
    public void run() {
        Looper.prepare(); //crea un looper asociado al thread

        looper = Looper.myLooper(); //retorna el looper asociado

        handler = new SimpleHandler();

        Looper.loop(); // mantiene en un loop constante este Thread

        Log.d(TAG, "run: end run");
    }

    @Override
    public void interrupt() {
        super.interrupt();
        Log.d(TAG, "interrupt: thread");
    }
}

package com.example.sampleproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

public class NewService extends Service {
    // declaring object of MediaPlayer
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("NewService", "onStartCommand: ");
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        player.setLooping(true);

        player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

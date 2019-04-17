package com.yimi.router.lib1.service;

import android.content.Context;
import android.widget.Toast;

import com.yimi.router.lib1base.IAudioService;

public class AudioService2 implements IAudioService {

    private Context context;
    private boolean debug;

    public AudioService2(Context context, boolean debug) {
        this.context = context;
        this.debug = debug;
    }

    @Override
    public void startAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 startAudio, debug=" + debug, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 stopAudio, debug=" + debug, Toast.LENGTH_SHORT).show();
    }
}

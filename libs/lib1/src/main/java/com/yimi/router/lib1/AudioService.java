package com.yimi.router.lib1;

import android.content.Context;
import android.widget.Toast;

import com.yimi.router.lib1base.IAudioService;

public class AudioService implements IAudioService {

    Context context;

    public AudioService(Context context) {
        this.context = context;
    }

    @Override
    public void startAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 startAudio", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 stopAudio", Toast.LENGTH_SHORT).show();
    }
}

package com.psc;

import android.media.*;
import android.util.Log;

/**
 * Created by Nicolas on 09/11/2016.
 */

public class AudioRecorder implements AudioRecord.OnRecordPositionUpdateListener {

    private int sampleRate;
    private int bufferSizeSeconds;//Values are in frames when not specified
    private int bufferSize;
    private int descriptionPeriod;
    private AudioRecord record;


    public AudioRecorder(int sampleRate, int bufferSizeSeconds, int descriptionPeriodSeconds) {
        this.sampleRate = sampleRate;//In Hz, of course
        this.bufferSizeSeconds = bufferSizeSeconds;
        this.bufferSize = this.bufferSizeSeconds * sampleRate;
        this.descriptionPeriod = descriptionPeriodSeconds * sampleRate;
        record = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize);
        record.setRecordPositionUpdateListener(this);
        record.setPositionNotificationPeriod(descriptionPeriod);
        Log.d("AudioRecorder", "AudioRecord initialized:" + (record.getState() == AudioRecord.STATE_INITIALIZED));
    }

    public void start() {
        record.startRecording();
    }

    public void stop() { //Previous recording data is lost
        record.stop();
    }

    public void release() {
        record.release();
    }

    @Override
    public void onMarkerReached(AudioRecord recorder) {

        short[] sound = new short[descriptionPeriod];
        recorder.read(sound, 0, descriptionPeriod);//Not sure...
        if (!Constants.DEBUG) {
            long vol = 0;
            for (int i = 0; i < sound.length; i++) {
                vol += sound[i] * sound[i];
            }
            Log.d("AudioRecorder", "onMarkerReached executed; overall volume:" + vol);
        }



    }

    @Override
    public void onPeriodicNotification(AudioRecord recorder) {
        this.onMarkerReached(recorder);
    }


}

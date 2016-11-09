package com.psc;

import android.media.*;

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
        this.sampleRate = sampleRate;
        this.bufferSizeSeconds = bufferSizeSeconds;
        this.bufferSize = this.bufferSizeSeconds *sampleRate;
        this.descriptionPeriod = descriptionPeriodSeconds*sampleRate;
        record=new AudioRecord(MediaRecorder.AudioSource.MIC,sampleRate,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT, bufferSize);
        record.setRecordPositionUpdateListener(this);
        record.setPositionNotificationPeriod(descriptionPeriod);
    }

    public void start(){
        record.startRecording();
    }

    public void stop(){ //Previous recording data is lost
        record.stop();
    }

    @Override
    public void onMarkerReached(AudioRecord recorder) {
        recorder.read(new short[descriptionPeriod],0,descriptionPeriod);//Not sure...
    }

    @Override
    public void onPeriodicNotification(AudioRecord recorder) {
        this.onMarkerReached(recorder);
    }
}

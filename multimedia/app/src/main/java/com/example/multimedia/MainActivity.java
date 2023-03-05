package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private Spinner spn;
    private String video;
    private VideoView reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = "android.resource://"+getPackageName()+"/"+R.raw.hasbulla;
        reproductor = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse(video);
        reproductor.setVideoURI(uri);

        MediaController mediaController =  new MediaController(this);
        reproductor.setMediaController(mediaController);
        mediaController.setAnchorView(reproductor);

        //cambiarVideo();
        //Playlist
        spn = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.playlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(this);


    }

    public void cambiarVideo(){
        Uri uri = Uri.parse(video);
        reproductor.setVideoURI(uri);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                video = "android.resource://"+getPackageName()+"/"+R.raw.hasbulla;
                break;
            case 1:
                video = "android.resource://"+getPackageName()+"/"+R.raw.acapulco;
                break;
            case 2:
                video = "android.resource://"+getPackageName()+"/"+R.raw.cruda;
                break;
            case 3:
                video = "android.resource://"+getPackageName()+"/"+R.raw.fuego;
                break;
            case 4:
                video = "android.resource://"+getPackageName()+"/"+R.raw.mediometro;
                break;
            default:
                video = "android.resource://"+getPackageName()+"/"+R.raw.hasbulla;
        }
        cambiarVideo();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
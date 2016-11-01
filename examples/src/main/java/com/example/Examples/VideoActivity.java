package com.example.Examples;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;

public class VideoActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private MediaPlayer mediaPlayer;
    private TextureView screen;
    private Surface surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        this.screen = (TextureView) this.findViewById(R.id.video_texture);
        this.screen.setSurfaceTextureListener(this);
        setContentView(this.screen);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        this.surface = new Surface(surfaceTexture);
        this.mediaPlayer.setSurface(this.surface);
        //Uri uri = new
        //this.mediaPlayer.setDataSource(this, );
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}

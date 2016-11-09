package com.example.Examples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.example.Examples.adapters.ImageAdapter;

public class EmptyActivity extends AppCompatActivity
        implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, VideoFragment.OnFragmentInteractionListener {
    private GridLayout screens;
    private MediaPlayer mediaPlayer;
    private TextureView screen;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        this.screens = (GridLayout)this.findViewById(R.id.grid_screens);
        this.screen = (TextureView)screens.getChildAt(2);
        this.screen.setSurfaceTextureListener(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("dummy-intent"));
        //screens = (GridView) findViewById(R.id.gridview);
        //screens.setAdapter(new ImageAdapter(this));

        //screens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //    public void onItemClick(AdapterView<?> parent, View v,
        //                            int position, long id) {
        //        Toast.makeText(EmptyActivity.this, "" + position,
        //                Toast.LENGTH_SHORT).show();
        //    }
        //});
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.receiver);

        super.onDestroy();
    }

    /**
     * Invoked when a {@link TextureView}'s SurfaceTexture is ready for use.
     *
     * @param surface The surface returned by
     *                {@link TextureView#getSurfaceTexture()}
     * @param width   The width of the surface
     * @param height  The height of the surface
     */
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Surface container = new Surface(surface);
        try {
            mediaPlayer = new MediaPlayer();
            Uri uri = Uri.parse("android.resource://com.example.Examples/" + R.raw.sample_video);
            mediaPlayer.setDataSource(this, uri);
            mediaPlayer.setSurface(container);
            mediaPlayer.prepare();
            mediaPlayer.setOnBufferingUpdateListener(this);
            //mediaPlayer.setOnCompletionListener(this);
            //mediaPlayer.setOnPreparedListener(this);
            //mediaPlayer.setOnVideoSizeChangedListener(this);
            //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.start();

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Invoked when the {@link SurfaceTexture}'s buffers size changed.
     *
     * @param surface The surface returned by
     *                {@link TextureView#getSurfaceTexture()}
     * @param width   The new width of the surface
     * @param height  The new height of the surface
     */
    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    /**
     * Invoked when the specified {@link SurfaceTexture} is about to be destroyed.
     * If returns true, no rendering should happen inside the surface texture after this method
     * is invoked. If returns false, the client needs to call {@link SurfaceTexture#release()}.
     * Most applications should return true.
     *
     * @param surface The surface about to be destroyed
     */
    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    /**
     * Invoked when the specified {@link SurfaceTexture} is updated through
     * {@link SurfaceTexture#updateTexImage()}.
     *
     * @param surface The surface just updated
     */
    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    /**
     * Called to update status in buffering a media stream received through
     * progressive HTTP download. The received buffering percentage
     * indicates how much of the content has been buffered or played.
     * For example a buffering update of 80 percent when half the content
     * has already been played indicates that the next 30 percent of the
     * content to play has been buffered.
     *
     * @param mp      the MediaPlayer the update pertains to
     * @param percent the percentage (0-100) of the content
     */
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

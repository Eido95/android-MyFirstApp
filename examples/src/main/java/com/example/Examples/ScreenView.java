package com.example.Examples;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Display digital visual media.
 */
public class ScreenView extends FrameLayout implements SurfaceHolder.Callback {
    private static final String TAG = "ScreenView";
    private Context context;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;

    public ScreenView(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public ScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0);
    }

    public ScreenView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        initialize(context, attributeSet, defStyleAttr);
    }

    private void initialize(Context context, AttributeSet attributeSet, int defStyleAttr) {
        if (this.isInEditMode()) {
            return;
        }

        View view = LayoutInflater.from(context).inflate(R.layout.view_screen, this, true);

        SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.surface_screen);
        this.mediaPlayer = new MediaPlayer();
        this.surfaceHolder = surfaceView.getHolder();
        this.surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            this.mediaPlayer.setDisplay(this.surfaceHolder);
            Uri uri = Uri.parse("android.resource://com.example.Examples/" + R.raw.sample_video);

            this.mediaPlayer.setDataSource(this.getContext(), uri);
            this.mediaPlayer.prepare();

            this.mediaPlayer.start();
            //this.mediaPlayer.setVolume(0, 0);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Log.i(TAG, "surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
    }
}
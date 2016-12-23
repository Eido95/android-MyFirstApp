package com.example.Examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.Examples.adapters.ScreenAdapter;

import java.util.ArrayList;

public class ScreensActivity extends AppCompatActivity {
    private static final String TAG = "ScreensActivity";
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screens);

        ArrayList<ScreenView> screens = new ArrayList<>();
        for (int index = 0; index < 4; index++) {
            screens.add(new ScreenView(this));
        }

        this.gridView = (GridView)this.findViewById(R.id.gridview_screens);

        this.gridView.setAdapter(new ScreenAdapter(this, 0, screens));
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
            }
        });
    }
}

package com.example.Examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Empty2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty2);

        this.findViewById(R.id.button_empty2).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

        this.findViewById(R.id.layout_empty2).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }
}

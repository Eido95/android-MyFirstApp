package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String ACTIVITY2_MESSAGE = "com.example.myfirstapp.ACTIVITY2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hello = this.getResources().getString(R.string.hello_world);
        TextView textView = new TextView(this);
        textView.setText(hello);

        LinearLayout layout = (LinearLayout) this.findViewById(R.id.main_layout);
        layout.addView(textView);
    }

    /**
     * Called when the user clicks the send button
     * @param view The view that was clicked.
     */
    public void sendMessage(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //this.startActivity(intent);
        Intent intent = new Intent(this, MainActivity2.class);
        this.startActivity(intent);
    }
}
package com.example.Examples.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;

import com.example.Examples.ScreenView;

import java.util.List;

public class ScreenAdapter extends ArrayAdapter<ScreenView> {
    public ScreenAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.getItem(position);
            convertView.setMinimumHeight(500);
            convertView.setMinimumWidth(200);
        }

        ViewParent parent1 = convertView.getParent();

        return convertView;
    }
}
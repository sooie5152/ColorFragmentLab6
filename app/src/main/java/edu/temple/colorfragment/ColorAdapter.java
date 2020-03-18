package edu.temple.colorfragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String[] colors;
    String[] colorsHex;

    public ColorAdapter(Context context, String[] colors, String[] colorsHex) {
        this.context = context;
        this.colors = colors;
        this.colorsHex = colorsHex;
    }

    @Override
    public int getCount() {
        return this.colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if(convertView instanceof TextView) {
            textView = (TextView) convertView;
        } else {
            textView = new TextView(context);
        }
        textView.setText(colors[position]);
        String chosenColor = colorsHex[position];

        if (position != 0) {
            textView.setBackgroundColor(Color.parseColor(chosenColor));
        }
        textView.setTextSize(40);
        textView.setTextColor(Color.GRAY);
        return textView;
    }

}
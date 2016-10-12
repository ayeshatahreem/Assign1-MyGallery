package com.example.hp.assign1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter
{
    private Context mContext;
    // Constructor
    public ImageAdapter(Context c)
    {
        mContext = c;
    }

    public int getCount() {
        return MainActivity.pics.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(MainActivity.pics.get(position));
        return imageView;
    }
}

package com.example.oladr.cw_0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter
{
    private Context context;
    private int gridItemLayourId;
    static public ArrayList data;

    public GridViewAdapter(Context context, int gridItemLayourId, ArrayList data)
    {
        super(context, gridItemLayourId, data);
        this.context = context;
        this.gridItemLayourId = gridItemLayourId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(gridItemLayourId, parent, false);
            holder = new ViewHolder();
            holder.image = row.findViewById(R.id.imageView);
            row.setTag(holder);
        }
        else
            holder = (ViewHolder) row.getTag();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        holder.image.setLayoutParams(new ConstraintLayout.LayoutParams(width/2, height/4));
        Glide.with(context)
                .load((int) data.get(position))
                .into(holder.image);
        //holder.image.setImageResource((Integer) data.get(position));
        //holder.image.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), (int) data.get(position)));
        return row;
    }

    public class ViewHolder {
        ImageView image;
    }
}

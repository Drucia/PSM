package com.example.oladr.cw_0;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    public GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridView = findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, getData());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, HorizontalGalleryActivity.class);
                intent.putExtra("image_pos", position);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    //startActivity(intent);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE)
                    {
                        int first = view.getFirstVisiblePosition();
                        int last = view.getLastVisiblePosition();
                        int top = view.getChildAt(first-first).getTop();
                        int top_l = view.getChildAt(last-first).getTop();
                        int height = view.getChildAt(first-first).getHeight();

                        if (Math.abs(top + height) > Math.abs(top_l - 4*height))
                            view.smoothScrollToPosition(first);
                        else
                            view.smoothScrollToPosition(last);

                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                }
            });
        }
    }

    private ArrayList getData() {
        final ArrayList imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        for (int i = 0; i < imgs.length(); i++)
        {
            imageItems.add(imgs.getResourceId(i, -1));
        }
        return imageItems;
    }
}

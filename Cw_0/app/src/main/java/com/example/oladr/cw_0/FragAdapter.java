package com.example.oladr.cw_0;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragments = new ArrayList<>();

    public FragAdapter(FragmentManager fm) {
        super(fm);
        ArrayList list = GridViewAdapter.data;
        for (int position = 0; position < list.size(); position++) {
            mFragments.add(ImageFragment.newInstance((int) list.get(position)));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.format("Page %d", position);
    }
}

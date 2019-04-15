package com.example.android.bolognatourguide;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionFragmentPagerAdapter extends FragmentPagerAdapter {

    public static final int ATTRACTION_CATEGORY_NUMBER = 4;
    public static String[] ATTRACTION_CATEGORY_TITLE = {"Restaurants", "Parks", "Cultures", "Museums"};

    public AttractionFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantsFragment();
        } else if (position == 1) {
            return new ParksFragment();
        } else if (position == 2) {
            return new CulturesFragment();
        } else {
            return new MuseumsFragment();
        }
    }

    @Override
    public int getCount() {
        return ATTRACTION_CATEGORY_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ATTRACTION_CATEGORY_TITLE[position];
    }
}

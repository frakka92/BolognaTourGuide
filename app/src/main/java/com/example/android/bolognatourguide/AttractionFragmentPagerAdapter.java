package com.example.android.bolognatourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionFragmentPagerAdapter extends FragmentPagerAdapter {

    public static final int ATTRACTION_CATEGORY_NUMBER = 4;
    public Context context;

    public AttractionFragmentPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        context = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new ParksFragment();
            case 2:
                return new CulturesFragment();
            case 3:
                return new MuseumsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ATTRACTION_CATEGORY_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.category_restaurants);
            case 1:
                return context.getString(R.string.category_parks);
            case 2:
                return context.getString(R.string.category_cultures);
            case 3:
                return context.getString(R.string.category_museums);
            default:
                return null;
        }
    }
}

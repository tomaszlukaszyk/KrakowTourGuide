package com.example.android.krakowtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new VisitFragment();
            case 1:
                return new NatureFragment();
            case 2:
                return new MuseumsFragment();
            case 3:
                return new EventsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.visit_category);
            case 1:
                return mContext.getString(R.string.nature_category);
            case 2:
                return mContext.getString(R.string.museums_category);
            case 3:
                return mContext.getString(R.string.events_category);
            default:
                return null;
        }
    }
}

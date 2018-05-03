package com.vinogorova.sochitourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * {@link MyFragmentPagerAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Place} objects.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Create a new {@link MyFragmentPagerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public MyFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new ParksFragment();
        }else if(position == 1){
            return new MuseumsSightseeingsFragment();
        }else if(position == 2){
            return new RestaurantsFragment();
        }else if(position ==3){
            return new NatureAttractionsFragment();
        }else return new EntertainmentsFragment();
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    //
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence seq = null;

        switch (position) {
            case 0:
                seq =  mContext.getString(R.string.parks);
            break;
            case 1:
                seq = mContext.getString(R.string.museums);
            break;
            case 2:
                seq = mContext.getString(R.string.restaurants);
            break;
            case 3:
                seq = mContext.getString(R.string.nature);
            break;
            case 4: seq = mContext.getString(R.string.entertainments);
            break;
        }
        return  seq;
    }
}

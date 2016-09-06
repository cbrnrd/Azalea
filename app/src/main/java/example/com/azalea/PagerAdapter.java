package example.com.azalea;

import android.app.Fragment;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.Loader;

/*
  Created by Carter on 8/31/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    /*int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }
    */
    final int pageCount = 4;
    private String tabtitles[] = new String[] { "About", "Vendors", "Shop", "Map"};
    Context context;

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }
    public int getCount(){
        return pageCount;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position){
        switch (position){
            case 0:
                OneFragment tab1 = new OneFragment();
                return tab1;
            case 1:
                TwoFragment tab2 = new TwoFragment();
                return tab2;
            case 2:
                ThreeFragment tab3 = new ThreeFragment();
                return tab3;
            case 3:
                FourFragment tab4 = new FourFragment();
                return tab4;
            default:
                return null;
        }
    }


}

package com.openthedoorprovider.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.openthedoorprovider.fragmentTabs.CanceledFragmentTab;
import com.openthedoorprovider.fragmentTabs.CompletedFragmentTab;
import com.openthedoorprovider.fragmentTabs.CurrentFragmentTab;
import com.openthedoorprovider.fragmentTabs.InProcessFragmentTab;

public class PageAdapter extends FragmentPagerAdapter {


    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new CurrentFragmentTab();
            case 1:
                return new InProcessFragmentTab();
            case 2:
                return new CompletedFragmentTab();
            case 3:
                return new CanceledFragmentTab();
              default:
                  return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Current";
            case 1:
                return  "InProcess";
            case 2:
                return  "Completed";
            case 3:
                return "Canceled";
            default:
                return null;
        }
        
    }
}

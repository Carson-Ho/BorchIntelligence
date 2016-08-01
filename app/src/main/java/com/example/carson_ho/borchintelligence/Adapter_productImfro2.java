package com.example.carson_ho.borchintelligence;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Carson_Ho on 16/7/27.
 */
public class Adapter_productImfro2 extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"商品简介", "参数表"};
    private Fragment fragment1,fragment2;




    public Adapter_productImfro2(FragmentManager fm, Fragment fragment1,Fragment fragment2) {
        super(fm);
        this.fragment1 = fragment1;
        this.fragment2 = fragment2;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return fragment2;
        }
        return fragment1;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
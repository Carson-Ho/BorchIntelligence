package com.example.carson_ho.borchintelligence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Carson_Ho on 16/7/25.
 */
public class Product_imfro2 extends Fragment {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Adapter_productImfro2 myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

    //初始化视图
    View view = inflater.inflate(R.layout.commodity_imfro2, null);
    initViews(view);
    return view;
}


    private void initViews(View view) {

        Product_imfro21 imfor21 = new Product_imfro21();
        Product_imfro22 imfor22 = new Product_imfro22();


        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) view.findViewById(R.id.viewPager2);
        myFragmentPagerAdapter = new Adapter_productImfro2(getActivity().getSupportFragmentManager(),imfor21,imfor22);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout2);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);




    }

}

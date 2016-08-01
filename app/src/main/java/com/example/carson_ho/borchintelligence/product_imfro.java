package com.example.carson_ho.borchintelligence;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Carson_Ho on 16/7/25.
 */
public class Product_imfro extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Adapter_productImfro myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;

    private TextView name,price,wholse,address,picture_url;
    private ImageView picture;

    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();//隐藏掉整个ActionBar
        setContentView(R.layout.commodity_imfro);

        initViews();

    }


    private void initViews() {


        Intent intent = getIntent();

        Product_imfro1 imfor1 = new Product_imfro1();
        Product_imfro2 imfor2 = new Product_imfro2();

        Bundle bundle = new Bundle();


        System.out.println(intent.getIntExtra("商品照片数量", 400));
        bundle.putInt("picture_length", (intent.getIntExtra("商品照片数量", 400)));


        for(int i =0;i<intent.getIntExtra("商品照片数量", 400);i++){
            System.out.println("我在商品详情页");
            System.out.println(intent.getStringExtra("商品照片"+i));
            bundle.putString("picture"+i,intent.getStringExtra("商品照片"+i));
        }

        bundle.putString("name", (String)intent.getStringExtra("product_name"));
        bundle.putInt("price", (intent.getIntExtra("product_price",400)));
        bundle.putString("wholse",(String)intent.getStringExtra("product_wholse"));
        bundle.putString("address",(String)intent.getStringExtra("product_address"));
        bundle.putString("picture",(String)intent.getStringExtra("product_picture"));
        imfor1.setArguments(bundle);

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new Adapter_productImfro(getSupportFragmentManager(),imfor1,imfor2);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);


        //        返回按钮监听
        ViewGroup btn = (ViewGroup) findViewById(R.id.title1);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();
                                       overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);

                                   }
                               }
        );

    }

}

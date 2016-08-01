package com.example.carson_ho.borchintelligence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * Created by Carson_Ho on 16/7/25.
 */


public class Product_imfro1 extends Fragment {

    private TextView name, price, wholse, address, picture_url;
    private ArrayList<String > images ;
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commodity_imfro1, null);
        initData(view);
        return view;
    }

    private void initData(View view) {

        Bundle bundle = getArguments();

//        Intent intent = getActivity().getIntent();
//
        name =(TextView) view.findViewById(R.id.product_name);
        price = (TextView)  view.findViewById(R.id.product_price);
        wholse =  (TextView)  view.findViewById(R.id.product_wholesale);
        address = (TextView)  view.findViewById(R.id.product_address);

//
//        System.out.println((String)intent.getStringExtra("price_name"));
//
//        name.setText(bundle.getString("name"));


        name.setText(bundle.getString("name"));
        price.setText(((Integer)bundle.getInt("price")).toString());
        wholse.setText(bundle.getString("wholse"));
        address.setText(bundle.getString("address"));


        banner = (Banner) view.findViewById(R.id.banner);
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(5000);


        images = new ArrayList<>();
        for(int i = 0 ;i<bundle.getInt("picture_length");i++){
            System.out.println("我传到Banner了");
            System.out.println(bundle.getString("picture" + i));
            images.add(bundle.getString("picture" + i));
        }


        banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                System.out.println("加载中");
                Glide.with(getActivity().getApplicationContext()).load(url).into(view);
                System.out.println("加载完");
            }
        });

        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getActivity().getApplicationContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });





    }
}

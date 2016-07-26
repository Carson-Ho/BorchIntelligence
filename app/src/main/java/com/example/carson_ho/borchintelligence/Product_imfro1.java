package com.example.carson_ho.borchintelligence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Carson_Ho on 16/7/25.
 */


public class Product_imfro1 extends Fragment {

    private TextView name, price, wholse, address, picture_url;
    private ImageView picture;


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
        picture = (ImageView)  view.findViewById(R.id.product_picture);
//
//        System.out.println((String)intent.getStringExtra("price_name"));
//
//        name.setText(bundle.getString("name"));
        System.out.println(bundle.getString("name"));
        System.out.println((Integer) bundle.getInt("price"));
        System.out.println(bundle.getString("picture"));

        name.setText(bundle.getString("name"));
        price.setText(((Integer)bundle.getInt("price")).toString());
        wholse.setText(bundle.getString("wholse"));
        address.setText(bundle.getString("address"));


        Glide.with(this)
                .load((String) bundle.getString("picture"))
                .into(picture);




    }
}

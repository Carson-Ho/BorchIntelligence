package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carson_Ho on 16/6/28.
 */
public class Item_List extends Activity implements MyItemClickListener {

    private RecyclerView Rv;
    private ArrayList<HashMap<String, Object>> listItem;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_list);
        initData();
        initView();
        //        返回按钮监听
        Button btn = (Button) findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();
                                       overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);

                                   }
                               }
        );

    }


    public void initData() {
        Intent intent1 = getIntent();


//        String size = intent1.getStringExtra("商品数量");

//        System.out.println(intent1.getB("商品数量"+0));

        int size = intent1.getIntExtra("商品数量", 4000);

        System.out.println(size);

        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
//        for (int i = 0; i < Integer.parseInt(size); i++) {
            for (int i = 0; i < size; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("Machines_Recyclerview_Item_name", intent1.getStringExtra("商品名称" + i));
            map.put("Machines_Recyclerview_Item_address", intent1.getStringExtra("商品地址"+i));
                map.put("Machines_Recyclerview_Item_lowerest_wholesale_number", "最低批发量");
            map.put("Machines_Recyclerview_Item_wholesale", intent1.getIntExtra("邮费"+i,4000));
            map.put("Machines_Recyclerview_Item_price", intent1.getIntExtra("商品价格" + i, 4000));
            map.put("Machines_Recyclerview_Item_picture", intent1.getStringExtra("商品照片"+i));

            listItem.add(map);
        }
    }

    public void initView() {
        //为ListView绑定适配器
        myAdapter = new MyAdapter(this, listItem);
        myAdapter.setOnItemClickListener(this);

        Rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        Rv.setAdapter(myAdapter);


        //使用线性布局

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        Rv.setLayoutManager(layoutManager);
        Rv.setHasFixedSize(true);

        Rv.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));//用类设置分割线
//            Rv.addItemDecoration(new DividerItemDecoration(this, R.drawable.line)); //用已有图片设置分割线


    }

    @Override
    public void onItemClick(View view, int postion) {//点击事件的回调函数

       Intent intent = new Intent(Item_List.this,Product_imfro.class);

        intent.putExtra("product_picture",(String)listItem.get(postion).get("Machines_Recyclerview_Item_picture"));
       intent.putExtra("product_name",(String)listItem.get(postion).get("Machines_Recyclerview_Item_name"));
        intent.putExtra("product_price",(Integer)listItem.get(postion).get("Machines_Recyclerview_Item_price"));
        intent.putExtra("product_wholse",(String)listItem.get(postion).get("Machines_Recyclerview_Item_lowerest_wholesale_number"));
        intent.putExtra("product_address",(String)listItem.get(postion).get("Machines_Recyclerview_Item_address"));


        System.out.println((String) listItem.get(postion).get("Machines_Recyclerview_Item_name"));
        System.out.println((Integer)listItem.get(postion).get("Machines_Recyclerview_Item_price"));
        startActivity(intent);

    }
}


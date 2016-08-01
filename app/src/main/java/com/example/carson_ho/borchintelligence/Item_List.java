package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carson_Ho on 16/6/28.
 */
public class Item_List extends Activity implements MyItemClickListener {

    private RecyclerView Rv;
    private ArrayList<HashMap<String, Object>> listItem;
    private MyAdapter myAdapter;
    public ArrayList<String> images;
    private int ID;

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

        int size = intent1.getIntExtra("商品数量", 4000);

        System.out.println(size);

        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
//        for (int i = 0; i < Integer.parseInt(size); i++) {
            for (int i = 0; i < size; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("MachineID", intent1.getIntExtra("商品ID" + i, 4000));
                System.out.println(intent1.getIntExtra("商品ID" + i, 4000));
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

        //商品位置
        ID = postion;


        /*发送商品详情网络请求*/

        //输入POST请求的BODY
        JSONObject jo = new JSONObject();
        try {
            jo.put("requestType", "Display");
            jo.put("machineID", (Integer) listItem.get(postion).get("MachineID"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //把Body加上头
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");

        //将请求的json包装成httpPOST请求
        RequestBody Body = RequestBody.create(JSON, jo.toString());

        //创建Retrofit对象，并设置baseURL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://218.192.170.132:8000")//设置baseUrl
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析
                .build();

        AcessApi_proImfor access = retrofit.create(AcessApi_proImfor.class);

        //对发送请求的url进行封装
        Call<Pro_Imfor_JavaBean> call = access.getCall(Body);


        //发送网络请求（异步）
        call.enqueue(new Callback<Pro_Imfor_JavaBean>() {
            //请求成功时调用
            @Override
            public void onResponse(Call<Pro_Imfor_JavaBean> call, Response<Pro_Imfor_JavaBean> response) {
                System.out.println("有回应");

                //服务器有数据返回
                if (response.isSuccessful()) {

                    System.out.println("商品详情的信息返回的信息能被解析");



//
//                    images = new ArrayList<String>();
//
//                    for (int i = 0; i < response.body().getpictures().length; i++) {
//                        images.add(response.body().getpictures()[i]);
//                    }
//
//                    System.out.println("我是images内容");


                    //传递数据到下一页
                    Intent intent = new Intent(Item_List.this,Product_imfro.class);
                    System.out.println(response.body().getpictures().length);
                    intent.putExtra("商品照片数量",response.body().getpictures().length);


                    for (int i = 0; i < response.body().getpictures().length; i++) {
                        System.out.println("我在注塑机列表页");
                        System.out.println(response.body().getpictures()[i]);
                        intent.putExtra("商品照片" + i, response.body().getpictures()[i]);
                             }

                    intent.putExtra("product_picture",(String)listItem.get(ID).get("Machines_Recyclerview_Item_picture"));
                    intent.putExtra("product_name",(String)listItem.get(ID).get("Machines_Recyclerview_Item_name"));
                    intent.putExtra("product_price", (Integer) listItem.get(ID).get("Machines_Recyclerview_Item_price"));
                    intent.putExtra("product_wholse", (String) listItem.get(ID).get("Machines_Recyclerview_Item_lowerest_wholesale_number"));
                    intent.putExtra("product_address", (String) listItem.get(ID).get("Machines_Recyclerview_Item_address"));

                    System.out.println((Integer) listItem.get(ID).get("MachineID"));


                    startActivity(intent);

                } else {
                    System.out.println("返回的信息解析失败");//检查回应能否被解析
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }


            //请求失败时回调
            @Override
            public void onFailure(Call<Pro_Imfor_JavaBean> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });


    }




}



package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carson_Ho on 16/6/21.
 */
public class MachineParameter_select extends Activity implements  RadioGroup.OnCheckedChangeListener,TextWatcher {


    RadioGroup radioGroup1,radioGroup2;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    EditText editText_area,editText6;
    TextView textUnit;
    StringBuffer Rgoup1,Rgoup2;
    int checkID;
    Button  btn_next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_parameter_selected);

        editText_area = (EditText)findViewById(R.id.editText_area);
        editText_area.addTextChangedListener(this);

        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radioButton1 = (RadioButton) findViewById(R.id.radiobutton1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobutton2);

        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);

        radioButton3 = (RadioButton) findViewById(R.id.radiobutton3);
        radioButton4 = (RadioButton) findViewById(R.id.radiobutton4);


        //设置隐藏的Edittext
        editText6 = (EditText) findViewById(R.id.editText6);
        textUnit = (TextView) findViewById(R.id.text_unit);

        editText6.setVisibility(editText6 .INVISIBLE);
        textUnit.setVisibility(textUnit.INVISIBLE);

        checkID = radioButton3.getId();

        //下一步按钮跳转监听
        btn_next3= (Button) findViewById(R.id.btn_next3);
        btn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                POSTrequest();
            }
        });

//        //监听第一组选项
//        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                System.out.println(Rgoup1.toString());
//                if (checkedId == radioButton2.getId()) {
//                    Rgoup1.delete(0, Rgoup1.length());
//                    Rgoup1.append(radioButton2.getText());
//
//                } else if (checkedId == radioButton3.getId()) {
//
//                    Rgoup1.delete(0, Rgoup1.length());
//                    Rgoup1.append(radioButton3.getText());
//                } else {
//                    Rgoup1.delete(0, Rgoup1.length());
//                    Rgoup1.append(radioButton1.getText());
//                }
//            }
//        });

        //监听第二组选项
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButton4.getId()) {
                    editText6.setVisibility(editText6 .VISIBLE);
                    textUnit.setVisibility(textUnit.VISIBLE);
                    editText6.addTextChangedListener(MachineParameter_select.this);
                    checkID = radioButton4.getId();

                    if((checkID == radioButton3.getId())){
                        btn_next3.setEnabled(true);
                    }
                    else if ((checkID == radioButton4.getId())&&(editText6.getText().length()>0)){
                        btn_next3.setEnabled(true);
                    }

                    else {
                        btn_next3.setEnabled(false);
                    }

                }
                else  {
                    editText6.setVisibility(editText6 .INVISIBLE);
                    textUnit.setVisibility(textUnit.INVISIBLE);
                    checkID = radioButton3.getId();
                    if((checkID == radioButton3.getId())){
                        btn_next3.setEnabled(true);
                    }
                    else if ((checkID == radioButton4.getId())&&(editText6.getText().length()>0)){
                        btn_next3.setEnabled(true);
                    }

                    else {
                        btn_next3.setEnabled(false);
                    }
                }
            }
        });

        //返回按钮监听
        ViewGroup btn_back = (ViewGroup) findViewById(R.id.layout_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();
                                       overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);

                                   }
                               }
        );
    }


    public void POSTrequest() {
        //取出所有数据
        Intent intent1 = getIntent();
        System.out.println("我传到最后一页了");
        //第一页数据
        System.out.println(intent1.getStringExtra("productType"));
        System.out.println(intent1.getStringExtra("material"));
        System.out.println(intent1.getStringExtra("productWeight"));

        String productType= intent1.getStringExtra("productType");
        String material = intent1.getStringExtra("material");

        String productWeight =intent1.getStringExtra("productWeight");

        //第二页数据
        System.out.println(intent1.getStringExtra("moduleLength"));
        System.out.println(intent1.getStringExtra("moduleWidth"));
        System.out.println(intent1.getStringExtra("moduleHeight"));

        String moduleLength=intent1.getStringExtra("moduleLength");
        String moduleWidth=intent1.getStringExtra("moduleWidth");
        String moduleHeight=intent1.getStringExtra("moduleHeight");

        //第三页数据
        System.out.println(editText6.getText().toString());
        String screw =editText6.getText().toString();

        //输入POST请求的BODY
        JSONObject jo = new JSONObject();
        try {
            //测试用的
//            jo.put("requestType", "Search");
//            jo.put("productType", "电子电器零件");
//            jo.put("material", "ABS");
//            jo.put("productWeight", 23.4);
//            jo.put("moduleLength", 1.1);
//            jo.put("moduleWidth", 2.2);
//            jo.put("moduleHeight", 3.3);
//            jo.put("area", 10.2);
//            jo.put("ejector", "拉伸");
//            jo.put("locatingRing", 4.4);

            //实际使用
            jo.put("requestType", "Search");
            jo.put("productType", intent1.getStringExtra("productType"));
            jo.put("material", intent1.getStringExtra("material"));
            jo.put("productWeight", Integer.parseInt(intent1.getStringExtra("productWeight")));

            jo.put("moduleLength", Integer.parseInt(intent1.getStringExtra("moduleLength")));
            jo.put("moduleWidth", Integer.parseInt(intent1.getStringExtra("moduleWidth")));
            jo.put("moduleHeight", Integer.parseInt(intent1.getStringExtra("moduleHeight")));

            jo.put("ejector", "拉伸");
            jo.put("locatingRing", 4.4);

            //            jo.put("area", editText_area.getText());

//            jo.put("requestType", "Search");
//            jo.put("productType", productType);
//            jo.put("material", material);
//            jo.put("crumble", crumble);
//            jo.put("CaCo3", Caco3);
//            jo.put("fiberglass", fiberglass);
//            jo.put("fireproofing", fireproofing);
//            jo.put("color", color);
//            jo.put("productWeight", productWeight);
//            jo.put("productLength", productLength);
//            jo.put("productWidth", productWidth);
//            jo.put("productHeight", productHeight);
//            jo.put("wallThickness", wallThickness);
//            jo.put("moduleLength", moduleLength);
//            jo.put("moduleWidth", moduleWidth);
//            jo.put("moduleHeight", moduleHeight);
//            jo.put("ejector", ejector);
//            jo.put("locatingRing", locatingRing);
//            jo.put("screw", screw);
//            jo.put("power", power);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //把Body加上头，将请求的json包装成httpPOST请求
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        RequestBody Body = RequestBody.create(JSON, jo.toString());


        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://218.192.170.132:8000")//设置baseUrl
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析
                .build();

        AccessApi access = retrofit.create(AccessApi.class);
        Call<CommodityImfor> call = access.getCall(Body);


        //发送网络请求
        call.enqueue(new Callback<CommodityImfor>() {
            @Override
            public void onResponse(Call<CommodityImfor> call, Response<CommodityImfor> response) {
                System.out.println("有回应");
                //有数据返回
                if (response.isSuccessful() && response.body().getData().size()>0) {

                    Intent intent2 = new Intent();

                    intent2.putExtra("商品数量" ,response.body().getData().size());

                    System.out.println(response.body().getTotal());

                    for (int i = 0; i < response.body().getData().size(); i++) {

                        //保存数据搭配Intent传递到下商品列表页
                        intent2.putExtra("商品ID" + i,response.body().getData().get(i).getMachineID());
                        intent2.putExtra("商品名称" + i,response.body().getData().get(i).getName());
                        intent2.putExtra("商品价格" + i,response.body().getData().get(i).getPrice());
                        intent2.putExtra("商品地址" + i, response.body().getData().get(i).getAddress());
                        intent2.putExtra("商品照片" + i, response.body().getData().get(i).getPicture());
                        intent2.putExtra("最低批发量" + i, response.body().getData().get(i).getLowerest_wholesale());

                        System.out.println(response.body().getData().get(i).getMachineID());
                        System.out.println(response.body().getData().get(i).getName());
                        System.out.println(response.body().getData().get(i).getPrice());
                        System.out.println(response.body().getData().get(i).getAddress());
                        System.out.println(response.body().getData().get(i).getPicture());
                        System.out.println(response.body().getData().get(i).getLowerest_wholesale());


                    }

                    intent2.setClass(MachineParameter_select.this, Item_List.class);

                    startActivity(intent2);
                    overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);

                } else {
                    dialogMachineNotFound();

                }
            }

            //无连接到服务器
            @Override
            public void onFailure(Call<CommodityImfor> call, Throwable throwable) {
                System.out.println("没回应");
                dialogNetworkWarning();
            }
        });
    }


    //网络异常提示
    protected void dialogNetworkWarning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MachineParameter_select.this);
        builder.setMessage("网络异常，请检查你的网络连接");

        builder.setTitle("提示");

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


            }
        });

        builder.setNegativeButton("重试", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                POSTrequest();
            }
        });

        builder.create().show();
    }


    //无数据返回
    protected void dialogMachineNotFound() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MachineParameter_select.this);
        builder.setMessage("暂时找不到你需求的注塑机，若需个性化制定请致电：020-88888888");

        builder.setTitle("提示");

        builder.setPositiveButton("返回", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.create().show();
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {


        if((checkID == radioButton3.getId())){
            btn_next3.setEnabled(true);
        }
        else if ((checkID == radioButton4.getId())&&(editText6.getText().length()>0)){
            btn_next3.setEnabled(true);
        }

        else {
            btn_next3.setEnabled(false);
        }
    }

}






//                Intent intent1 = getIntent();
//                //第一页数据
//                String productType= intent1.getStringExtra("productType");
//                String material = intent1.getStringExtra("material");
//                String crumble=intent1.getStringExtra("crumble");
//                String Caco3=intent1.getStringExtra("Caco3");
//                String fiberglass= intent1.getStringExtra("fiberglass");
//                String color = intent1.getStringExtra("color");
//                String fireproofing= intent1.getStringExtra("fireproofing");
//
//                String productWeight =intent1.getStringExtra("productWeight");
//                String wallThickness =intent1.getStringExtra("wallThickness");
//                String productLength =intent1.getStringExtra("productLength");
//                String productWidth =intent1.getStringExtra("productWidth");
//                String productHeight =intent1.getStringExtra("productHeight");
//
//                //第二页数据
//                String moduleLength=intent1.getStringExtra("moduleLength");
//                String moduleWidth=intent1.getStringExtra("moduleWidth");
//                String moduleHeight=intent1.getStringExtra("moduleHeight");
//                String locatingRing_Size=intent1.getStringExtra("locatingRing_Size");
//
//                String ejector=intent1.getStringExtra("ejector");
//                String locatingRing=intent1.getStringExtra("locatingRing");
//
//                //第三页数据
//                String screw =Rgoup1.toString();
//                String power =Rgoup2.toString();
//
//
//                System.out.println("第一页数据");
//                System.out.println(productType);
//                System.out.println(material);
//                System.out.println(crumble);
//                System.out.println(Caco3);
//                System.out.println(fiberglass);
//                System.out.println(fireproofing);
//                System.out.println(color);
//                System.out.println(productWeight);
//                System.out.println(wallThickness);
//                System.out.println(productLength);
//                System.out.println(productWidth);
//                System.out.println(productHeight);
//
//
//
//                System.out.println("第二页数据");
//                System.out.println(moduleLength);
//                System.out.println(moduleWidth);
//                System.out.println(moduleHeight);
//                System.out.println(ejector);
//                System.out.println(locatingRing);
//                System.out.println(locatingRing_Size);
//
//
//                System.out.println("第三页数据");
//                System.out.println(Rgoup1.toString());
//                System.out.println(Rgoup2.toString());
//
//

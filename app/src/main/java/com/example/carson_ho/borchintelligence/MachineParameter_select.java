package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Carson_Ho on 16/6/21.
 */
public class MachineParameter_select extends Activity {


    RadioGroup radioGroup1,radioGroup2;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7;
    StringBuffer Rgoup1,Rgoup2;
    int checkID1,checkID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_parameter_selected);

        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radioButton1 = (RadioButton) findViewById(R.id.radiobutton1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobutton2);
        radioButton3 = (RadioButton) findViewById(R.id.radiobutton3);


        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        radioButton4 = (RadioButton) findViewById(R.id.radiobutton4);
        radioButton5 = (RadioButton) findViewById(R.id.radiobutton5);
        radioButton6 = (RadioButton) findViewById(R.id.radiobutton6);
        radioButton7 = (RadioButton) findViewById(R.id.radiobutton7);

        Rgoup1 = new StringBuffer(radioButton1.getText());
        Rgoup2 = new StringBuffer(radioButton4.getText());


        //下一步按钮跳转监听
        Button btn_next3= (Button) findViewById(R.id.btn_next3);
        btn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                //第一页数据
                String productType= intent1.getStringExtra("productType");
                String material = intent1.getStringExtra("material");
                String crumble=intent1.getStringExtra("crumble");
                String Caco3=intent1.getStringExtra("Caco3");
                String fiberglass= intent1.getStringExtra("fiberglass");
                String color = intent1.getStringExtra("color");
                String fireproofing= intent1.getStringExtra("fireproofing");

                String productWeight =intent1.getStringExtra("productWeight");
                String wallThickness =intent1.getStringExtra("wallThickness");
                String productLength =intent1.getStringExtra("productLength");
                String productWidth =intent1.getStringExtra("productWidth");
                String productHeight =intent1.getStringExtra("productHeight");

                //第二页数据
                String moduleLength=intent1.getStringExtra("moduleLength");
                String moduleWidth=intent1.getStringExtra("moduleWidth");
                String moduleHeight=intent1.getStringExtra("moduleHeight");
                String locatingRing_Size=intent1.getStringExtra("locatingRing_Size");

                String ejector=intent1.getStringExtra("ejector");
                String locatingRing=intent1.getStringExtra("locatingRing");

                //第三页数据
                String screw =Rgoup1.toString();
                String power =Rgoup2.toString();


                System.out.println("第一页数据");
                System.out.println(productType);
                System.out.println(material);
                System.out.println(crumble);
                System.out.println(Caco3);
                System.out.println(fiberglass);
                System.out.println(fireproofing);
                System.out.println(color);
                System.out.println(productWeight);
                System.out.println(wallThickness);
                System.out.println(productLength);
                System.out.println(productWidth);
                System.out.println(productHeight);



                System.out.println("第二页数据");
                System.out.println(moduleLength);
                System.out.println(moduleWidth);
                System.out.println(moduleHeight);
                System.out.println(ejector);
                System.out.println(locatingRing);
                System.out.println(locatingRing_Size);


                System.out.println("第三页数据");
                System.out.println(Rgoup1.toString());
                System.out.println(Rgoup2.toString());


                Intent intent2 = new Intent();

                intent2.setClass(MachineParameter_select.this, ProudctParameter_select.class);
                startActivity(intent2);
            }
        });

        //监听第一组选项
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println(Rgoup1.toString());
                if (checkedId == radioButton2.getId()) {
                    Rgoup1.delete(0, Rgoup1.length());
                    Rgoup1.append(radioButton2.getText());

                } else if (checkedId == radioButton3.getId()) {

                    Rgoup1.delete(0, Rgoup1.length());
                    Rgoup1.append(radioButton3.getText());
                } else {
                    Rgoup1.delete(0, Rgoup1.length());
                    Rgoup1.append(radioButton1.getText());
                }
            }
        });

        //监听第二组选项
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println(Rgoup2.toString());
                if (checkedId == radioButton5.getId()) {
                    Rgoup2.delete(0, Rgoup1.length());
                    Rgoup2.append(radioButton5.getText());

                } else if (checkedId == radioButton6.getId()) {

                    Rgoup2.delete(0, Rgoup1.length());
                    Rgoup2.append(radioButton6.getText());
                }
                else if (checkedId == radioButton7.getId()) {

                    Rgoup2.delete(0, Rgoup1.length());
                    Rgoup2.append(radioButton7.getText());
                }
                else  {
                    Rgoup2.delete(0, Rgoup1.length());
                    Rgoup2.append(radioButton4.getText());
                }
            }
        });




        //返回按钮监听
        Button btn = (Button) findViewById(R.id.back);


        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();

                                   }
                               }
        );
    }



}

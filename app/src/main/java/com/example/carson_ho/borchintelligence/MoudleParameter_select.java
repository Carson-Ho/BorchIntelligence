package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Carson_Ho on 16/6/17.
 */
public class MoudleParameter_select extends Activity  implements  RadioGroup.OnCheckedChangeListener,TextWatcher{

    RadioGroup radioGroup1,radioGroup2;
    Button btn_1, btn_2,btn_3,btn_4,btn_next2;
    EditText editText3,editText4,editText5,editText6;
    TextView textUnit;
    private StringBuffer ed3,ed4,ed5,ed6,Rgoup1,Rgoup2;
    public int checkID,checkID2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_parameter_selected);
        initView();


    }

    private void initView() {

        //初始化组件

        btn_next2 = (Button) findViewById(R.id.btn_next2);
        btn_next2.setEnabled(false);

        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);

        ed3 = new StringBuffer("");
        ed4 = new StringBuffer("");
        ed5 = new StringBuffer("");
        ed6 = new StringBuffer("");



        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        btn_1 = (Button) findViewById(R.id.radiobutton1);
        btn_2 = (Button) findViewById(R.id.radiobutton2);

        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        btn_3 = (Button) findViewById(R.id.radiobutton3);
        btn_4 = (Button) findViewById(R.id.radiobutton4);

        Rgoup1 = new StringBuffer(btn_1.getText());

        Rgoup2= new StringBuffer(btn_2.getText());


        editText3.addTextChangedListener(this);
        editText4.addTextChangedListener(this);
        editText5.addTextChangedListener(this);







        //下一步按钮跳转监听
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取出第一页数据,并装载到Intent里
                Intent intent2 = new Intent();
                Intent intent1 = getIntent();

                intent2.putExtra("productType",intent1.getStringExtra("productType"));
                intent2.putExtra("material",intent1.getStringExtra("material"));
                intent2.putExtra("crumble",intent1.getStringExtra("crumble"));
                intent2.putExtra("Caco3",intent1.getStringExtra("Caco3"));
                intent2.putExtra("fiberglass",intent1.getStringExtra("fiberglass"));
                intent2.putExtra("color",intent1.getStringExtra("color"));
                intent2.putExtra("fireproofing",intent1.getStringExtra("fireproofing"));

                intent2.putExtra("productWeight",intent1.getStringExtra("productWeight"));
                intent2.putExtra("wallThickness",intent1.getStringExtra("wallThickness"));
                intent2.putExtra("productLength",intent1.getStringExtra("productLength"));
                intent2.putExtra("productWidth",intent1.getStringExtra("productWidth"));
                intent2.putExtra("productHeight",intent1.getStringExtra("productHeight"));

                 //把第二页数据存到Intent2里
                intent2.putExtra("moduleLength",ed3.toString());
                intent2.putExtra("moduleWidth",ed4.toString());
                intent2.putExtra("moduleHeight",ed5.toString());
                intent2.putExtra("locatingRing_Size",ed6.toString());

                intent2.putExtra("ejector",Rgoup1.toString());
                intent2.putExtra("locatingRing",Rgoup2.toString());

                intent2.setClass(MoudleParameter_select.this, MachineParameter_select.class);

                startActivity(intent2);
                    }
                });



        //        返回按钮监听
        Button btn = (Button) findViewById(R.id.back);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();

                                   }
                               }
        );

        //设置隐藏的Edittext
        editText6 = (EditText) findViewById(R.id.editText6);
        textUnit = (TextView) findViewById(R.id.text_unit);

        editText6.setVisibility(editText6 .INVISIBLE);
        textUnit.setVisibility(textUnit.INVISIBLE);

        checkID = btn_3.getId();



        //监听第一组选项
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == btn_2.getId()) {
                    checkID2 = btn_2.getId();

                    Rgoup1.delete(0, Rgoup1.length());
                    Rgoup1.append(btn_2.getText());
                }

                else {

                    checkID2 = btn_1.getId();
                    Rgoup1.delete(0, Rgoup1.length());
                    Rgoup1.append(btn_1.getText());


                }
            }
        });

        //监听第二组选项
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == btn_4.getId()){
                    editText6.setVisibility(editText6 .VISIBLE);
                    textUnit.setVisibility(textUnit.VISIBLE);
                    editText6.addTextChangedListener(MoudleParameter_select.this);
                    checkID = btn_4.getId();

                    Rgoup2.delete(0, Rgoup2.length());
                    Rgoup2.append(btn_4.getText());

                    if((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_3.getId())){
                        btn_next2.setEnabled(true);
                    }
                    else if ((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_4.getId())&&(editText6.getText().length()>0)){
                        btn_next2.setEnabled(true);
                    }

                    else {
                        btn_next2.setEnabled(false);
                    }

                }
                else {
                    editText6.setVisibility(editText6 .INVISIBLE);
                    textUnit.setVisibility(textUnit.INVISIBLE);
                    checkID = btn_3.getId();

                    Rgoup2.delete(0, Rgoup2.length());
                    Rgoup2.append(btn_3.getText());

                    if((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_3.getId())){
                        btn_next2.setEnabled(true);
                    }
                    else if ((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_4.getId())&&(editText6.getText().length()>0)){
                        btn_next2.setEnabled(true);
                    }

                    else {
                        btn_next2.setEnabled(false);
                    }


                }
            }
        });

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
        ed3.delete(0, ed3.length());
        ed4.delete(0, ed4.length());
        ed5.delete(0, ed5.length());
        ed6.delete(0, ed6.length());

        ed3.append(editText3.getText());
        ed4.append(editText4.getText());
        ed5.append(editText5.getText());
        ed6.append(editText6.getText());

        if((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_3.getId())){
            btn_next2.setEnabled(true);
        }
        else if ((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(checkID == btn_4.getId())&&(editText6.getText().length()>0)){
                btn_next2.setEnabled(true);
            }

            else {
                btn_next2.setEnabled(false);
            }
        }

}

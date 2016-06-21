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
    public int checkID ;


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

        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        btn_1 = (Button) findViewById(R.id.radiobutton1);
        btn_2 = (Button) findViewById(R.id.radiobutton2);


        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        btn_3 = (Button) findViewById(R.id.radiobutton3);
        btn_4 = (Button) findViewById(R.id.radiobutton4);

        editText3.addTextChangedListener(this);
        editText4.addTextChangedListener(this);
        editText5.addTextChangedListener(this);




        //下一步按钮跳转监听
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(MoudleParameter_select.this, MachineParameter_select.class);
                startActivity(intent);
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

        //监听选项
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == btn_4.getId()){
                    editText6.setVisibility(editText6 .VISIBLE);
                    textUnit.setVisibility(textUnit.VISIBLE);
                    editText6.addTextChangedListener(MoudleParameter_select.this);
                    checkID = btn_4.getId();
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

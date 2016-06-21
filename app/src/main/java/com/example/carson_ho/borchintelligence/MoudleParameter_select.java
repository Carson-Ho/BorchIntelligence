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

/**
 * Created by Carson_Ho on 16/6/17.
 */
public class MoudleParameter_select extends Activity  implements  RadioGroup.OnCheckedChangeListener,TextWatcher{

    RadioGroup radioGroup1,radioGroup2;
    Button btn_1, btn_2,btn_3,btn_4,btn_next2;
    EditText editText3,editText4,editText5;


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
        if((editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)){
            btn_next2.setEnabled(true);
        }
        else {
            btn_next2.setEnabled(true);
        }
    }
}

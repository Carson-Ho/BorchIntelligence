package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
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
    EditText editText_length,editText_width,editText_height,editText6;
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

        editText_length = (EditText) findViewById(R.id.editText_length);
        editText_width = (EditText) findViewById(R.id.editText_width);
        editText_height = (EditText) findViewById(R.id.editText_height);
        editText6 = (EditText) findViewById(R.id.editText6);

//        ed3 = new StringBuffer("");
//        ed4 = new StringBuffer("");
//        ed5 = new StringBuffer("");
//        ed6 = new StringBuffer("");


//
//        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
//        btn_1 = (Button) findViewById(R.id.radiobutton1);
//        btn_2 = (Button) findViewById(R.id.radiobutton2);
//
//        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
//        btn_3 = (Button) findViewById(R.id.radiobutton3);
//        btn_4 = (Button) findViewById(R.id.radiobutton4);
//
//        Rgoup1 = new StringBuffer(btn_1.getText());
//
//        Rgoup2= new StringBuffer(btn_2.getText());


        editText_length.addTextChangedListener(this);
        editText_width.addTextChangedListener(this);
        editText_height.addTextChangedListener(this);

        //下一步按钮跳转监听
        btn_next2 = (Button)findViewById(R.id.btn_next2 );
        btn_next2.setEnabled(false);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent();
                Intent intent1 = getIntent();
                //取出第一页数据,并装载到Intent里
                System.out.println("我传到了第二页了");
                System.out.println(intent1.getStringExtra("productType") + "" + intent1.getStringExtra("material") + "" + intent1.getStringExtra("productWeight"));
                intent2.putExtra("productType", intent1.getStringExtra("productType"));
                intent2.putExtra("material", intent1.getStringExtra("material"));
                intent2.putExtra("productWeight", intent1.getStringExtra("productWeight"));
                //把第二页数据存到Intent2里
                System.out.println("我拿到了第二页的数据了");
                System.out.println(editText_length.getText().toString() + "" + editText_width.getText().toString() + "" + editText_height.getText().toString());
                intent2.putExtra("moduleLength", editText_length.getText().toString());
                intent2.putExtra("moduleWidth", editText_width.getText().toString());
                intent2.putExtra("moduleHeight", editText_height.getText().toString());

                intent2.setClass(MoudleParameter_select.this, MachineParameter_select.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);
            }
        });



        //        返回按钮监听
        ViewGroup btn_back = (ViewGroup) findViewById(R.id.layout_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            finish();
                                            overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);

                                        }
                                    }
        );

//

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

        if((editText_length.getText().length()>0)&&(editText_width.getText().length()>0)&&(editText_height.getText().length()>0)){
            btn_next2.setEnabled(true);
        }
            else {
                btn_next2.setEnabled(false);
            }
        }

}

package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 16/6/7.
 */
public class ProudctParameter_select extends Activity implements TextWatcher{


    private TextView textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    private EditText editText1,editText2,editText3,editText4,editText5;
    private List<TextView> textViewList;
    private List<String[]> selectedDataList;
    private final String[] selectedData_proudctType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
    private final String[] selectedData_material = {"ABS", "AS/SAN", "PS", "PP", "PPS", "PBT", "PE", "PSU/PSF", "PEI", "PAR", "TPE", "TPR", "HIPS", "PS", "PC", "POM", "PVC", "PMMA", "PC+ABS", "TPU", "LCP", "PA", "UPVC", "PET"};
    private final String[] selectedData_crumble = {"不添加", "15%以下", "15%-50%", "50%以上"};
    private final String[] selectedData_CaCo3 = {"不添加", "15%以下", "15%-30%", "30%以上"};
    private final String[] selectedData_fiberglass = {"不添加", "15%以下", "15%-25%", "25-45%以上", "45%以上"};
    private final String[] selectedData_fireproofing = {"一般防火", "V0级阻燃", "无卤助燃"};
    private final String[] selectedData_color = {"色粉", "色母", "透明"};


    private Button btn_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proudct_parameter_selected);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);



        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);
        textView5 = (TextView) findViewById(R.id.text5);
        textView6 = (TextView) findViewById(R.id.text6);
        textView7 = (TextView) findViewById(R.id.text7);
        textView8 = (TextView) findViewById(R.id.text8);

        textViewList = new ArrayList<TextView>();//把用到的TextView放入List
        textViewList.add(textView2);
        textViewList.add(textView3);
        textViewList.add(textView4);
        textViewList.add(textView5);
        textViewList.add(textView6);
        textViewList.add(textView7);
        textViewList.add(textView8);

        selectedDataList = new ArrayList<String[]>();//把用到的选择内容字符串数组放入List
        selectedDataList.add(selectedData_proudctType);
        selectedDataList.add(selectedData_material);
        selectedDataList.add(selectedData_crumble);
        selectedDataList.add(selectedData_CaCo3);
        selectedDataList.add(selectedData_fiberglass);
        selectedDataList.add(selectedData_fireproofing);
        selectedDataList.add(selectedData_color);


        //使用Dialog重用类
        DialogMultiplex mdialogReuse = new DialogMultiplex();
        mdialogReuse.DialogChooseList(this, textViewList, selectedDataList);


//        返回按钮监听
        Button btn = (Button) findViewById(R.id.back);


        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       finish();

                                   }
                               }
        );


        //"下一步"Button设置
        btn_next1 = (Button) findViewById(R.id.btn_next1);
        btn_next1.setEnabled(false);
        textView2.addTextChangedListener(this);
        textView3.addTextChangedListener(this);
        textView4.addTextChangedListener(this);
        textView5.addTextChangedListener(this);
        textView6.addTextChangedListener(this);
        textView7.addTextChangedListener(this);
        textView8.addTextChangedListener(this);


        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
        editText3.addTextChangedListener(this);
        editText4.addTextChangedListener(this);
        editText5.addTextChangedListener(this);

        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ProudctParameter_select.this, MoudleParameter_select.class);
                startActivity(intent);
            }
        });
    }
    /*按钮监听-函数*/
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if ((editText1.getText().length()>0)&&(editText2.getText().length()>0)&&(editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(textView2.getText().length()>0)&&(textView3.getText().length()>0)&&(textView4.getText().length()>0)&&(textView5.getText().length()>0)&&(textView6.getText().length()>0)&&(textView7.getText().length()>0)&&(textView8.getText().length()>0)){
            btn_next1.setEnabled(true);

        }
        else {
            btn_next1.setEnabled(true);
            System.out.println("不OK");
        }
    }
}



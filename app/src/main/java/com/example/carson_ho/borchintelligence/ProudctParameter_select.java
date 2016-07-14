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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 16/6/7.
 */
public class ProudctParameter_select extends Activity implements TextWatcher{

    private ViewGroup layout1, layout2, layout3, layout4, layout5, layout6, layout7;
    private TextView textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    private EditText editText1,editText2,editText3,editText4,editText5;
    private List<ViewGroup> viewgroup;
    private List<TextView> textViewList;
    private List<String[]> selectedDataList;

    private StringBuffer text2,text3,text4,text5,text6,text7,text8,ed1,ed2,ed3,ed4,ed5;

    private final String[] selectedData_proudctType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
    private final String[] selectedData_material = {"PVC rigid", "PVC soft", "PC", "PMMA", "PA4.6", "PA 6", "PA 6.6", "PA 11", "PA 12", "PA amorphous", "PET", "CA", "CAB", "CP", "PPE mod", "PAR", "PSU", "PES", "PES", "PEI", "PAI", "PE soft", "PE rigid", "PP", "POM", "PBT", "PPS", "FEP", "ETFE", "PAA", "PPA", "PAEK", "LCP", "TP-U", "热固性塑料", "LSR"};
    private final String[] selectedData_crumble = {"不添加", "15%以下", "15%-50%", "50%以上"};
    private final String[] selectedData_CaCo3 = {"不添加", "15%以下", "15%-30%", "30%以上"};
    private final String[] selectedData_fiberglass = {"不添加", "15%以下", "15%-25%", "25-45%以上", "45%以上"};
    private final String[] selectedData_fireproofing = {"一般防火", "V0级阻燃", "无卤助燃"};
    private final String[] selectedData_color = {"色粉", "色母", "透明"};

    private StringBuffer[] A;

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

        ed1 = new StringBuffer("");
        ed2 = new StringBuffer("");
        ed3 = new StringBuffer("");
        ed4 = new StringBuffer("");
        ed5 = new StringBuffer("");


        layout1 = (ViewGroup) findViewById(R.id.choese1);
        layout2 = (ViewGroup) findViewById(R.id.choese2);
        layout3 = (ViewGroup) findViewById(R.id.choese3);
        layout4 = (ViewGroup) findViewById(R.id.choese4);
        layout5 = (ViewGroup) findViewById(R.id.choese5);
        layout6 = (ViewGroup) findViewById(R.id.choese6);
        layout7 = (ViewGroup) findViewById(R.id.choese7);



        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);
        textView5 = (TextView) findViewById(R.id.text5);
        textView6 = (TextView) findViewById(R.id.text6);
        textView7 = (TextView) findViewById(R.id.text7);
        textView8 = (TextView) findViewById(R.id.text8);

        text2 = new StringBuffer("");
        text3 = new StringBuffer("");
        text4 = new StringBuffer("");
        text5 = new StringBuffer("");
        text6 = new StringBuffer("");
        text7 = new StringBuffer("");
        text8 = new StringBuffer("");



        viewgroup = new ArrayList<ViewGroup>();//把用到的TextView放入List
        viewgroup.add(layout1);
        viewgroup.add(layout2);
        viewgroup.add(layout3);
        viewgroup.add(layout4);
        viewgroup.add(layout5);
        viewgroup.add(layout6);
        viewgroup.add(layout7);

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
        mdialogReuse.DialogChooseList(this, textViewList, selectedDataList,viewgroup);


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

                String text22 = text2.toString();
                String text33 = text3.toString();
                String text44 = text4.toString();
                String text55 = text5.toString();
                String text66= text6.toString();
                String text77 = text7.toString();
                String text88 = text8.toString();

                String ed11 = ed1.toString();
                String ed22 = ed2.toString();
                String ed33 = ed3.toString();
                String ed44 = ed4.toString();
                String ed55 = ed5.toString();

                intent.putExtra("productType",text22);
                intent.putExtra("material",text33);
                intent.putExtra("crumble",text44);
                intent.putExtra("Caco3",text55);
                intent.putExtra("fiberglass",text66);
                intent.putExtra("fireproofing",text77);
                intent.putExtra("color",text88);

                intent.putExtra("productWeight",ed11);
                intent.putExtra("wallThickness",ed22);
                intent.putExtra("productLength",ed33);
                intent.putExtra("productWidth",ed44);
                intent.putExtra("productHeight",ed55);

                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);
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

        text2.delete(0, text2.length());
        text3.delete(0, text3.length());
        text4.delete(0,text4.length());
        text5.delete(0,text5.length());
        text6.delete(0,text6.length());
        text7.delete(0,text7.length());
        text8.delete(0,text8.length());

        ed1.delete(0, ed1.length());
        ed2.delete(0, ed2.length());
        ed3.delete(0, ed3.length());
        ed4.delete(0, ed4.length());
        ed5.delete(0, ed5.length());



        text2.append(textView2.getText());
        text3.append(textView3.getText());
        text4.append(textView4.getText());
        text5.append(textView5.getText());
        text6.append(textView6.getText());
        text7.append(textView7.getText());
        text8.append(textView8.getText());

        ed1.append(editText1.getText());
        ed2.append(editText2.getText());
        ed3.append(editText3.getText());
        ed4.append(editText4.getText());
        ed5.append(editText5.getText());


        System.out.println(text2);


        if ((editText1.getText().length()>0)&&(editText2.getText().length()>0)&&(editText3.getText().length()>0)&&(editText4.getText().length()>0)&&(editText5.getText().length()>0)&&(textView2.getText().length()>0)&&(textView3.getText().length()>0)&&(textView4.getText().length()>0)&&(textView5.getText().length()>0)&&(textView6.getText().length()>0)&&(textView7.getText().length()>0)&&(textView8.getText().length()>0)){

            btn_next1.setEnabled(true);
        }
        else {
            btn_next1.setEnabled(true);
            System.out.println("不OK");
        }
    }
}



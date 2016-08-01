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

    private ViewGroup layout_type, layout_material;
    private TextView text_type, text_material;
    private EditText editText_weight;
    private List<ViewGroup> viewgroup;
    private List<TextView> textViewList;
    private List<String[]> selectedDataList;
//    private StringBuffer send_type,send_material,send_weight;
    private Button btn_next1;

    private final String[] selectedData_proudctType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
    private final String[] selectedData_material = {"PVC rigid", "PVC soft", "PC", "PMMA", "PA4.6", "PA 6", "PA 6.6", "PA 11", "PA 12", "PA amorphous", "PET", "CA", "CAB", "CP", "PPE mod", "PAR", "PSU", "PES", "PES", "PEI", "PAI", "PE soft", "PE rigid", "PP", "POM", "PBT", "PPS", "FEP", "ETFE", "PAA", "PPA", "PAEK", "LCP", "TP-U", "热固性塑料", "LSR"};
//    private final String[] selectedData_crumble = {"不添加", "15%以下", "15%-50%", "50%以上"};
//    private final String[] selectedData_CaCo3 = {"不添加", "15%以下", "15%-30%", "30%以上"};
//    private final String[] selectedData_fiberglass = {"不添加", "15%以下", "15%-25%", "25-45%以上", "45%以上"};
//    private final String[] selectedData_fireproofing = {"一般防火", "V0级阻燃", "无卤助燃"};
//    private final String[] selectedData_color = {"色粉", "色母", "透明"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proudct_parameter_selected);

        editText_weight = (EditText) findViewById(R.id.editText_weight);
//        send_weight = new StringBuffer("");

        layout_type = (ViewGroup) findViewById(R.id.choese_type);
        layout_material = (ViewGroup) findViewById(R.id.choese_material);

        text_type = (TextView) findViewById(R.id.type);
        text_material = (TextView) findViewById(R.id.material);
//
//        send_type = new StringBuffer("");
//        send_material = new StringBuffer("");


        //绑定点击样式
        viewgroup = new ArrayList<ViewGroup>();
        viewgroup.add(layout_type);
        viewgroup.add(layout_material);

        //绑定显示的位置
        textViewList = new ArrayList<TextView>();
        textViewList.add(text_type);
        textViewList.add(text_material);

        //把用到的选择内容字符串数组放入List
        selectedDataList = new ArrayList<String[]>();
        selectedDataList.add(selectedData_proudctType);
        selectedDataList.add(selectedData_material);

        //使用Dialog重用类
        DialogMultiplex mdialogReuse = new DialogMultiplex();
        mdialogReuse.DialogChooseList(this, textViewList, selectedDataList,viewgroup);


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



        //"下一步"Button设置
        btn_next1 = (Button) findViewById(R.id.btn_next1);
        btn_next1.setEnabled(false);

        text_type.addTextChangedListener(this);
        text_material.addTextChangedListener(this);
        editText_weight.addTextChangedListener(this);


        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ProudctParameter_select.this, MoudleParameter_select.class);

                intent.putExtra("productType", text_type.getText().toString());
                intent.putExtra("material",text_material.getText().toString());
                intent.putExtra("productWeight", editText_weight.getText().toString());

                System.out.println(text_type.getText().toString() + ""+text_material.getText().toString() + ""+editText_weight.getText().toString());
                System.out.println("成功跳转");
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

//        send_type.delete(0, send_type.length());
//        send_material.delete(0, send_material.length());
//        send_weight.delete(0, send_weight.length());
//
//        send_type.append(text_type.getText());
//        send_material.append(text_material.getText());
//        send_weight.append(editText_weight.getText());

        if ((text_type.getText().length()>0)&&(text_material.getText().length()>0)&&(editText_weight.getText().length()>0)){
            btn_next1.setEnabled(true);
        }
        else {
            btn_next1.setEnabled(false);
            System.out.println("不OK");
        }
    }
}



package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 16/6/7.
 */
public class ProudctParameter_select extends Activity {


    private TextView textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    private List<TextView> textViewList;
    private List<String[]> selectedDataList;
    private final String[] selectedData_proudctType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
    private final String[] selectedData_material = {"ABS","AS/SAN","PS","PP","PPS","PBT","PE","PSU/PSF","PEI","PAR","TPE","TPR","HIPS","PS","PC","POM","PVC","PMMA","PC+ABS","TPU","LCP","PA","UPVC","PET"};
    private final String[] selectedData_crumble = {"不添加", "15%以下","15%-50%", "50%以上"};
    private final String[] selectedData_CaCo3 = {"不添加", "15%以下","15%-30%", "30%以上"};
    private final String[] selectedData_fiberglass = {"不添加", "15%以下","15%-25%", "25-45%以上","45%以上"};
    private final String[] selectedData_fireproofing = {"一般防火", "V0级阻燃","无卤助燃"};
    private final String[] selectedData_color = {"色粉", "色母","透明"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proudct_parameter_selected);

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


//        //       类型参数选择按钮初始化监听
//        textView1 = (TextView) findViewById(R.id.text2);
//        textView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ProudctParameter_select.this);
//                builder.setTitle("选择一个参数");
//                //    指定下拉列表的显示数据
//                final String[] productType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};
//
//                //    设置一个下拉的列表选择项
//                builder.setItems(productType, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        textView1.setText(productType[which]);
//                    }
//                });
//                builder.show();
//            }
//        });
//

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
}



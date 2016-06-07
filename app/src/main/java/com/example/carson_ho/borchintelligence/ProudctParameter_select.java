package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Carson_Ho on 16/6/7.
 */
public class ProudctParameter_select extends Activity {

      private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proudct_parameter_selected);


        //       参数选择按钮初始化监听
        textView =(TextView)findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProudctParameter_select.this);
                builder.setTitle("选择一个参数");
                //    指定下拉列表的显示数据
                final String[] productType = {"电子电器零件", "建筑材料", "医疗器械", "家用五金", "食用器皿", "交通器材", "运动器材", "照明设备", "家电产品", "办公器具", "光学用品"};

                //    设置一个下拉的列表选择项
                builder.setItems(productType, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText(productType[which]);
                    }
                });
                builder.show();
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
}



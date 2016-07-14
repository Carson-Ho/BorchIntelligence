package com.example.carson_ho.borchintelligence;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Carson_Ho on 16/6/16.
 */
public class DialogMultiplex {

    //重用选择对话框使用入口，调用此方法，输入三个参数：上下文，绑定后的TextView列表，选择内容列表数组。
    public void DialogChooseList(final Context context, List<TextView> textViews,List<String[]> selectedDataList,List<ViewGroup> viewgroup){
        for (int i = 0;i<textViews.size();i++){
            viewgroup.get(i).setOnClickListener(new DialogOnClickListener(textViews.get(i),selectedDataList.get(i),context));
        }
    }
    //重写TextView的点击监听器，让它可以传入TextView,List<String>等参数
    class DialogOnClickListener implements View.OnClickListener{
        private TextView textView;
        private String[] selectedList;
        private Context mcontext;
        public DialogOnClickListener(TextView tv,String[] sList,Context context){
            textView = tv;
            selectedList = sList;
            mcontext = context;
        }

        //设置点击事件
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
            builder.setTitle("选择一个参数");
            //    设置一个下拉的列表选择项
            builder.setItems(selectedList, new DialogSelectedItemOnClickListener(textView,selectedList));
            builder.show();
        }
    }

    //重写Dialog的点击监听器，让它可以传入TextView,List<String>等参数
    class DialogSelectedItemOnClickListener implements DialogInterface.OnClickListener{
        private TextView ctv;
        private String[] selectedList;
        public DialogSelectedItemOnClickListener(TextView ctextView, String[] sList){
            ctv = ctextView;
            selectedList = sList;

        }
        //设置点击事件
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ctv.setText(selectedList[which]);
        }
    }


}




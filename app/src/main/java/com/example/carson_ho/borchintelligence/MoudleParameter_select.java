package com.example.carson_ho.borchintelligence;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by Carson_Ho on 16/6/17.
 */
public class MoudleParameter_select extends Activity {

    RadioGroup radioGroup;
    Button btn_1, btn_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_parameter_selected);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup1);
        btn_1 = (Button) findViewById(R.id.radiobutton1);
        btn_2 = (Button) findViewById(R.id.radiobutton2);

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == )
//            }
//        });

    }


}

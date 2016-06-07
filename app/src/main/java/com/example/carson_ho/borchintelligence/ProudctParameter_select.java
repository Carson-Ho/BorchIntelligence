package com.example.carson_ho.borchintelligence;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carson_Ho on 16/6/7.
 */
public class ProudctParameter_select extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proudct_parameter_selected);

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



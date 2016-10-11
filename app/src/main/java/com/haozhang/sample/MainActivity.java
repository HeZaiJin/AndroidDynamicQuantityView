package com.haozhang.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.haozhang.widget.TextView.DynamicGroupView;
import com.haozhang.widget.TextView.DynamicSimpleAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DynamicGroupView dynamicGroupView = (DynamicGroupView) findViewById(R.id.dynamic);
        dynamicGroupView.setAdapter(new DynamicSimpleAdapter());
    }
}

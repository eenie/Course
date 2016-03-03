package com.eenie.mob.course;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eenie.mob.course.fragment.CourseFragment;
import com.eenie.mob.course.fragment.MyCenterFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{


    FragmentManager fmtManager;
    FragmentTransaction fmtTransaction;
    List<Fragment> fragmentList;
    LinearLayout rootLayout;
    int rootLayoutID = R.id.rootLayout;
    int choosed = 0;
    RadioGroup radioGroup;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = (LinearLayout) findViewById(R.id.rootLayout);
        radioGroup = (RadioGroup) findViewById(R.id.menuOption);
        radioGroup.setOnCheckedChangeListener(this);

        init();


    }

    private void init() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new CourseFragment());
        fragmentList.add(new MyCenterFragment());
        fmtManager = getSupportFragmentManager();
        fmtTransaction = fmtManager.beginTransaction();
        fmtTransaction.add(rootLayoutID, fragmentList.get(choosed));
        fmtTransaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int item = 0;
        switch (checkedId) {
            case R.id.radioButton:
                item = 0;
                break;
            case R.id.radioButton2:
                item = 1;
                break;
        }
        if (item != choosed) {
            fmtTransaction = fmtManager.beginTransaction();
            fmtTransaction.replace(rootLayoutID, fragmentList.get(item));
            fmtTransaction.commit();
            choosed = item;
        }
    }
}

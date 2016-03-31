package com.eenie.mob.course;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;


import com.eenie.mob.course.fragment.CourseListFragment;
import com.eenie.mob.course.fragment.CourseRecordFragment;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    int courseRootID = R.id.courseRoot;
    List<Fragment> fragments;


    FragmentManager fmtManager;
    FragmentTransaction fmtRTransaction;

    int choosed = 0;

    RadioGroup CourseGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        fragments = new ArrayList<>();
        fragments.add(new CourseListFragment());
        fragments.add(new CourseRecordFragment());
        fmtManager = getSupportFragmentManager();


        CourseGroup = (RadioGroup) findViewById(R.id.CourseGroup);
        CourseGroup.setOnCheckedChangeListener(this);

        initView();

        fmtRTransaction = fmtManager.beginTransaction();
        fmtRTransaction.add(courseRootID, fragments.get(choosed));
        fmtRTransaction.commit();




    }


    private void initView() {


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        int flag = 0;

        switch (checkedId) {
            case R.id.radioCourseList:
                flag = 0;
                break;
            case R.id.radioCourseRecord:
                flag = 1;
                break;
        }
        if (flag != choosed) {
            fmtRTransaction = fmtManager.beginTransaction();
            fmtRTransaction.replace(courseRootID, fragments.get(flag));
            fmtRTransaction.commit();
            choosed = flag;
        }
    }


}

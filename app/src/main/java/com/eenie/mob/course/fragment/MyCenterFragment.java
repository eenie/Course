package com.eenie.mob.course.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.eenie.mob.course.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人中心
 */
public class MyCenterFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    View myCenterRootView;

    FragmentManager fmtManager;
    FragmentTransaction fmtTransaction;

    RadioGroup groupCourse;


    int subLayoutID = R.id.centerRoot;

    List<Fragment> fragments;

    int chooseItem = 0;


    public MyCenterFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myCenterRootView = inflater.inflate(R.layout.fragment_my_center, container, false);
        fragments = new ArrayList<>();
        fragments.add(new RequireCourseFragment());
        fragments.add(new OptionalCourseFragment());
        fragments.add(new DaySignFragment());

        fmtManager = getFragmentManager();
        fmtTransaction = fmtManager.beginTransaction();
        fmtTransaction.add(subLayoutID, fragments.get(chooseItem));
        fmtTransaction.commit();


        groupCourse = (RadioGroup) myCenterRootView.findViewById(R.id.groupCourse);
        groupCourse.setOnCheckedChangeListener(this);
        return myCenterRootView;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        int newChoose = 0;

        switch (checkedId) {


            case R.id.radioRequire:

                newChoose = 0;
                break;

            case R.id.radioOptional:

                newChoose = 1;
                break;

            case R.id.radioSign:

                newChoose = 2;
                break;

        }


        if (chooseItem != newChoose) {
            fmtTransaction = fmtManager.beginTransaction();
            fmtTransaction.replace(subLayoutID, fragments.get(newChoose));
            fmtTransaction.commit();
            chooseItem = newChoose;
        }


    }
}

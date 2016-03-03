package com.eenie.mob.course;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.letv.skin.v4.V4PlaySkin;

public class CourseInfoActivity extends AppCompatActivity {

    ExpandableListView expandCourseList;
    CourseAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        courseAdapter = new CourseAdapter();

        initView();

    }

    private void initView() {
        expandCourseList = (ExpandableListView) findViewById(R.id.expandCourseList);
        expandCourseList.setAdapter(courseAdapter);




    }


    private class CourseAdapter extends BaseExpandableListAdapter {

        @Override
        public int getChildrenCount(int groupPosition) {
            return 5;
        }
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childPosition;
        }
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.expan_course_info_sub_layout, null);
            }

            return convertView;
        }


        @Override
        public int getGroupCount() {
            return 10;
        }
        @Override
        public Object getGroup(int groupPosition) {
            return groupPosition;
        }


        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }




        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.expan_course_info_title_layout, null);
            }

            return convertView;
        }


        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
        @Override
        public boolean hasStableIds() {
            return true;
        }
    }



}

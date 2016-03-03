package com.eenie.mob.course.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.eenie.mob.course.CourseInfoActivity;
import com.eenie.mob.course.R;

/**
 * 课程中心
 */
public class CourseFragment extends Fragment {
    ListView courseList;
    View indexView;
    CourseListAdapter courseListAdapter;
    Context courseContext;


    public CourseFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        indexView = inflater.inflate(R.layout.fragment_course, container, false);
        courseContext = getContext();
        courseListAdapter = new CourseListAdapter();


        initView(indexView);

        return indexView;
    }

    private void initView(View rootView) {
        courseList = (ListView) rootView.findViewById(R.id.courseList);
        courseList.setAdapter(courseListAdapter);
        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), CourseInfoActivity.class);
                startActivity(intent);
            }
        });


    }


    private class CourseListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.item_course_layout, null);
            }

            return convertView;
        }
    }


}

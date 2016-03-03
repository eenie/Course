package com.eenie.mob.course.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.eenie.mob.course.CourseActivity;
import com.eenie.mob.course.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OptionalCourseFragment extends Fragment {
    ListView myCourseList;
    CourseAdapter courseAdapter;
    View optionalCourseView;
    View listEmptyView;


    public OptionalCourseFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        optionalCourseView = inflater.inflate(R.layout.fragment_optional_course, container, false);

        initView(optionalCourseView);

        return optionalCourseView;
    }




    private void initView(View rootView) {
        courseAdapter = new CourseAdapter();
        myCourseList = (ListView) rootView.findViewById(R.id.myCourseList);
        listEmptyView = rootView.findViewById(R.id.emptyLayout);



        myCourseList.setAdapter(courseAdapter);
        myCourseList.setEmptyView(listEmptyView);
        myCourseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), CourseActivity.class);
                startActivity(intent);
            }
        });

    }

    private class CourseAdapter extends BaseAdapter {


        @Override
        public int getCount() {

            return 0;
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
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.item_my_course_layout, null);
            }
            return convertView;
        }
    }
}

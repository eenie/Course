package com.eenie.mob.course.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.eenie.mob.course.CourseVideoActivity;
import com.eenie.mob.course.PdfReaderActivity;
import com.eenie.mob.course.R;

/**
 * 课程列表
 */
public class CourseListFragment extends Fragment {
    ExpandableListView expandCourseList;
    CourseAdapter courseAdapter;
    View MainView;


    public CourseListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainView = inflater.inflate(R.layout.fragment_course_list, container, false);
        courseAdapter = new CourseAdapter();


        initView(MainView);

        return MainView;
    }


    private void initView(View root) {
        expandCourseList = (ExpandableListView) root.findViewById(R.id.expandCourseList);
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


        class ChildHolder {
            TextView txtVideo,txtPdf,txtTxt,txtExam, txtTalk;
        }


        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


            ChildHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.expan_course_sub_layout, null);
                holder = new ChildHolder();
                holder.txtVideo = (TextView) convertView.findViewById(R.id.txtVideo);
                holder.txtPdf = (TextView) convertView.findViewById(R.id.txtPdf);
                holder.txtTxt = (TextView) convertView.findViewById(R.id.txtTxt);
                holder.txtExam = (TextView) convertView.findViewById(R.id.txtExam);
                holder.txtTalk = (TextView) convertView.findViewById(R.id.txtTalk);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }



            holder.txtVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), CourseVideoActivity.class));
                }
            });
            holder.txtPdf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), PdfReaderActivity.class));

                }
            });
            holder.txtTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getContext(), "暂时不开放", Toast.LENGTH_SHORT).show();
                }
            });
            holder.txtExam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "暂时不开放", Toast.LENGTH_SHORT).show();
                }
            });
            holder.txtTalk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "暂时不开放", Toast.LENGTH_SHORT).show();
                }
            });







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
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.expan_course_title_layout, null);
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

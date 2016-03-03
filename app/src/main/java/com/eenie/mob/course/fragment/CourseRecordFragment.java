package com.eenie.mob.course.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eenie.mob.course.R;

/**
 * 学习记录
 */
public class CourseRecordFragment extends Fragment {

    ListView courseRecordList;
    View mainView;
    View emptyView;
    RecordListAdapter recordListAdapter;


    public CourseRecordFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_course_record, container, false);
        recordListAdapter = new RecordListAdapter();

        initView(mainView);

        return mainView;

    }

    private void initView(View root) {

        courseRecordList = (ListView) root.findViewById(R.id.courseRecordList);
        emptyView = root.findViewById(R.id.emptyList);
        courseRecordList.setEmptyView(emptyView);
        courseRecordList.setAdapter(recordListAdapter);

    }


    private class RecordListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 20;
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
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.listview_item, null);
            }

            return convertView;
        }
    }


}

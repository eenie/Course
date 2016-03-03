package com.eenie.mob.course;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by Eenie on 2016/2/29.
 * Email:472279981@qq.com
 */
public class BaseExpandListView extends ExpandableListView {
    public BaseExpandListView(Context context) {
        super(context);
    }

    public BaseExpandListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseExpandListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

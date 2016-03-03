package com.eenie.mob.course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eenie.mob.course.utils.LetvParamsUtils;
import com.eenie.mob.course.utils.LetvSimplePlayBoard;
import com.letv.skin.v4.V4PlaySkin;

public class CourseVideoActivity extends AppCompatActivity {

    private LetvSimplePlayBoard playBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_video);
        initView();

    }

    private void initView() {
        V4PlaySkin playSkin = (V4PlaySkin) findViewById(R.id.videoBody);
        PlayerSkinFactory.initPlaySkin(playSkin, V4PlaySkin.SKIN_TYPE_A, false);
        playBoard = new LetvSimplePlayBoard();
        playBoard.init(this, LetvParamsUtils.setVodParams("rmc0l67qmg", "e6968be44c", "", "823948", "", false), playSkin);


    }
}

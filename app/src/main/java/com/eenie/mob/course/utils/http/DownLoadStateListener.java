package com.eenie.mob.course.utils.http;

import java.io.File;

/**
 * 下载监听器一枚
 * Created by Eenie on 2016/3/3.
 * Email:472279981@qq.com
 */
public interface DownLoadStateListener {

    void onStart();

    void onDowning(int totalSize, int currentSize);

    void onFinish();

    void onSuccessful(File file);


}

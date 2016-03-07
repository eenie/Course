package com.eenie.mob.course.utils.http;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载器一枚。
 * Created by Eenie on 2016/3/3.
 * Email:472279981@qq.com
 */
public class DownLoader {

    /**
     * 异步下载
     *
     * @param fileUrl
     * @param path
     * @param fileName
     * @param listener
     * @throws IOException
     */
    public static AsyncTask downFileAsync(final String fileUrl, final String path, final String fileName, final DownLoadStateListener listener) {
        AsyncTask asyncTask = new AsyncTask<Void, Integer, File>() {
            @Override
            protected void onPreExecute() {
                listener.onStart();
            }

            @Override
            protected File doInBackground(Void... params) {
                File file = null;
                try {
                    URL url = new URL(fileUrl);
                    file = new File(path + File.separator + fileName);
                    HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                    huc.setDoInput(true);
                    huc.setDoOutput(true);
                    huc.setConnectTimeout(3000);
                    huc.setRequestMethod("GET");
                    huc.setRequestProperty("Accept-Encoding", "identity");
                    int totalSize = huc.getContentLength();
                    int currentSize = 0;
                    BufferedInputStream bis = new BufferedInputStream(huc.getInputStream());
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buff = new byte[1024];
                    int len = bis.read(buff);
                    while (len > 0) {
                        fos.write(buff, 0, len);
                        currentSize = currentSize + len;
                        publishProgress(currentSize, totalSize);
                        len = bis.read(buff);
                    }
                    fos.flush();
                    fos.close();
                    bis.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return file;
            }

            @Override
            protected void onPostExecute(File file) {
                listener.onFinish();
                listener.onSuccessful(file);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                listener.onDowning(values[1], values[0]);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        };
        asyncTask.execute();
        return asyncTask;
    }


}

package com.eenie.mob.course;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.artifex.mupdfdemo.ChoosePDFActivity;
import com.artifex.mupdfdemo.MuPDFCore;
import com.artifex.mupdfdemo.MuPDFPageAdapter;
import com.artifex.mupdfdemo.MuPDFReaderView;
import com.artifex.mupdfdemo.SearchTask;
import com.artifex.mupdfdemo.SearchTaskResult;

public class PdfReaderActivity extends AppCompatActivity {

    RelativeLayout pdfLayout;

    private MuPDFCore core;
    private MuPDFReaderView mDocView;
    private Context mContext;
    private String mFilePath;
    private ProgressBar proPdf;
    private ActionBar actionBar;
    private TextView txtPro;
    private static final String TAG = "PdfFragment";
    SharedPreferences spfs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);


        spfs = getSharedPreferences("pdfHistory", Context.MODE_PRIVATE);

        mContext = this;
        initView();
        mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sample.pdf";
        System.out.println("mFilePath-> " + mFilePath);
        core = openFile(Uri.decode(mFilePath));
        if (core != null && core.countPages() == 0) {
            core = null;
        }
        if (core == null || core.countPages() == 0 || core.countPages() == -1) {
            Log.e(TAG, "Document Not Opening");
        }
        if (core != null) {
            proPdf.setMax(core.countPages());
            txtPro.setText(String.valueOf(1) + "/" + String.valueOf(core.countPages()));
            mDocView = new MuPDFReaderView(this) {
                @Override
                protected void onMoveToChild(int i) {
                    if (core == null)
                        return;
                    proPdf.setProgress(i + 1);
                    txtPro.setText(String.valueOf(i + 1) + "/" + String.valueOf(core.countPages()));
                    saveLastPage("sample", i);
                    super.onMoveToChild(i);
                }
            };
            mDocView.setAdapter(new MuPDFPageAdapter(mContext, core));
            mDocView.setDisplayedViewIndex(getLastPage("sample"));
            pdfLayout.addView(mDocView);
        }

    }


    private void initView() {
        pdfLayout = (RelativeLayout) findViewById(R.id.pdfLayout);
        actionBar = getSupportActionBar();
        proPdf = (ProgressBar) findViewById(R.id.proPdf);
        txtPro = (TextView) findViewById(R.id.txtPro);
    }


    /**
     * 打开PDF文件
     *
     * @param buffer 字节流
     * @return
     */
    private MuPDFCore openBuffer(byte buffer[]) {
        try {
            core = new MuPDFCore(mContext, buffer);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
        return core;
    }


    /**
     * 打开PDF文件
     *
     * @param path 文件路径
     * @return
     */
    private MuPDFCore openFile(String path) {
        int lastSlashPos = path.lastIndexOf('/');
        mFilePath = new String(lastSlashPos == -1 ? path : path.substring(lastSlashPos + 1));
        try {
            core = new MuPDFCore(mContext, path);


        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
        return core;
    }


    @Override
    public void onDestroy() {
        if (core != null)
            core.onDestroy();
        core = null;
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_file, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.openFile:
                Intent selFile = new Intent(this, ChoosePDFActivity.class);
                startActivity(selFile);
                break;
        }
        return true;
    }


    private void saveLastPage(String fileName, int pageCount) {
        SharedPreferences.Editor editor = spfs.edit();
        editor.putInt(fileName, pageCount);
        editor.commit();
    }

    private int getLastPage(String fileName) {
        return spfs.getInt(fileName, 0);
    }









}

package com.ndc.bus.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.ndc.bus.Database.BusDatabaseClient;
import com.ndc.bus.R;
import com.ndc.bus.databinding.ActivityIndexBinding;

import javax.inject.Inject;

public class IndexActivity extends BaseActivity{

    @Inject
    BusDatabaseClient busDatabaseClient;

    private ActivityIndexBinding binding;
    private static final int TIME_GIF = 1000 * 3;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    public void initSettings(){
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_index);
        binding.setActivity(this);

        //DB 호출
        InitDatabaseTask initTask = new InitDatabaseTask();
        initTask.execute();

        //처음 화면 보여주기
        showStartAni();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, TIME_GIF);
    }

    @Override
    protected void onDestroy(){
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }

    private void showStartAni(){
        Glide.with(this).load(R.raw.chu).into(binding.logoIv);
    }

    @SuppressLint("StaticFieldLeak")
    private class InitDatabaseTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(final Void... params) {
            busDatabaseClient.initBusData();
            // 데이터베이스에 데이터를 넣은 후이므로 여기서 화면 이동을 해야함
            return null;
        }
    }

}
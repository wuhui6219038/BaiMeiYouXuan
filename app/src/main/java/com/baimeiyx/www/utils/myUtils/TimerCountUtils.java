package com.baimeiyx.www.utils.myUtils;


import android.os.CountDownTimer;
import android.widget.TextView;

import com.baimeiyx.www.App;
import com.example.mrw.baimeiyouxuan.R;

public class TimerCountUtils {
    private static CountDownTimer timer;

    private TimerCountUtils() {


    }

    /**
     * @param totalTime 需要倒计时的总共时间
     * @param delay     计数的时间
     */
    public static void start(long totalTime, long delay, final TextView mTvShow) {

        timer = new CountDownTimer(totalTime, delay) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvShow.setClickable(false);
                mTvShow.setText((millisUntilFinished / 1000) + "秒后可重发");
            }

            @Override
            public void onFinish() {
                mTvShow.setEnabled(true);
                mTvShow.setText(App.INSTANCE.getResources().getString(R.string.btn_checkcode));
            }
        };
        timer.start();
    }


    public static void cancel() {
        timer.cancel();
    }
}

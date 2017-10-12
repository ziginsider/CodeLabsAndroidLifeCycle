package io.github.ziginsider.codelabsandroidlifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zigin on 07.10.2017.
 */

public class LiveDataTimerViewModel extends ViewModel {
    public static final int ONE_SECOND = 1000;

    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();

    private long mInitalTime;

    public LiveDataTimerViewModel() {
        mInitalTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        //Update the elapsed time every second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitalTime) / 1000;

                //use tne Main looper
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mElapsedTime.setValue(newValue);
                    }
                });
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    @SuppressWarnings("unused")
    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }

}

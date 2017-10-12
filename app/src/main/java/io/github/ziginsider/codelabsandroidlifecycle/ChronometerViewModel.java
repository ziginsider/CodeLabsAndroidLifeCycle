package io.github.ziginsider.codelabsandroidlifecycle;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.widget.Chronometer;

/**
 * Created by zigin on 07.10.2017.
 */

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private Long startDate;

    @Nullable
    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }
}

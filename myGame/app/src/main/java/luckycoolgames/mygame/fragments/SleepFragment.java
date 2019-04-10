package luckycoolgames.mygame.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import luckycoolgames.mygame.Activities.MainActivity;
import luckycoolgames.mygame.Activities.PlayActivity;
import luckycoolgames.mygame.R;
import luckycoolgames.mygame.RealmObjects.RealmSleep;

public class SleepFragment extends DialogFragment {
    private static final String ARG_TIMER = "argTimer";

    public static SleepFragment newInstance(long timeInSec) {
        SleepFragment fragment = new SleepFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_TIMER, timeInSec);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView timer;

    private long time;

    private Realm realm = new MainActivity().getRealm();

    private RealmSleep realmSleep;

    private long timeLeft;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sleep_fragment, container, false);
        setCancelable(false);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());


        timer = view.findViewById(R.id.timer);

        timer.setEnabled(false);
        if (getArguments() != null)
            time = getArguments().getLong(ARG_TIMER) * 1000;
        else
            time = 1000;


        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int secunds = (int) (millisUntilFinished / 1000) % 60;
                if (secunds >= 10)
                    timer.setText(minutes + ":" + secunds);
                else
                    timer.setText(minutes + ":0" + secunds);

                timeLeft = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                ((PlayActivity) getActivity()).staminaAdd(15);
                ((PlayActivity) getActivity()).healthAdd(5);

            }
        }.start();
        dismiss();

        return view;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        final RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // creating the fullscreen dialog
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return dialog;
    }

    @Override
    public void onStop() {
        if (realm != null && !realm.isClosed()) {
            timeToRealm(timeLeft);

        }
        super.onStop();

    }

    @Override
    public void onDestroy() {
        realm.close();
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        Realm.compactRealm(Realm.getDefaultConfiguration());
        if (time == 0)
            time = timeFromRealm();
    }

    public long timeFromRealm() {
        long time;
        realmSleep = realm.where(RealmSleep.class).findAllAsync().last();
        realm.beginTransaction();
        time = realmSleep.getTimeLeft();
        realm.commitTransaction();
        return time;
    }

    public void timeToRealm(long time) {
        realm.beginTransaction();
        realmSleep = realm.createObject(RealmSleep.class);
        realmSleep.setTimeLeft(time);
        realm.commitTransaction();
    }
}

package luckycoolgames.mygame.fragments;

import android.app.ActionBar;
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
import android.view.WindowManager;
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
    private long timeLeft;

    public static SleepFragment newInstance(long timeInMillis) {
        SleepFragment fragment = new SleepFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_TIMER, timeInMillis);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView timer;

    private long time;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sleep_fragment, container, false);
        setCancelable(false);

        timer = view.findViewById(R.id.timer);
        timer.setEnabled(false);


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
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        return dialog;
    }


    @Override
    public void onPause() {
        getTimeLeft();
        ((PlayActivity) getActivity()).sleepTimeToRealm(timeLeft);
        super.onPause();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            time = getArguments().getLong(ARG_TIMER);
            timeLeft = getArguments().getLong(ARG_TIMER);
        } else
            time = 0;

        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (time == timeLeft)
                    timeLeft = time - 1000;
                else
                    timeLeft = timeLeft - 1000;

                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int secunds = (int) (millisUntilFinished / 1000) % 60;
                if (secunds >= 10)
                    timer.setText(minutes + ":" + secunds);
                else
                    timer.setText(minutes + ":0" + secunds);

            }

            @Override
            public void onFinish() {
                timeLeft = 0;
                ((PlayActivity)getActivity()).allFromRealm();
                ((PlayActivity) getActivity()).staminaAdd(15);
                ((PlayActivity) getActivity()).healthAdd(5);
                ((PlayActivity)getActivity()).setAllToRealm();
                dismiss();
            }
        }.start();
    }

    /*public long timeFromRealm() {
        long time;
        RealmSleep realmSleep = realm.where(RealmSleep.class).findAllAsync().last();
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
    }*/

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }


}

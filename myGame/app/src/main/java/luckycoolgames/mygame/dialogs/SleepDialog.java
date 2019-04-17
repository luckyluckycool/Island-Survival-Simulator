package luckycoolgames.mygame.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import luckycoolgames.mygame.activities.PlayActivity;
import luckycoolgames.mygame.R;
import picker.ugurtekbas.com.Picker.Picker;

public class SleepDialog extends DialogFragment {
    private static final String ARG_TIMER = "argTimer";
    private long timeLeft;

    public static SleepDialog newInstance(long timeInMillis) {
        SleepDialog fragment = new SleepDialog();
        Bundle args = new Bundle();
            args.putLong(ARG_TIMER, timeInMillis);
            fragment.setArguments(args);
        return fragment;
    }

    private TextView timer;


    public void setTime(long time) {
        this.time = time;
    }

    private long time;
    int res;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sleep_dialog, container, false);
        setCancelable(false);

        timer = view.findViewById(R.id.timer);
        timer.setEnabled(false);

        if (getArguments().getLong(ARG_TIMER) != 0L) {
            if (((PlayActivity) getActivity()).getPlayer() != null) {
                ((PlayActivity) getActivity()).stopPlayer();
            }
            time = getArguments().getLong(ARG_TIMER);
            timeLeft = time;
            if (time>=10*1000&&time <= 60L * 1000L) {
                res = 1;
            } else if (time > 60*1000L && time <= 180*1000L) {
                res = 5;
            }
        } else {
            ((PlayActivity)getActivity()).startPlayer();
            time = 0L;
            timeLeft = time;
            dismiss();
        }

        if (timeLeft != 0L && time != 0L) {
            new CountDownTimer(time, 1000L) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (time == timeLeft)
                        timeLeft = time - 1000L;
                    else
                        timeLeft = timeLeft - 1000L;

                    int minutes = (int) (millisUntilFinished / 1000L) / 60;
                    int secunds = (int) (millisUntilFinished / 1000L) % 60;
                    if (secunds >= 10)
                        timer.setText(minutes + ":" + secunds);
                    else
                        timer.setText(minutes + ":0" + secunds);

                }

                @Override
                public void onFinish() {

                    ((PlayActivity) getActivity()).staminaAdd(res * 15);
                    ((PlayActivity) getActivity()).healthAdd(res * 5);

                    //((PlayActivity)getActivity()).sleepTimeToRealm(0);
                    ((PlayActivity) getActivity()).startPlayer();
                    dismiss();

                }
            }.start();
        } else {
            ((PlayActivity) getActivity()).startPlayer();
            dismiss();
        }
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
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        return dialog;
    }


    @Override
    public void onStop() {
        super.onStop();
        ((PlayActivity) getActivity()).sleepTimeToRealm(timeLeft);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (((PlayActivity) getActivity()).getPlayer() != null) {
            ((PlayActivity) getActivity()).stopPlayer();
        }
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }


}

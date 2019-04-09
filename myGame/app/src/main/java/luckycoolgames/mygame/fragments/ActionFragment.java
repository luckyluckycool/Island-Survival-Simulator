package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.Activities.PlayActivity;
import luckycoolgames.mygame.R;

public class ActionFragment extends Fragment {

    private ImageView eatFood, sleep;
    private TextView sleep_text;

    //eat counter
    private int n = 0;

    //resource Indexes
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);


        eatFood = view.findViewById(R.id.eat_food);
        sleep = view.findViewById(R.id.sleep);
        sleep_text = view.findViewById(R.id.sleep_text);



        switch (getBed()) {
            case 0:
                sleep.setVisibility(View.GONE);
                sleep_text.setVisibility(View.GONE);
        }


        eatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eatFoodAction();
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                switch (getBed()) {
                    case 1:
                        ((PlayActivity)getActivity()).sleepImage.setVisibility(View.VISIBLE);
                        new CountDownTimer(60000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                ((PlayActivity)getActivity()).sleepTimer.setText(""+millisUntilFinished/1000);
                            }

                            @Override
                            public void onFinish() {
                                ((PlayActivity)getActivity()).sleepTimer.setVisibility(View.GONE);
                                ((PlayActivity)getActivity()).sleepImage.setVisibility(View.GONE);
                                healthAdd(25);
                                staminaAdd(50);
                            }
                        }.start();

                        break;
                }
            }
        });


        return view;


    }


    public void eatFoodAction() {
        if (!(getFood() <= 0)) {
            foodAdd(-1);
            if (chance(0.97)) {
                staminaAdd(10);
                n++;
                if (n == 5) {
                    healthAdd(3);
                    n = 0;
                }

            } else {
                healthAdd(-5);
                n = 0;

                showSnackbar("You eat rotten food");

            }

        }
    }

    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }

    private void woodAdd(int value) {
        ((PlayActivity) getActivity()).woodAdd(value);
    }

    private void woodAdd(int value, int limit) {
        ((PlayActivity) getActivity()).woodAdd(value, limit);
    }

    private void stoneAdd(int value) {
        ((PlayActivity) getActivity()).stoneAdd(value);
    }

    private void stoneAdd(int value, int limit) {
        ((PlayActivity) getActivity()).stoneAdd(value, limit);
    }

    private void fiberAdd(int value) {
        ((PlayActivity) getActivity()).fiberAdd(value);
    }

    private void fiberAdd(int value, int limit) {
        ((PlayActivity) getActivity()).fiberAdd(value, limit);
    }

    private void foodAdd(int value) {
        ((PlayActivity) getActivity()).foodAdd(value);
    }

    private void foodAdd(int value, int limit) {
        ((PlayActivity) getActivity()).foodAdd(value, limit);
    }

    private void staminaAdd(int value) {
        ((PlayActivity) getActivity()).staminaAdd(value);
    }

    private void staminaAdd(int value, int limit) {
        ((PlayActivity) getActivity()).staminaAdd(value, limit);
    }

    private void healthAdd(int value) {
        ((PlayActivity) getActivity()).healthAdd(value);
    }

    private void healthAdd(int value, int limit) {
        ((PlayActivity) getActivity()).healthAdd(value, limit);
    }

    private int getWood() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.WOOD_INDEX));
    }

    private int getStone() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.STONE_INDEX));
    }

    private int getFiber() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.FIBER_INDEX));
    }

    private int getFood() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.FOOD_INDEX));
    }

    private int getHealth() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.HEALTH_INDEX));
    }

    private int getStamina() {
        return ((PlayActivity) getActivity()).getResourceList().get(getResources().getInteger(R.integer.STAMINA_INDEX));
    }

    private int getBed() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.BED_INDEX));
    }

    private void showSnackbar(String text) {
        ((PlayActivity) getActivity()).showSnackbar(text, 500);
    }
}

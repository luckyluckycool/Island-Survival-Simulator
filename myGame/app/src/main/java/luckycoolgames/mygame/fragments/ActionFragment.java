package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class ActionFragment extends Fragment {

private ImageView eatFood;

    //eat counter
    private int n = 0;

    //resource Indexes
    private int woodIndex = 0;
    private int stoneIndex = 1;
    private int fiberIndex = 2;
    private int foodIndex = 3;
    private int healthIndex = 4;
    private int staminaIndex = 5;
    private int woodInstrumentIndex = 6;
    private int stoneInstrumentIndex = 7;
    private int fiberInstrumentIndex = 8;
    private int foodInstrumentIndex = 9;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);
        eatFood = view.findViewById(R.id.eat_food);


        eatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eatFoodAction();
            }
        });
        return view;
    }

    public void eatFoodAction() {
        if (!(((PlayActivity)getActivity()).getResourceList().get(foodIndex) <= 0)) {
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

                final Toast toast = Toast.makeText(getContext(), "You eat rotten food", Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);

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

    private void woodAdd(int value){
        ((PlayActivity)getActivity()).woodAdd(value);
    }
    private void stoneAdd(int value){
        ((PlayActivity)getActivity()).stoneAdd(value);
    }
    private void fiberAdd(int value){
        ((PlayActivity)getActivity()).fiberAdd(value);
    }
    private void foodAdd(int value){
        ((PlayActivity)getActivity()).foodAdd(value);
    }
    private void staminaAdd(int value){
        ((PlayActivity)getActivity()).staminaAdd(value);
    }
    private void healthAdd(int value){
        ((PlayActivity)getActivity()).healthAdd(value);
    }
}

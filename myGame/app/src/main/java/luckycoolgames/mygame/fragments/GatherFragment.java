package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class GatherFragment extends Fragment {
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

    private ImageView gatherWood, gatherStone, gatherFiber, gatherFood;
    private TextView gatherWoodText, gatherStoneText, gatherFiberText, gatherFoodText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gather_fragment, container, false);
        gatherWood = view.findViewById(R.id.gather_wood_button);
        gatherStone = view.findViewById(R.id.gather_stone_button);
        gatherFiber = view.findViewById(R.id.gather_fiber_button);
        gatherFood = view.findViewById(R.id.gather_food_button);
        gatherWoodText = view.findViewById(R.id.gather_wood_text);
        gatherStoneText = view.findViewById(R.id.gather_stone_text);
        gatherFiberText = view.findViewById(R.id.gather_fiber_text);
        gatherFoodText = view.findViewById(R.id.gather_food_text);

        switch (((PlayActivity) getActivity()).getList().get(woodInstrumentIndex)) {
            case 0:
                gatherWood.setBackgroundResource(R.drawable.hand_gathering);
                gatherWoodText.setText("Gather sticks");
                break;
            case 1:
                gatherWood.setBackgroundResource(R.drawable.stone_axe_icon);
                gatherWoodText.setText("Chop trees");
                break;
        }

        switch (((PlayActivity) getActivity()).getList().get(stoneInstrumentIndex)) {

            case 0:
                gatherStone.setBackgroundResource(R.drawable.hand_gathering);
                gatherStoneText.setText("Gather stones");
                break;
            case 1:
                gatherStone.setBackgroundResource(R.drawable.stone_pickaxe_icon);
                gatherStoneText.setText("Pick stone with pickaxe");
                break;
        }
        switch (((PlayActivity) getActivity()).getList().get(fiberInstrumentIndex)) {
            case 0:
                gatherFiber.setBackgroundResource(R.drawable.hand_gathering);
                gatherFiberText.setText("Gather fiber");
                break;
            case 1:
                gatherFiber.setBackgroundResource(R.drawable.stone_sickle_icon);
                gatherFiberText.setText("Mow the grass");
                break;
        }
        switch (((PlayActivity) getActivity()).getList().get(foodInstrumentIndex)) {
            case 0:
                gatherFood.setBackgroundResource(R.drawable.hand_gathering);
                gatherFoodText.setText("Gather berries");
                break;
            case 1:
                gatherFood.setBackgroundResource(R.drawable.basket_icon);
                gatherFoodText.setText("Gather in basket");
                break;

        }

        gatherWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getList().get(woodInstrumentIndex)) {
                    case 0:
                        gatherSticks();
                        break;
                    case 1:
                        cutTreesByStoneAxe();
                        break;
                }
            }
        });

        gatherStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getList().get(stoneInstrumentIndex)) {
                    case 0:
                        gatherRocks();
                        break;
                    case 1:
                        pickStonesWithStonePickaxe();
                        break;
                }
            }
        });

        gatherFiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getList().get(fiberInstrumentIndex)) {
                    case 0:
                        gatherGrass();
                        break;
                    case 1:
                        mowGrassWithStoneSickle();
                        break;
                }
            }
        });

        gatherFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getList().get(foodInstrumentIndex)) {
                    case 0:
                        gatherBerries();
                        break;
                    case 1:
                        gatherBerriesInBasket();
                        break;
                }

            }
        });


        return view;
    }

    //Zero Instrument Level
    void gatherSticks() {

        ((PlayActivity) getActivity()).woodAdd(1);
        ((PlayActivity) getActivity()).staminaAdd(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You ran a splinter in your finger =(", Toast.LENGTH_SHORT);
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

    void gatherRocks() {
        ((PlayActivity) getActivity()).stoneAdd(1);
        ((PlayActivity) getActivity()).staminaAdd(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot finger by hided stone =(", Toast.LENGTH_SHORT);
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

    void gatherGrass() {
        ((PlayActivity) getActivity()).fiberAdd(1);
        ((PlayActivity) getActivity()).staminaAdd(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You slip and fall on the wet grass =(", Toast.LENGTH_SHORT);
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

    void gatherBerries() {
        ((PlayActivity) getActivity()).foodAdd(1);
        ((PlayActivity) getActivity()).staminaAdd(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You gather rotten berry =(", Toast.LENGTH_SHORT);
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

    //First Instrument Level
    void cutTreesByStoneAxe() {
        ((PlayActivity) getActivity()).woodAdd(3);
        ((PlayActivity) getActivity()).staminaAdd(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone axe =(", Toast.LENGTH_SHORT);
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

    void pickStonesWithStonePickaxe() {
        ((PlayActivity) getActivity()).stoneAdd(3);
        ((PlayActivity) getActivity()).staminaAdd(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone pickaxe =(", Toast.LENGTH_SHORT);
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

    void mowGrassWithStoneSickle() {
        ((PlayActivity) getActivity()).fiberAdd(3);
        ((PlayActivity) getActivity()).staminaAdd(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone sickle =(", Toast.LENGTH_SHORT);
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

    void gatherBerriesInBasket() {
        ((PlayActivity) getActivity()).foodAdd(2);
        ((PlayActivity) getActivity()).staminaAdd(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You gather basket of rotten berries =(", Toast.LENGTH_SHORT);
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




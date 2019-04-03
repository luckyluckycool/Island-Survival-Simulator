package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import luckycoolgames.mygame.Adapters.GatherRecycleAdapter;
import luckycoolgames.mygame.Adapters.RecyclerViewData;
import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class GatherFragment extends Fragment {
    RecyclerViewData data = new RecyclerViewData();
    private RecyclerView recyclerView;
    //private GatherRecycleAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;


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

        //init views
        gatherWood = view.findViewById(R.id.gather_wood_button);
        gatherStone = view.findViewById(R.id.gather_stone_button);
        gatherFiber = view.findViewById(R.id.gather_fiber_button);
        gatherFood = view.findViewById(R.id.gather_food_button);
        gatherWoodText = view.findViewById(R.id.gather_wood_text);
        gatherStoneText = view.findViewById(R.id.gather_stone_text);
        gatherFiberText = view.findViewById(R.id.gather_fiber_text);
        gatherFoodText = view.findViewById(R.id.gather_food_text);

        //setting resources
        switch (getWoodInstrument()) {
            case 0:
                gatherWood.setBackgroundResource(R.drawable.hand_gathering);
                gatherWoodText.setText("Gather sticks");
                break;
            case 1:
                gatherWood.setBackgroundResource(R.drawable.stone_axe_icon);
                gatherWoodText.setText("Chop trees");
                break;
        }
        switch (getStoneInstrument()) {

            case 0:
                gatherStone.setBackgroundResource(R.drawable.hand_gathering);
                gatherStoneText.setText("Gather stones");
                break;
            case 1:
                gatherStone.setBackgroundResource(R.drawable.stone_pickaxe_icon);
                gatherStoneText.setText("Pick stone with pickaxe");
                break;
        }
        switch (getFiberInstrument()) {
            case 0:
                gatherFiber.setBackgroundResource(R.drawable.hand_gathering);
                gatherFiberText.setText("Gather fiber");
                break;
            case 1:
                gatherFiber.setBackgroundResource(R.drawable.stone_sickle_icon);
                gatherFiberText.setText("Mow the grass");
                break;
        }
        switch (getFoodInstrument()) {
            case 0:
                gatherFood.setBackgroundResource(R.drawable.hand_gathering);
                gatherFoodText.setText("Gather berries");
                break;
            case 1:
                gatherFood.setBackgroundResource(R.drawable.basket_icon);
                gatherFoodText.setText("Gather in basket");
                break;
        }

        //commented
        /*recyclerView = view.findViewById(R.id.gatherRecycleView);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new GatherRecycleAdapter(data.gatherImages(getWoodInstrument(), getStoneInstrument(), getFiberInstrument(), getFoodInstrument()), data.gatherTexts(getWoodInstrument(), getStoneInstrument(), getFiberInstrument(), getFoodInstrument()));
        recyclerView.setAdapter(recyclerAdapter);*/

        gatherWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getWoodInstrument()) {
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
                switch (getStoneInstrument()) {
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
                switch (getFiberInstrument()) {
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
                switch (getFoodInstrument()) {
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
    public void gatherSticks() {

        woodAdd(1);
        staminaAdd(-5);

        if (chance(0.97)) {
            healthAdd(-3);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You ran a splinter in your finger =(", Toast.LENGTH_SHORT);
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

    public void gatherRocks() {
        stoneAdd(1);
        staminaAdd(-5);

        if (chance(0.97)) {
            healthAdd(-3);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot finger by hided stone =(", Toast.LENGTH_SHORT);
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

    public void gatherGrass() {
        fiberAdd(1);
        staminaAdd(-5);

        if (chance(0.97)) {
            healthAdd(-3);
            final Toast toast = Toast.makeText(getActivity(), "You slip and fall on the wet grass =(", Toast.LENGTH_SHORT);
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

    public void gatherBerries() {
        foodAdd(1);
        staminaAdd(-5);


        if (chance(0.97)) {
            healthAdd(-3);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You gather rotten berry =(", Toast.LENGTH_SHORT);
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
    public void cutTreesByStoneAxe() {
        woodAdd(3);
        staminaAdd(-10);

        if (chance(0.9)) {
            healthAdd(-10);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot by your stone axe =(", Toast.LENGTH_SHORT);
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

    public void pickStonesWithStonePickaxe() {
        stoneAdd(3);
        staminaAdd(-10);

        if (chance(0.9)) {
            healthAdd(-10);
            final Toast toast = Toast.makeText(getActivity(), "You hit your foot by your stone pickaxe =(", Toast.LENGTH_SHORT);
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

    public void mowGrassWithStoneSickle() {
        fiberAdd(3);
        staminaAdd(-10);

        if (chance(0.9)) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot by your stone sickle =(", Toast.LENGTH_SHORT);
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

    public void gatherBerriesInBasket() {
        foodAdd(2);
        staminaAdd(-5);

        double chance = Math.random();
        if (chance(0.9)) {
            ((PlayActivity) getActivity()).healthAdd(-10);
            final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You gather basket of rotten berries =(", Toast.LENGTH_SHORT);
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




    public int getWoodInstrument() {
        int woodInstrument;

        woodInstrument = ((PlayActivity) getActivity()).getResourceList().get(woodInstrumentIndex);

        return woodInstrument;
    }

    public int getFoodInstrument() {
        int foodInstrument;

        foodInstrument = ((PlayActivity) getActivity()).getResourceList().get(foodInstrumentIndex);

        return foodInstrument;
    }

    public int getFiberInstrument() {
        int fiberInstrument;

        fiberInstrument = ((PlayActivity) getActivity()).getResourceList().get(fiberInstrumentIndex);

        return fiberInstrument;
    }

    public int getStoneInstrument() {
        int stoneInstrument;

        stoneInstrument = ((PlayActivity) getActivity()).getResourceList().get(stoneInstrumentIndex);

        return stoneInstrument;
    }

    private void woodAdd(int value) {
        ((PlayActivity) getActivity()).woodAdd(value);
    }

    private void stoneAdd(int value) {
        ((PlayActivity) getActivity()).stoneAdd(value);
    }

    private void fiberAdd(int value) {
        ((PlayActivity) getActivity()).fiberAdd(value);
    }

    private void foodAdd(int value) {
        ((PlayActivity) getActivity()).foodAdd(value);
    }

    private void staminaAdd(int value) {
        ((PlayActivity) getActivity()).staminaAdd(value);
    }

    private void healthAdd(int value) {
        ((PlayActivity) getActivity()).healthAdd(value);
    }

    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }

    //commented
    /*@Override
    public void onGatherClick(int position) {
        switch (position) {
            case 0:
                switch (((PlayActivity) getActivity()).getResourceList().get(woodInstrumentIndex)) {
                    case 0:
                        gatherSticks();
                        break;
                    case 1:
                        cutTreesByStoneAxe();
                        break;
                }
                break;
            case 1:
                switch (((PlayActivity) getActivity()).getResourceList().get(stoneInstrumentIndex)) {
                    case 0:
                        gatherRocks();
                        break;
                    case 1:
                        pickStonesWithStonePickaxe();
                        break;
                }
                break;
            case 2:
                switch (((PlayActivity) getActivity()).getResourceList().get(fiberInstrumentIndex)) {
                    case 0:
                        gatherGrass();
                        break;
                    case 1:
                        mowGrassWithStoneSickle();
                        break;
                }
                break;
            case 3:
                switch (((PlayActivity) getActivity()).getResourceList().get(foodInstrumentIndex)) {
                    case 0:
                        gatherBerries();
                        break;
                    case 1:
                        gatherBerriesInBasket();
                        break;
                }
                break;

        }

    }*/
}






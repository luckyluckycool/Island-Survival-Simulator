package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import luckycoolgames.mygame.activities.PlayActivity;
import luckycoolgames.mygame.R;

//import luckycoolgames.mygame.Adapters.GatherRecycleAdapter;

public class GatherFragment extends Fragment {
    //RecyclerViewData data = new RecyclerViewData();
    //private RecyclerView recyclerView;
    //private GatherRecycleAdapter recyclerAdapter;
    //private RecyclerView.LayoutManager layoutManager;


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
                gatherStoneText.setText("Pick stone");
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
        switch (getStorage()) {
            case 0:
                if (getWood() != 20)
                    staminaAdd(-5);
                woodAdd(1, 20);
                break;
            case 1:
                if (getWood() != 75)
                    staminaAdd(-5);
                woodAdd(1, 75);
                break;
        }


        if (!chance(0.97)) {
            healthAdd(-3);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You ran a splinter in your finger =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/

            showSnackbar("You ran a splinter in your finger =(");
        }

    }

    public void gatherRocks() {
        switch (getStorage()) {
            case 0:
                if (getStone() != 20)
                    staminaAdd(-5);
                stoneAdd(1, 20);
                break;
            case 1:
                if (getStone() != 75)
                    staminaAdd(-5);
                stoneAdd(1, 75);
                break;
        }

        if (!chance(0.97)) {
            healthAdd(-3);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot finger by hided stone =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You hit your foot finger by hided stone =(");
        }
    }

    public void gatherGrass() {
        switch (getStorage()) {
            case 0:
                if (getFiber() != 20)
                    staminaAdd(-5);
                fiberAdd(1, 20);
                break;
            case 1:
                if (getFiber() != 75)
                    staminaAdd(-5);
                fiberAdd(1, 75);
                break;
        }

        if (!chance(0.97)) {
            healthAdd(-3);
            /*final Toast toast = Toast.makeText(getActivity(), "You slip and fall on the wet grass =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You slip and fall on the wet grass =(");
        }
    }

    public void gatherBerries() {
        switch (getStorage()) {
            case 0:
                if (getFood() != 20)
                    staminaAdd(-5);
                foodAdd(1, 20);

                break;
            case 1:
                if (getFood() != 75)
                    staminaAdd(-5);
                foodAdd(1, 75);
                break;
        }


        if (!chance(0.97)) {
            healthAdd(-3);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You gather rotten berry =(", Toast.LENGTH_SHORT);
            toast.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You gather rotten berry =(");
        }
    }

    //First Instrument Level
    public void cutTreesByStoneAxe() {
        switch (getStorage()) {
            case 0:
                if (getWood() != 20)
                    staminaAdd(-10);
                woodAdd(3, 20);
                break;
            case 1:
                if (getWood() != 75)
                    staminaAdd(-10);
                woodAdd(3, 75);
                break;
        }

        if (!chance(0.9)) {
            healthAdd(-10);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot by your stone axe =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You hit your foot by your stone axe =(");
        }
    }

    public void pickStonesWithStonePickaxe() {
        switch (getStorage()) {
            case 0:
                if (getStone() != 20)
                    staminaAdd(-10);
                stoneAdd(3, 20);
                break;
            case 1:
                if (getWood() != 75)
                    staminaAdd(-10);
                stoneAdd(3, 75);
                break;
        }

        if (!chance(0.9)) {
            healthAdd(-10);
            /*final Toast toast = Toast.makeText(getActivity(), "You hit your foot by your stone pickaxe =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You hit your foot by your stone pickaxe =(");
        }
    }

    public void mowGrassWithStoneSickle() {
        switch (getStorage()) {
            case 0:
                if (getFiber() != 20)
                    staminaAdd(-10);
                fiberAdd(3, 20);
                break;
            case 1:
                if (getFiber() != 75)
                    staminaAdd(-10);
                fiberAdd(3, 75);
                break;
        }

        if (!chance(0.9)) {
            healthAdd(-10);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You hit your foot by your stone sickle =(", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You hit your foot by your stone sickle =(");

        }
    }

    public void gatherBerriesInBasket() {
        switch (getStorage()) {
            case 0:
                if (getFood() != 20)
                    staminaAdd(-5);
                foodAdd(2, 20);
                break;
            case 1:
                if (getFood() != 75)
                    staminaAdd(-5);
                foodAdd(2, 75);
                break;
        }

        if (!chance(0.9)) {
            healthAdd(-10);
            /*final Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You gather basket of rotten berries =(", Toast.LENGTH_SHORT);
            toast.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 1000);*/
            showSnackbar("You gather basket of rotten berries =(");
        }
    }


    private int getWoodInstrument() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.WOOD_INSTRUMENT_INDEX));
    }

    private int getStoneInstrument() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.STONE_INSTRUMENT_INDEX));
    }

    private int getFiberInstrument() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.FIBER_INSTRUMENT_INDEX));
    }

    private int getFoodInstrument() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.FOOD_INSTRUMENT_INDEX));
    }

    private int getStorage() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.STORAGE_INDEX));
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


    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }

    private void showSnackbar(String text) {
        ((PlayActivity) getActivity()).showSnackbar(text,500);
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






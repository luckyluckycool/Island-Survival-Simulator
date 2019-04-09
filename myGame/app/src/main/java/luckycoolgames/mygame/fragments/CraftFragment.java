package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.Activities.PlayActivity;
import luckycoolgames.mygame.R;


public class CraftFragment extends Fragment {

    private ImageView craftWoodInstrument, craftStoneInstrument, craftFiberInstrument, craftFoodInstrument, craftBed, craftStorage;
    private TextView craftWoodInstrumentText, craftStoneInstrumentText, craftFiberInstrumentText, craftFoodInstrumentText, craftBedText,craftStorageText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.craft_fragment, container, false);
        //init images+texts
        craftWoodInstrument = view.findViewById(R.id.craft_wood_instrument);
        craftStoneInstrument = view.findViewById(R.id.craft_stone_instrument);
        craftFiberInstrument = view.findViewById(R.id.craft_fiber_instrument);
        craftFoodInstrument = view.findViewById(R.id.craft_food_instrument);
        craftBed = view.findViewById(R.id.craft_bed);
        craftStorage = view.findViewById(R.id.craft_storage);

        craftWoodInstrumentText = view.findViewById(R.id.craft_wood_instrument_text);
        craftStoneInstrumentText = view.findViewById(R.id.craft_stone_instrument_text);
        craftFiberInstrumentText = view.findViewById(R.id.craft_fiber_instrument_text);
        craftFoodInstrumentText = view.findViewById(R.id.craft_food_instrument_text);
        craftBedText = view.findViewById(R.id.craft_bed_text);
        craftStorageText = view.findViewById(R.id.craft_storage_text);

        craftWoodInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (getWoodInstrument()) {
                    case 0:
                        if (isWood(5) && isStone(3) && isFiber(10) && isStamina(20)) {
                            staminaAdd(-20);
                            if (chance(0.8)) {
                                craft(5, 3, 10, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.WOOD_INDEX), 1);
                                craftWoodInstrument.setVisibility(View.GONE);
                                craftWoodInstrumentText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 5 woods, 3 stones, 10 fibers and 20 stamina");
                        }
                        break;
                }
            }
        });

        craftStoneInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getStoneInstrument()) {
                    case 0:
                        if (isWood(4) && isStone(4) && isFiber(10) && isStamina(20)) {
                            staminaAdd(-20);
                            if (chance(0.8)) {
                                craft(4, 4, 10, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.STONE_INSTRUMENT_INDEX), 1);
                                craftStoneInstrument.setVisibility(View.GONE);
                                craftStoneInstrumentText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 4 woods, 4 stones, 10 fibers and 20 stamina");
                        }
                        break;
                }
            }
        });
        craftFiberInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getFiberInstrument()) {
                    case 0:
                        if (isWood(3) && isStone(3) && isFiber(8) && isStamina(20)) {
                            staminaAdd(-20);
                            if (chance(0.8)) {
                                craft(3, 3, 8, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.FIBER_INSTRUMENT_INDEX), 1);
                                craftFiberInstrument.setVisibility(View.GONE);
                                craftFiberInstrumentText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 3 woods, 3 stones, 8 fibers and 20 stamina");
                        }
                        break;
                }
            }
        });
        craftFoodInstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getFoodInstrument()) {
                    case 0:
                        if (isFiber(20) && isStamina(20)) {
                            staminaAdd(-20);
                            if (chance(0.8)) {
                                craft(0, 0, 20, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.FOOD_INSTRUMENT_INDEX), 1);
                                craftFoodInstrument.setVisibility(View.GONE);
                                craftFoodInstrumentText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 20 fibers and 20 stamina");
                        }
                        break;
                }
            }
        });

        craftStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getStorage()) {
                    case 0:
                        if (isWood(20)&&isFiber(15) && isStamina(20)) {
                            staminaAdd(-20);
                            if (chance(0.8)) {
                                craft(20, 0, 15, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.STORAGE_INDEX), 1);
                                craftStorage.setVisibility(View.GONE);
                                craftStorageText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 20 wood, 15 fibers and 20 stamina");
                        }
                        break;
                }
            }
        });

        craftBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getBed()) {
                    case 0:
                        if (isWood(30)&&isFiber(40) && isStamina(50)) {
                            staminaAdd(-50);
                            if (chance(0.8)) {
                                craft(30, 0, 40, 0, 0, 0);
                                ((PlayActivity) getActivity()).getBuildedList().set(getResources().getInteger(R.integer.BED_INDEX), 1);
                                craftBed.setVisibility(View.GONE);
                                craftBedText.setVisibility(View.GONE);
                            } else {
                                healthAdd(-5);
                                showSnackbar("Nice try, but you have two left hands");
                            }
                        } else {
                            showSnackbar("You need 30 wood, 40 fibers and 50 stamina");
                        }
                        break;
                }
            }
        });

        //switches of lvl of instrument
        switch (getWoodInstrument()) {
            case 1:
                craftWoodInstrument.setVisibility(View.GONE);
                craftWoodInstrumentText.setVisibility(View.GONE);
                break;
        }
        switch (getStoneInstrument()) {
            case 1:
                craftStoneInstrument.setVisibility(View.GONE);
                craftStoneInstrumentText.setVisibility(View.GONE);
                break;
        }
        switch (getFiberInstrument()) {
            case 1:
                craftFiberInstrument.setVisibility(View.GONE);
                craftFiberInstrumentText.setVisibility(View.GONE);
                break;

        }
        switch (getFoodInstrument()) {
            case 1:
                craftFoodInstrument.setVisibility(View.GONE);
                craftFoodInstrumentText.setVisibility(View.GONE);
                break;
        }
        switch (getBed()) {
            case 1:
                craftBed.setVisibility(View.GONE);
                craftBedText.setVisibility(View.GONE);
                break;
        }

        switch (getStorage()) {
            case 1:
                craftStorage.setVisibility(View.GONE);
                craftStorageText.setVisibility(View.GONE);
                break;
        }


        return view;
    }

    private void craft(int wood, int stone, int fiber, int food, int stamina, int health) {
        woodAdd(-wood);
        stoneAdd(-stone);
        fiberAdd(-fiber);
        foodAdd(-food);
        staminaAdd(stamina);
        healthAdd(health);
    }

    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
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

    private int getWoodInstrument() {

        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.WOOD_INSTRUMENT_INDEX));
    }

    private int getFoodInstrument() {
        int foodInstrument;

        foodInstrument = ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.FOOD_INSTRUMENT_INDEX));

        return foodInstrument;
    }

    private int getFiberInstrument() {
        int fiberInstrument;

        fiberInstrument = ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.FIBER_INSTRUMENT_INDEX));

        return fiberInstrument;
    }

    private int getStoneInstrument() {
        int stoneInstrument;

        stoneInstrument = ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.STONE_INSTRUMENT_INDEX));

        return stoneInstrument;
    }

    private int getBed() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.BED_INDEX));
    }

    private int getStorage() {
        return ((PlayActivity) getActivity()).getBuildedList().get(getResources().getInteger(R.integer.STORAGE_INDEX));
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

    private boolean isWood(int valueToCraft) {
        if (getWood() >= valueToCraft)
            return true;
        else
            return false;
    }

    private boolean isStone(int valueToCraft) {
        if (getStone() >= valueToCraft)
            return true;
        else
            return false;
    }

    private boolean isFiber(int valueToCraft) {
        if (getFiber() >= valueToCraft)
            return true;
        else
            return false;
    }

    private boolean isFood(int valueToCraft) {
        if (getFood() >= valueToCraft)
            return true;
        else
            return false;
    }

    private boolean isStamina(int valueToCraft) {
        if (getStamina() >= valueToCraft)
            return true;
        else
            return false;
    }

    private boolean isHealth(int valueToCraft) {
        if (getHealth() >= valueToCraft)
            return true;
        else
            return false;
    }

    private void showSnackbar(String text) {
        ((PlayActivity) getActivity()).showSnackbar(text, 1500);
    }
}

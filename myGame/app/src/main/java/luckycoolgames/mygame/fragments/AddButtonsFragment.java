package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;
import luckycoolgames.mygame.Resources.types.Wood;

public class AddButtonsFragment extends Fragment {

   private ImageView gather_wood, gather_stone, gather_fiber, gather_food, back;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_buttons_fragment, container, false);
        gather_wood = view.findViewById(R.id.gather_wood_button);
        gather_stone = view.findViewById(R.id.gather_stone_button);
        gather_fiber = view.findViewById(R.id.gather_fiber_button);
        gather_food = view.findViewById(R.id.gather_food_button);
        back = view.findViewById(R.id.back);

        gather_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gather_sticks();
            }
        });
        gather_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gather_rocks();
            }
        });
        gather_fiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gather_grass();
            }
        });
        gather_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gather_berries();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionButtonFragment actionButtonFragment = new ActionButtonFragment();
                ((PlayActivity) getActivity()).fragmentManager.beginTransaction().replace(R.id.frame_for_action_buttons, actionButtonFragment).commit();
            }
        });


        return view;
    }

    void gather_sticks() {

        ((PlayActivity) getActivity()).wood_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
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

    void gather_rocks() {
        ((PlayActivity) getActivity()).stone_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
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

    void gather_grass() {
        ((PlayActivity) getActivity()).fiber_button_action(2);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
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

    void gather_berries() {
        ((PlayActivity) getActivity()).food_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
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


}





























    //Можна додати тости про втрату причини



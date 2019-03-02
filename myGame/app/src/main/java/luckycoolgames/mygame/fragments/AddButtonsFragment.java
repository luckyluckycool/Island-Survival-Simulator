package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class AddButtonsFragment extends Fragment {
    LinearLayout linearLayout;
        ImageView gather_wood, gather_stone, gather_fiber, gather_food;
        public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_buttons_fragment, container, false);
        gather_wood = view.findViewById(R.id.gather_wood_button);
        gather_stone = view.findViewById(R.id.gather_stone_button);
        gather_fiber = view.findViewById(R.id.gather_fiber_button);
        gather_food = view.findViewById(R.id.gather_food_button);

        gather_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PlayActivity)getActivity()).wood_button_action(5);
            }
        });



        return view;
    }

    void gather_sticks(){
        ((PlayActivity)getActivity()).wood_button_action(5);
        ((PlayActivity)getActivity()).stamina_button_action(-5);
        double a = Math.random();
        if (a + 0.9 >= 1) {
            ((PlayActivity)getActivity()).health_button_action(-5);
        }
    }
   private double health_random(){
      double chance = Math.random();
      return chance;
   }
}

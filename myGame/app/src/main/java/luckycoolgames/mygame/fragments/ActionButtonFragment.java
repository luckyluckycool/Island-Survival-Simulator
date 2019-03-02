package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class ActionButtonFragment extends Fragment {
    private ImageView gather_button, craft_button;
    FragmentManager fragmentManager = getFragmentManager();
    AddButtonsFragment addButtonsFragment = new AddButtonsFragment();
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_buttons_fragment, container, false);
        gather_button = view.findViewById(R.id.gather_button);
        craft_button = view.findViewById(R.id.craft_button);

        gather_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_for_action_buttons, addButtonsFragment);
            }
        });

        return view;
    }
}

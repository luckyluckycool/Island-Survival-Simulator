package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import luckycoolgames.mygame.R;

public class ActionButtonFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_buttons_fragment, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.action_buttons_fragment);
        return view;
    }
}

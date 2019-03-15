package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.victor.loading.rotate.RotateLoading;

import luckycoolgames.mygame.R;

public class LoadingFragment extends Fragment {
    private RotateLoading rotateLoading;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_fragment, container, false);
        rotateLoading = view.findViewById(R.id.rotateLoading);
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(rotateLoading.isStart()){
                    rotateLoading.stop();
                }else {
                    rotateLoading.start();
                }
            }
        },0);

    }

    public RotateLoading getRotateLoading() {
        return rotateLoading;
    }
}

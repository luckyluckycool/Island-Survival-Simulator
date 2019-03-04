/*
package luckycoolgames.mygame;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AndroidGestureActivity extends Activity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary mLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if (!mLibrary.load()) {
            finish();
        }
        GestureOverlayView gestures =  findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);

    }
    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if(predictions.size() > 0&& predictions.get(0).score>1.0){
            String result = predictions.get(0).name;
            if ("backFragment".equalsIgnoreCase(result)){
                Toast toast = Toast.makeText(this, "Opening the document", Toast.LENGTH_LONG);
                toast.show();
            }else if ("save".equalsIgnoreCase(result)){
                Toast toast = Toast.makeText(this, "Saving the document", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
*/

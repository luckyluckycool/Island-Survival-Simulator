package luckycoolgames.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import luckycoolgames.mygame.Resources.types.Fiber;
import luckycoolgames.mygame.Resources.types.Food;
import luckycoolgames.mygame.Resources.types.Health;
import luckycoolgames.mygame.Resources.types.Stamina;
import luckycoolgames.mygame.Resources.types.Stone;
import luckycoolgames.mygame.Resources.types.Wood;

public class PlayActivity extends AppCompatActivity {
    TextView wood_text, stone_text, fiber_text, food_text;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        wood_text =findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);

        final Wood wood = new Wood();
        final Stone stone = new Stone();
        final Fiber fiber = new Fiber();
        final Food food = new Food();
        final Health  health = new Health();
        final Stamina stamina = new Stamina();


    }
}

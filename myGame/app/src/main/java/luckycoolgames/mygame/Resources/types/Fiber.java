package luckycoolgames.mygame.Resources.types;

public class Fiber extends BasicRes {
    int fiber=0;

    @Override
   public void add(int value) {
        res = fiber;
        super.add(value);
    }
}

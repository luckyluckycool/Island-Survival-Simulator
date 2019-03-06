package luckycoolgames.mygame.Resources.types;

public class Fiber extends BasicRes {


    private int fiber=0;

    @Override
   public void add(int value) {
        res = fiber;
        super.add(value);
        fiber=res;

    }

    @Override
   public int get() {
        res = fiber;
        return super.get();
    }

    @Override
   public void set(int value) {
        super.set(value);
        fiber = res;
    }
}

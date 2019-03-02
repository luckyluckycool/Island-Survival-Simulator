package luckycoolgames.mygame.Resources.types;

public class Food extends BasicRes {
   private int food=0;

    @Override
   public void add(int value) {
       res = food;
        super.add(value);
        food=res;
    }

    @Override
   public int get() {
        res = food;
        return super.get();
    }
}

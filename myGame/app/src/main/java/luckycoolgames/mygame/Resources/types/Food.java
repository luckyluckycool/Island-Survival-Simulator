package luckycoolgames.mygame.Resources.types;

public class Food extends BasicRes {
   private int food=0;

    @Override
   public void add(int value) {
       res = food;
        super.add(value);
    }

    public int getFood() {
        return food;
    }
}

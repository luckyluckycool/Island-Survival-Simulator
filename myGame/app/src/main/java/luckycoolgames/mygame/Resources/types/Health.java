package luckycoolgames.mygame.Resources.types;

public class Health extends BasicRes {
private int health = 100;

    @Override
   public void add(int value) {
        res = health;
        super.add(value);
        health = res;
    }

    @Override
   public int get() {
        res = health;
        return super.get();
    }
}

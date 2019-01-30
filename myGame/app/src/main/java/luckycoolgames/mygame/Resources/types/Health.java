package luckycoolgames.mygame.Resources.types;

public class Health extends BasicRes {
int health;

    @Override
   public void add(int value) {
        res = health;
        super.add(value);
        health = res;
    }
}

package luckycoolgames.mygame.Resources.types;

public class Stamina extends BasicRes {
private int stamina = 100;

    @Override
   public void add(int value) {
        res = stamina;
        super.add(value);
        stamina=res;
    }

    @Override
   public int get() {
        res = stamina;
        return super.get();
    }

    @Override
   public void set(int value) {
        super.set(value);
        stamina = res;
    }
}

package luckycoolgames.mygame.Resources.types;

public class Stamina extends BasicRes {
private int stamina;

    @Override
   public void add(int value) {
        res = stamina;
        super.add(value);
        stamina=res;
    }

    public int getStamina() {
        return stamina;
    }
}

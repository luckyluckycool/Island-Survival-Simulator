package luckycoolgames.mygame.Resources.types;

public class Stamina extends BasicRes {
int stamina;

    @Override
   public void add(int value) {
        res = stamina;
        super.add(value);
        stamina=res;
    }
}

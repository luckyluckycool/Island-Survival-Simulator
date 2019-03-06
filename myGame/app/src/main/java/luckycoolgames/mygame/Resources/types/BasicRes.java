package luckycoolgames.mygame.Resources.types;



public class BasicRes {
    int res;
   protected void add(int value){
       if(!(res+value<0)) {
           res += value;
       }
    }
    public int get(){
       return res;
    }
   public void set(int value){
        res = value;
    }
}

package luckycoolgames.mygame;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class MyBook extends RealmObject{

  private RealmList<Integer> list = new RealmList<>();

  public RealmList<Integer> getList() {
    return list;
  }

  public void setList(List<Integer> arrayList) {
    list.addAll(arrayList);
  }
}

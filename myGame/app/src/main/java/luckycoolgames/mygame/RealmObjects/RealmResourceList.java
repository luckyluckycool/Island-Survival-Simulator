package luckycoolgames.mygame.RealmObjects;

import android.graphics.Bitmap;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmResourceList extends RealmObject {

    private RealmList<Integer> list = new RealmList<>();

    public RealmList<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> arrayList) {
        list.addAll(arrayList);
    }


}

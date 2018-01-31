package nyc.c4q.marvelcomicsdb.service;

import android.util.Log;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by c4q on 1/30/18.
 */

public class RealmServiceManager {

  private static final String TAG = "RealmManager";

  private static Realm realm;

  private static RealmConfiguration realmConfiguration;

  public static void initializeRealmConfiguration() {
    if (realmConfiguration == null) {
      Log.d(TAG, "onRealm configuration");
      setRealmConfiguration(
          new RealmConfiguration.Builder().name("favorites").schemaVersion(1).build());
    }
  }

  public static void setRealmConfiguration(RealmConfiguration realmConfiguration) {
    RealmServiceManager.realmConfiguration = realmConfiguration;
    Realm.setDefaultConfiguration(realmConfiguration);
  }

  public static Realm getRealm() {
    realm = Realm.getDefaultInstance();
    return realm;
  }

}

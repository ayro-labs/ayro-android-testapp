package io.ayro.testapp;

import android.support.multidex.MultiDexApplication;

import io.ayro.Ayro;
import io.ayro.Settings;

public class CustomApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    Settings settings = new Settings(BuildConfig.APP_TOKEN);
    Ayro.init(this, settings);
  }
}

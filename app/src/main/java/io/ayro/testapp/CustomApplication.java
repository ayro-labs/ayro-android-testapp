package io.ayro.testapp;

import android.support.multidex.MultiDexApplication;

import io.ayro.Ayro;
import io.ayro.Settings;

public class CustomApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    Settings settings = new Settings(getString(R.string.ayro_token));
    Ayro.init(this, settings);
  }
}

package io.ayro.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import io.ayro.Ayro;
import io.ayro.User;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupAyro();
    setupButton();
  }

  private void setupAyro() {
    User user = new io.ayro.User();
    user.setUid("1");
    user.setFirstName("Sandro");
    user.setLastName("Simas");
    user.setEmail("sandro.csimas@gmail.com");
    user.setSignUpDate(new Date());
    user.setProperties(new HashMap<String, String>());
    user.getProperties().put("Language", Locale.getDefault().getCountry());
    Ayro.login(user);
  }

  private void setupButton() {
    Button openChatButton = (Button) findViewById(R.id.open_chat);
    openChatButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Ayro.openChat();
      }
    });
  }
}

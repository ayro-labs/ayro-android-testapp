package io.ayro.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import io.ayro.Ayro;
import io.ayro.User;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupButton();
  }

  private void setupButton() {
    Button openChatButton = findViewById(R.id.open_chat);
    openChatButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Ayro.openChat();
      }
    });

    Button loginChatButton = findViewById(R.id.login);
    loginChatButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        User user = new User();
        user.setUid("1");
        user.setFirstName("Sandro");
        user.setLastName("Simas");
        user.setEmail("sandro@ayro.io");
        user.setPhotoUrl("https://scontent.xx.fbcdn.net/v/t1.0-1/11709651_882143908522388_6031653989057086887_n.jpg?oh=42e99275199e478ebdc1b019445dbd41&oe=5A6A7A5D");
        user.setSignUpDate(new Date());
        Map<String, String> properties = new HashMap<>();
        properties.put("Language", Locale.getDefault().getCountry());
        user.setProperties(properties);
        Ayro.login(user);
      }
    });

    Button updateUserButton = findViewById(R.id.update_user);
    updateUserButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        User user = new User();
        user.setSignUpDate(new Date());
        Ayro.updateUser(user);
      }
    });

    Button logoutButton = findViewById(R.id.logout);
    logoutButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Ayro.logout();
      }
    });
  }
}

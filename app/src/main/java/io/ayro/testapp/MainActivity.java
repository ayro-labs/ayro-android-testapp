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
        String jwtToken = BuildConfig.JWT_TOKEN;
        User user = new User();
        user.setUid("1");
        user.setFirstName("Sandro");
        user.setLastName("Simas");
        user.setEmail("sandro@ayro.io");
        user.setPhotoUrl("https://en.gravatar.com/userimage/20045636/1927002100f29c81ae539754f30f5c37.png");
        user.setSignUpDate(new Date());
        Map<String, String> properties = new HashMap<>();
        properties.put("Language", Locale.getDefault().getCountry());
        user.setProperties(properties);
        Ayro.login(user, jwtToken);
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

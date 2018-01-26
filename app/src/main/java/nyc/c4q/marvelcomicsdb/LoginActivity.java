package nyc.c4q.marvelcomicsdb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.database.sqlite.SQLiteDatabase;

import android.widget.Toast;

import java.util.List;

import loginDatabase.User;
import loginDatabase.UserDatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private ImageView background;
    private Button signIn, signUp;
    private CheckBox checkBox;
    private SharedPreferences login;
    private UserDatabaseHelper userDatabaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        background = findViewById(R.id.login_bgd);
        checkBox = findViewById(R.id.checkbox_remember_me);

        email = findViewById(R.id.email_entry);
        password = findViewById(R.id.password_entry);

        signIn = findViewById(R.id.button_login);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyUser();

            }
        });

        signUp = findViewById(R.id.link_create_account);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
                finish();
            }
        });

        crossFadeBackground();
    }

    public void crossFadeBackground() {
        final int DrawableImage[] = {R.drawable.bgd_iron_man,R.drawable.bgd_spiderman,R.drawable.bgd_thor, R.drawable.bgd_storm, R.drawable.bgd_captian_america, R.drawable.bgd_dare_devil, R.drawable.bgd_hulk};
        final Handler handler = new Handler();
        final int[] i = {0};
        final int[] j = {1};
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Resources res = getApplicationContext().getResources();
                        TransitionDrawable out = new TransitionDrawable(new Drawable[]{res.getDrawable(DrawableImage[i[0]]), res.getDrawable(DrawableImage[j[0]])});
                        out.setCrossFadeEnabled(true);
                        background.setImageDrawable(out);
                        out.startTransition(6000);
                        i[0]++;
                        j[0]++;
                        if (j[0] == DrawableImage.length) {
                            j[0] = 0;
                        }
                        if (i[0] == DrawableImage.length) {
                            i[0] = 0;
                        }
                        handler.postDelayed(this, 6000);
                    }
                });
            }
        }, 0);
    }

    public void verifyUser() {
        try {
            userDatabaseHelper = new UserDatabaseHelper(getApplicationContext());
            user = userDatabaseHelper.getUser(email.getText().toString(), password.getText().toString());

            List<User> userList = userDatabaseHelper.getUserList();
            for (User user : userList) {
                Log.d("CHECK DATABASE", user.getName()+" "+user.getEmail()+" "+user.getPassword());
            }

            if (user == null) {
                email.setError("Please Enter a Valid Email");
                password.setError("PLease Enter a Valid Password");
            } else {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
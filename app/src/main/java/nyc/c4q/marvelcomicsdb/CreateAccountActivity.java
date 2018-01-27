package nyc.c4q.marvelcomicsdb;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.marvelcomicsdb.loginDatabase.User;
import nyc.c4q.marvelcomicsdb.loginDatabase.UserDatabaseHelper;

public class CreateAccountActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    private ImageView background;
    private TextView name, email, password, passwordVerify;
    private Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        background = findViewById(R.id.sign_up_bgd);
        name = findViewById(R.id.input_name);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        passwordVerify = findViewById(R.id.input_confirm_password);

        signIn = findViewById(R.id.link_login);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
                finish();
            }
        });

        signUp = findViewById(R.id.button_create_account);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        crossFadeBackground();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    public void crossFadeBackground() {
        final int DrawableImage[] = {R.drawable.bgd_iron_man, R.drawable.bgd_spiderman, R.drawable.bgd_thor, R.drawable.bgd_storm, R.drawable.bgd_captian_america, R.drawable.bgd_dare_devil, R.drawable.bgd_hulk};
        handler = new Handler();
        final int[] i = {0};
        final int[] j = {1};
        runnable = new Runnable() {
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
        };
        handler.postDelayed(runnable, 0);
    }

    private void registerUser() {
        String nameInput = name.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        String confirmPassword = passwordVerify.getText().toString().trim();

        if (nameInput.isEmpty()) {
            name.requestFocus();
            name.setError("Required");
            return;

        } else if (emailInput.isEmpty()) {
            email.requestFocus();
            email.setError("Required");
            return;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email");
            return;

        } else if (passwordInput.isEmpty()) {
            password.requestFocus();
            password.setError("Required");
            return;

        } else if (password.length() < 6) {
            password.requestFocus();
            password.setError("Password must be a minimum of 6 characters");
            return;

        } else if (confirmPassword.isEmpty()) {
            passwordVerify.requestFocus();
            passwordVerify.setError("Required");
            return;

        } else if (!confirmPassword.contentEquals(passwordInput)) {
            passwordVerify.requestFocus();
            passwordVerify.setError("Password Mismatch");
            return;

        } else {
            UserDatabaseHelper userDatabaseHelper = new UserDatabaseHelper(getApplicationContext());
            userDatabaseHelper.addUser(new User(name.getText().toString(), email.getText().toString(), password.getText().toString()));
            startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
            finish();
        }

    }

}

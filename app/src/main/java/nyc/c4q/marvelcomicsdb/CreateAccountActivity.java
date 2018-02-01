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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.marvelcomicsdb.loginDatabase.User;
import nyc.c4q.marvelcomicsdb.loginDatabase.UserDatabaseHelper;

public class CreateAccountActivity extends AppCompatActivity {
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
        int imagesToShow[] = {R.drawable.bgd_storm, R.drawable.bgd_thor, R.drawable.bgd_captian_america, R.drawable.bgd_dare_devil, R.drawable.bgd_hulk, R.drawable.bgd_iron_man, R.drawable.bgd_spiderman};

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

        animate(background, imagesToShow, 0, true);
    }

    private void animate(final ImageView imageView, final int images[], final int imageIndex, final boolean forever) {
        int fadeInDuration = 500; // Configure time values here
        int timeBetween = 3000;
        int fadeOutDuration = 1000;

        imageView.setVisibility(View.INVISIBLE);    //Visible or invisible by default - this will apply when the animation ends
        imageView.setImageResource(images[imageIndex]);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
        fadeOut.setStartOffset(fadeInDuration);
        fadeOut.setDuration(fadeOutDuration + timeBetween);

        AnimationSet animation = new AnimationSet(false); // change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(1);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (images.length - 1 > imageIndex) {
                    animate(imageView, images, imageIndex + 1, forever); //Calls itself until it gets to the end of the array
                } else {
                    if (forever) {
                        animate(imageView, images, 0, forever);  //Calls itself to start the animation all over again in a loop if forever = true
                    }
                }
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
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

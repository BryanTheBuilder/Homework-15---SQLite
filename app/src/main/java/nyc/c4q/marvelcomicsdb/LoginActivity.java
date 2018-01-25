package nyc.c4q.marvelcomicsdb;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import nyc.c4q.marvelcomicsdb.model.creator.Image;

public class LoginActivity extends AppCompatActivity {
    private ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        background = findViewById(R.id.login_bgd);

        Button login = findViewById(R.id.button_login);
        Button signUp = findViewById(R.id.button_create_account);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
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
        final int DrawableImage[] = {R.drawable.bgd_thor, R.drawable.bgd_storm, R.drawable.bgd_the_flash, R.drawable.bgd_captian_america, R.drawable.bgd_dare_devil, R.drawable.bgd_hulk};

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
                        out.startTransition(4000);
                        i[0]++;
                        j[0]++;
                        if (j[0] == DrawableImage.length) {
                            j[0] = 0;
                        }
                        if (i[0] == DrawableImage.length) {
                            i[0] = 0;
                        }
                        handler.postDelayed(this, 8000);
                    }
                });
            }
        }, 0);
    }
}

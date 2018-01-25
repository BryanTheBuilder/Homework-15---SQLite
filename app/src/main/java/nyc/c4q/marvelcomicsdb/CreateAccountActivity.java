package nyc.c4q.marvelcomicsdb;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CreateAccountActivity extends AppCompatActivity {
    private ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        background = findViewById(R.id.sign_up_bgd);
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

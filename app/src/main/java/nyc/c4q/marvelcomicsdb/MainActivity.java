package nyc.c4q.marvelcomicsdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import nyc.c4q.marvelcomicsdb.API.NewsDBService;
import nyc.c4q.marvelcomicsdb.Utils.PrivateAPI;
import nyc.c4q.marvelcomicsdb.controller.NewsAdapter;
import nyc.c4q.marvelcomicsdb.fragments.CharactersFragment;
import nyc.c4q.marvelcomicsdb.fragments.ComicFragment;
import nyc.c4q.marvelcomicsdb.fragments.CreatorFragment;
import nyc.c4q.marvelcomicsdb.model.News.Articles;
import nyc.c4q.marvelcomicsdb.model.News.NewsDataWrapper;
import nyc.c4q.marvelcomicsdb.model.comics.Comic;
import nyc.c4q.marvelcomicsdb.service.NewsDatabaseServiceGenerator;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private static final NewsDBService marvelNewsCallback = NewsDatabaseServiceGenerator
      .createService();
  private RecyclerView newsRecyclerView;
  private List<Articles> articlesList = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Realm.init(getBaseContext());
    RealmServiceManager.initializeRealmConfiguration();

    newsRecyclerView = findViewById(R.id.news_rv);
    NewsAdapter newsAdapter = new NewsAdapter(articlesList);
    LinearLayoutManager newsLayoutManager = new LinearLayoutManager(getApplicationContext(),
        LinearLayoutManager.VERTICAL, false);
    newsRecyclerView.setAdapter(newsAdapter);
    newsRecyclerView.setLayoutManager(newsLayoutManager);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    getMarvelNewsData();
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    Fragment fragment = null;
    Class fragmentClass;

    switch (item.getItemId()) {
      case R.id.nav_characters:
        fragmentClass = CharactersFragment.class;
        break;
      case R.id.nav_comic_books:
        fragmentClass = ComicFragment.class;
        break;
      case R.id.nav_creators:
        fragmentClass = CreatorFragment.class;
        break;
      default:
        fragmentClass = CharactersFragment.class;
        break;
    }

    try {
      fragment = (Fragment) fragmentClass.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction().replace(R.id.main_frame, fragment).addToBackStack(null).commit();

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void getMarvelNewsData() {
    Call<NewsDataWrapper> call = marvelNewsCallback
        .getNewsDiscover(PrivateAPI.getNewsApiKey());
    call.enqueue(new Callback<NewsDataWrapper>() {
      @Override
      public void onResponse(Call<NewsDataWrapper> call, Response<NewsDataWrapper> response) {
        List<Articles> responseList = response.body().getArticles();
        newsRecyclerView.setAdapter(new NewsAdapter(responseList));
        Log.d("News Callback", "onSuccess: " + response.isSuccessful());
      }

      @Override
      public void onFailure(Call<NewsDataWrapper> call, Throwable t) {
        Log.d("News Callback", "onFailure: ", t.fillInStackTrace());
      }
    });
  }

}

package com.example.joe.st_giorgis_app;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Matches.OnFragmentInteractionListener, Home.OnFragmentInteractionListener, News.OnFragmentInteractionListener, Shop.OnFragmentInteractionListener, News_detail.OnFragmentInteractionListener, Membership.OnFragmentInteractionListener{

    private DrawerLayout drawer;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        private final int SPLASH_DISPLAY_LENGTH = 1000;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        default home fragment
        loadFragment(new Home());


        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ham_menu);
        actionbar.setDisplayHomeAsUpEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
//      for navigation drawer click handler


        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                android.support.v4.app.Fragment fragment = null;

               switch (item.getItemId()){
                   case R.id.st_home: {
                       fragment = new Home();
                       break;
                   }
                   case R.id.st_matches: {
                        fragment = new Matches();
                        break;
                   }
                   case R.id.st_news: {
                       fragment = new News();
                       break;
                   }
                   case R.id.st_shp: {
                        fragment = new Shop();
                        break;
                   }
               }
               return loadFragment(fragment);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                android.support.v4.app.Fragment fragment = null;

                switch (item.getItemId()) {
//                   navigation drawer menu clicks
                    case R.id.dnav_home: {
                        fragment = new Home();
                       View view = bottomNavigationView.findViewById(R.id.st_home);
                       view.performClick();
                        break;
                    }
                    case R.id.dnav_matches: {
                        fragment = new Matches();
                        View view = bottomNavigationView.findViewById(R.id.st_matches);
                        view.performClick();
                        break;
                    }
                    case R.id.dnav_club: {
                        fragment = new News();
                        View view = bottomNavigationView.findViewById(R.id.st_news);
                        view.performClick();
                        break;
                    }
                    case R.id.dnav_shop: {
                        fragment = new Shop();
                        View view = bottomNavigationView.findViewById(R.id.st_shp);
                        view.performClick();
                        break;
                    }
                    case R.id.dnav_membership:{
                        fragment = new Membership();
                        View view = bottomNavigationView.findViewById(R.id.st_home);
                        break;
                    }
                }
                drawer.closeDrawers();
                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment (android.support.v4.app.Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notification) {
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.nav_view){
            drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.noida.authority;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.noida.authority.activity.NotificationActivity;
import com.noida.authority.adapter.DrawerAdapter;
import com.noida.authority.body_model.DrawerCategory;
import com.noida.authority.fragment.AboutUs;
import com.noida.authority.fragment.Contact;
import com.noida.authority.fragment.Faq;
import com.noida.authority.fragment.Feedback;
import com.noida.authority.fragment.Home;
import com.noida.authority.fragment.MyProfile;
import com.noida.authority.fragment.MyRequest;
import com.noida.authority.fragment.PrivacyPolicy;
import com.noida.authority.fragment.TermService;
import com.noida.authority.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;
    BottomNavigationView navigation;
    RecyclerView drawer_recyclerview;
    FrameLayout main_frame;
    Fragment fragment = null;
    ImageView imgNotification;
    List<DrawerCategory> list;
    DrawerLayout drawer;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


        drawer_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(this, drawer_recyclerview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(final View view, final int position) {

                fragment = list.get(position).getFragment();
                loadFragment(fragment);
                setTitle(list.get(position).getCategory());
                drawer.closeDrawer(GravityCompat.START);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void initViews() {
        drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_menu);


        title = findViewById(R.id.title);
        navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(this);

        drawer_recyclerview = findViewById(R.id.drawer_recyclerview);
        drawer_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        drawer_recyclerview.setAdapter(new DrawerAdapter(this, initDrawerList()));


        imgNotification = findViewById(R.id.imgNotification);
        imgNotification.setOnClickListener(this);
        main_frame = findViewById(R.id.main_frame);
        fragment = new Home();
        loadFragment(fragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgNotification:
                Intent i = new Intent(this, NotificationActivity.class);
                startActivity(i);

                break;
        }
    }

    List<DrawerCategory> initDrawerList() {
        list = new ArrayList<>();

        list.add(new DrawerCategory("Home", R.drawable.ic_home, new Home()));
        list.add(new DrawerCategory("My Profile", R.drawable.ic_profile, new MyProfile()));
        list.add(new DrawerCategory("About US", R.drawable.ic_about_us, new AboutUs()));
        list.add(new DrawerCategory("Message from CEO", R.drawable.ic_message, new AboutUs()));

        list.add(new DrawerCategory("Noida Administrative Structure", R.drawable.ic_structure, new Home()));
        list.add(new DrawerCategory("Organisation Chart", R.drawable.ic_org_chart, new Home()));
        list.add(new DrawerCategory("FAQ", R.drawable.ic_faq, new Faq()));
        list.add(new DrawerCategory("Terms of Use", R.drawable.ic_term_use, new TermService()));

        list.add(new DrawerCategory("Privacy Policy", R.drawable.ic_privacy_policy, new PrivacyPolicy()));
        list.add(new DrawerCategory("Feedback", R.drawable.ic_feedback, new Feedback()));
        list.add(new DrawerCategory("Contact Us", R.drawable.ic_contact_us, new Contact()));
        list.add(new DrawerCategory("Log out", R.drawable.ic_logout, new Home()));

        return list;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else if (fragment instanceof Home) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "click BACK again to go Exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        } else {
            fragment = new Home();
            loadFragment(fragment);
            navigation.getMenu().getItem(0).setChecked(true);
            setTitle("Home");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                fragment = new Home();
                loadFragment(fragment);
                setTitle("Home");
                return true;

            case R.id.history:
                fragment = new MyRequest();
                loadFragment(fragment);
                setTitle("My Request");
                return true;

            case R.id.profile:
                fragment = new MyProfile();
                loadFragment(fragment);
                setTitle("My Profile");
                return true;
        }

        return false;
    }

    void setTitle(String t) {
        title.setText(t);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
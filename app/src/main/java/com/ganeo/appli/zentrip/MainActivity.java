package com.ganeo.appli.zentrip;

import android.os.Bundle;
import android.view.MenuItem;

import com.ganeo.appli.zentrip.preference.PrefsManager;
import com.ganeo.appli.zentrip.preference.PrefsManager_;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    public NavController navController;
    public BottomNavigationView bottomNavigationView;
    protected PrefsManager prefsManager;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefsManager = PrefsManager_.getInstance_(this);
        setupNavigation();
    }


    // Setting Up One Time Navigation
    private void setupNavigation() {


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        bottomNavigationView = findViewById(R.id.navigation);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_search:
                navController.navigate(R.id.action_global_bookingFragment);
                break;
            case R.id.navigation_bookings:
                if (prefsManager.isLogged())
                    navController.navigate(R.id.action_global_bookingsFragment);
                else
                    navController.navigate(R.id.action_global_loginFragment);
                break;
            case R.id.navigation_account:
                if (prefsManager.isLogged())
                    navController.navigate(R.id.action_global_accountFragment);
                else
                    navController.navigate(R.id.action_global_loginFragment);
                break;
            case R.id.navigation_more:
                navController.navigate(R.id.action_global_moreFragment);
                break;
        }
        return true;
    }


}



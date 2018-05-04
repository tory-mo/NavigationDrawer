package by.torymo.navigationdrawer;



import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);

        final NavigationMenuItem llBasic = navigationView.findViewById(R.id.nav_basic);
        final NavigationMenuItem llDriver = navigationView.findViewById(R.id.nav_driver);
        final NavigationMenuItem llDach = navigationView.findViewById(R.id.nav_country);
        final NavigationMenuItem llFisher = navigationView.findViewById(R.id.nav_fisher);
        final NavigationMenuItem llTourist = navigationView.findViewById(R.id.nav_tourist);
        final NavigationMenuItem llEcologist = navigationView.findViewById(R.id.nav_ecologist);
        final NavigationMenuItem llSettings = navigationView.findViewById(R.id.nav_settings);
        final NavigationMenuItem llWarning = navigationView.findViewById(R.id.nav_warning);

        View.OnClickListener navClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                String chosenProfile = "";

                llBasic.setChecked(false);
                llDriver.setChecked(false);
                llDach.setChecked(false);
                llFisher.setChecked(false);
                llTourist.setChecked(false);
                llEcologist.setChecked(false);
                llSettings.setChecked(false);
                llWarning.setChecked(false);
                NavigationMenuItem navigationMenuItem = (NavigationMenuItem) view;
                navigationMenuItem.setChecked(true);

                switch (id) {
                    case R.id.nav_basic:
                        chosenProfile = getString(R.string.profile_base);
                        break;
                    case R.id.nav_country:
                        chosenProfile = getString(R.string.profile_dach);
                        break;
                    case R.id.nav_driver:
                        chosenProfile = getString(R.string.profile_auto);
                        break;
                    case R.id.nav_ecologist:
                        chosenProfile = getString(R.string.profile_ecologyst);

                        break;
                    case R.id.nav_fisher:
                        chosenProfile = getString(R.string.profile_fisherman);
                        break;
                    case R.id.nav_tourist:
                        chosenProfile = getString(R.string.profile_tourist);
                        break;
                    case R.id.nav_settings:
//                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//                        startActivity(intent);
                        drawer.closeDrawers();
                        return;
                    case R.id.nav_warning:
//                        Intent warningIntent = new Intent(MainActivity.this, StormActivity.class);
//                        warningIntent.putExtra(StormActivity.ACTIVITY_EXTRA, NUMBER);
//                        startActivityForResult(warningIntent, STORM_REQUEST_CODE);
                        drawer.closeDrawers();
                        return;
                }
                //selectProfile(chosenProfile, true);
                Toast.makeText(MainActivity.this,id + " - " + chosenProfile,Toast.LENGTH_LONG).show();
                drawer.closeDrawers();
                return;
            }
        };

        llBasic.setOnClickListener(navClick);
        llDriver.setOnClickListener(navClick);
        llDach.setOnClickListener(navClick);
        llFisher.setOnClickListener(navClick);
        llTourist.setOnClickListener(navClick);
        llEcologist.setOnClickListener(navClick);
        llSettings.setOnClickListener(navClick);
        llWarning.setOnClickListener(navClick);

    }
}

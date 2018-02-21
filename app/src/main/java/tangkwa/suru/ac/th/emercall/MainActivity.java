package tangkwa.suru.ac.th.emercall;

import android.content.ClipData;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import tangkwa.suru.ac.th.emercall.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create Toolbar
        Toolbar toolbar = findViewById(R.id.ToolbarMain);
       setSupportActionBar(toolbar);
       getSupportActionBar().setHomeButtonEnabled(true);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       drawerLayout = findViewById(R.id.drawerLayoutmain);
       actionBarDrawerToggle = new ActionBarDrawerToggle(
               MainActivity.this,
               drawerLayout,
               R.string.open,
               R.string.close

       );
       drawerLayout.setDrawerListener(actionBarDrawerToggle);

//        Add Fragment
        if (savedInstanceState== null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFrgment,new MainFragment()).commit();

        }
    }  //Main Method

    @Override
    public boolean onConfigurationChanged(Configuration newConfig) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }
}  // Main class

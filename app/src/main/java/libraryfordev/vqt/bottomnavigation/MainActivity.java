package libraryfordev.vqt.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //chen item menu
        bottomNavigation.inflateMenu(R.menu.bottom_menu);
        //khi mo ung dung thi lay fragment dau tien mac dinh
        fragment = new BlankFragment();
        changeFragnment();
        //su kien khi cham vao
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //lay id cua item duoc cham vao
                int id = item.getItemId();
                //id item nao thi thay doi fragment phu hop voi id ay
                switch (id) {
                    case R.id.action_home:
                        fragment = new BlankFragment();
                        break;
                    case R.id.action_dashboard:
                        fragment = new Blank2Fragment();
                        break;
                    case R.id.action_notification:
                        fragment = new Blank3Fragment();
                        break;
                }
                //thay doi fragment tuong ung
                changeFragnment();
                return true;
            }
        });
    }
//thay doi fragment khi bam vao item
    void changeFragnment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();
    }
}
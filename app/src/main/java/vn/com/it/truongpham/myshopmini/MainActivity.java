package vn.com.it.truongpham.myshopmini;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import vn.com.it.truongpham.myshopmini.fragment.FragmentBH;
import vn.com.it.truongpham.myshopmini.fragment.FragmentLoaiSP;
import vn.com.it.truongpham.myshopmini.fragment.FragmentSP;
import vn.com.it.truongpham.myshopmini.fragment.FragmentThem;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
   Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new FragmentLoaiSP();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment=new FragmentSP();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment=new FragmentBH();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation:
                    fragment=new FragmentThem();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment=new FragmentLoaiSP();
        loadFragment(fragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

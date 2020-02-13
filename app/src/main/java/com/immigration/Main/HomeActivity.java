package com.immigration.Main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.Animation.MyBounceInterpolator;
import com.immigration.Fragment.ChooseWorkFragment;
import com.immigration.Fragment.HomeFragment;
import com.immigration.Fragment.QueryFragment;
import com.immigration.Login.LoginActivity;
import com.immigration.R;
import com.immigration.Utills.utills;

public class HomeActivity extends AppCompatActivity {

    private ActionBar toolbar;
    SharedPreferences sharedpreferences;
    private ImageView call_query;
    private ImageView exit_icon;
    private ImageView home_icon;
    private ImageView menu_icon;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        sharedpreferences = getSharedPreferences(utills.MyPREFERENCES, Context.MODE_PRIVATE);

        Log.e("ID", sharedpreferences.getString(utills.ID, ""));
        Log.e("NAME", sharedpreferences.getString(utills.Name, ""));

        toolbar = getSupportActionBar();

        call_query = findViewById(R.id.call_query);
        exit_icon = findViewById(R.id.exit_icon);
        home_icon = findViewById(R.id.home_icon);
        menu_icon = findViewById(R.id.menu_icon);

        // load the store fragment by default
        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());
        Log.e("HOme", String.valueOf(toolbar.getTitle()));

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        call_query.startAnimation(myAnim);

        call_query.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                Log.e("Bhanu", "Call");
//                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("9829194215"));
                onCallBtnClick();
            }
        });

        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(HomeActivity.this, menu_icon);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.right_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.immigration_point:
                                loadFragment(new HomeFragment());
                                return true;
                            case R.id.profile_skill:
                                loadFragment(new ChooseWorkFragment());
                                return true;
                            case R.id.immigration_blog:
                                loadFragment(new HomeFragment());
                                return true;
                            case R.id.expert_query:
                                loadFragment(new QueryFragment());
                                return true;
                            case R.id.logout:
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString(utills.ID, "");
                                editor.putString(utills.Name, "");
                                editor.putString(utills.Phone, "");
                                editor.putString(utills.Email, "");
                                editor.commit();
                                Intent logout = new Intent(HomeActivity.this, LoginActivity.class);
                                startActivity(logout);
                                finishAffinity();
                                return true;
                            default:
                                return HomeActivity.super.onContextItemSelected(item);
                        }
                    }
                });

                popup.show();
            }
        });

    }

    private void onCallBtnClick(){
        if (Build.VERSION.SDK_INT < 23) {
            phoneCall();
        }else {

            if (ActivityCompat.checkSelfPermission(HomeActivity.this,
                    Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                phoneCall();
            }else {
                final String[] PERMISSIONS_STORAGE = {Manifest.permission.CALL_PHONE};
                //Asking request Permissions
                ActivityCompat.requestPermissions(HomeActivity.this, PERMISSIONS_STORAGE, 9);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean permissionGranted = false;
        switch(requestCode){
            case 9:
                permissionGranted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                break;
        }
        if(permissionGranted){
            phoneCall();
        }else {
            Toast.makeText(HomeActivity.this, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    private void phoneCall(){
        if (ActivityCompat.checkSelfPermission(HomeActivity.this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:8866880707"));
            HomeActivity.this.startActivity(callIntent);
        }else{
            Toast.makeText(HomeActivity.this, "You don't assign permission.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
            finish();
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }
}

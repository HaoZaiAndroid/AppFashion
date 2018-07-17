package com.example.sorelion.fashion.activity;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private static final int TAB_ONE_INDEX = 0;
    private static final int TAB_TWO_INDEX = 1;
    private static final int TAB_THREE_INDEX = 2;

    private ViewPager mainViewPager;
    private ImageView ivTitleOne;
    private ImageView ivTitleTwo;
    private ImageView ivTitleThree;
    private ImageView ivTitleMenu;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initID(mainBinding);
    }

    private void initID(ActivityMainBinding mainBinding) {
        mainViewPager = mainBinding.mainViewPager;
        ivTitleMenu = mainBinding.ivTitleMenu;
        mainViewPager = mainBinding.mainViewPager;
        ivTitleOne = mainBinding.ivTitleOne;
        ivTitleTwo = mainBinding.ivTitleTwo;
        ivTitleThree = mainBinding.ivTitleThree;
    }

    private void initFragment() {

    }


}

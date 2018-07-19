package com.example.sorelion.fashion.activity;



import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.sorelion.fashion.R;
import com.example.sorelion.fashion.adapter.TabPagerAdapter;
import com.example.sorelion.fashion.databinding.ActivityMainBinding;
import com.example.sorelion.fashion.fragment.MusicFragment;
import com.example.sorelion.fashion.fragment.RecommendFragment;
import com.example.sorelion.fashion.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int TAB_MUSIC_INDEX = 0;
    private static final int TAB_RECOMMEND_INDEX = 1;
    private static final int TAB_VIDEO_INDEX = 2;
    ActivityMainBinding mainBinding;
    private ViewPager mainViewPager;
    private ImageView ivMusic;
    private ImageView ivRecommend;
    private ImageView ivVideo;

    private ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            setCurrentItem(position);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        init();
    }

    private void init() {
        initID();
        initFragment();
        initListener();
        setCurrentItem(TAB_MUSIC_INDEX);
    }

    private void initListener() {
        mainViewPager.addOnPageChangeListener(pageChangeListener);
        ivMusic.setOnClickListener(this);
        ivRecommend.setOnClickListener(this);
        ivVideo.setOnClickListener(this);
    }

    private void initID() {
        mainViewPager = mainBinding.mainViewPager;
        mainViewPager = mainBinding.mainViewPager;
        ivMusic = mainBinding.ivTitleOne;
        ivRecommend = mainBinding.ivTitleTwo;
        ivVideo = mainBinding.ivTitleThree;
    }

    private void initFragment() {
        List<Fragment> list = new ArrayList<>();
        MusicFragment musicFragment = new MusicFragment();
        RecommendFragment recommendFragment = new RecommendFragment();
        VideoFragment videoFragment = new VideoFragment();
        list.add(musicFragment);
        list.add(recommendFragment);
        list.add(videoFragment);
        mainViewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), list));

    }

    /**
     * 切换页面
     *
     * @param position 分类角标
     */
    private void setCurrentItem(int position) {
        boolean isMusic = false;
        boolean isRecommend = false;
        boolean isVideo = false;
        switch (position) {
            case TAB_MUSIC_INDEX:
                isMusic = true;
                break;
            case TAB_RECOMMEND_INDEX:
                isRecommend = true;
                break;
            case TAB_VIDEO_INDEX:
                isVideo = true;
                break;
            default:
                isMusic = true;
                break;
        }
        mainViewPager.setCurrentItem(position);
        ivMusic.setSelected(isMusic);
        ivRecommend.setSelected(isRecommend);
        ivVideo.setSelected(isVideo);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_one:
                setCurrentItem(TAB_MUSIC_INDEX);
                break;
            case R.id.iv_title_two:
                setCurrentItem(TAB_RECOMMEND_INDEX);
                break;
            case R.id.iv_title_three:
                setCurrentItem(TAB_VIDEO_INDEX);
                break;

            default:
                break;
        }
    }
}

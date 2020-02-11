package com.android.fashion.base;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    // 布局view
    protected SV bindingView;

}

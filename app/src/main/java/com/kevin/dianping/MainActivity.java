package com.kevin.dianping;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kevin.dianping.fragment.FragmentMy;
import com.kevin.dianping.fragment.FragmentSearch;
import com.kevin.dianping.fragment.FragmentTuan;
import com.kevin.dianping.fragment.fragmentHome;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/12/6.
 * 第一步支持FragmentActivity
 * 第二步实现OnCheckedChangeListener方法，对按钮选择实现一些列的监听
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.main_button_tabs)
    private RadioGroup radioGroup;
    @ViewInject(R.id.main_home)
    private RadioButton main_home;
    //管理fragment类
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //初始化fragmentManager
        fragmentManager = getSupportFragmentManager();
        //设置默认选中
        main_home.setChecked(true);
        //设置每个按钮都可以选择的监听事件
        radioGroup.setOnCheckedChangeListener(this);
        //切换不同的fragment
        changeFragment(new fragmentHome(),false);
    }
//根据不同的id来遍历，然后切换不同的点击内容
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_home:
                changeFragment(new fragmentHome(),true);
                break;
            case R.id.main_search:
                changeFragment(new FragmentSearch(),true);
                break;
            case R.id.main_my:
                changeFragment(new FragmentMy(),true);
                break;
            case R.id.main_tuan:
                changeFragment(new FragmentTuan(),true);
                break;
            default:
                break;
        }
    }
    //切换不同的fragment
    private void changeFragment(Fragment fragment ,boolean isInit){
        //fragment的使用需要开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //进行不同的值进行填充
        transaction.replace(R.id.main_content,fragment);
        //提交
        //进行判断，看是否是第一次进行初始化，避免重影的想象
        if (!isInit){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }

//    @Event(value = R.id.btn_test_xutils)
//    private void Click(View v){
//        Toast.makeText(this,"测试xUtils",Toast.LENGTH_SHORT).show();
//    }
}

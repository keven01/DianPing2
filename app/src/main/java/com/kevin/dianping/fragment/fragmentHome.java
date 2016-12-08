package com.kevin.dianping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.dianping.R;

/**
 * Created by Administrator on 2016/12/8.
 * 首页
 */

public class fragmentHome extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //使用inflater 方法映射一个xml文件
        View view = inflater.inflate(R.layout.home_index,null);
        return view;
    }
}

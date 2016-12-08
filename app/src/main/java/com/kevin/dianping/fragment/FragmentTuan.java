package com.kevin.dianping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.dianping.R;


/**
 * Created by Administrator on 2016/10/22.
 * 团购
 */

public class FragmentTuan extends Fragment {
    //团购
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuan_index,null);
        return view;
    }
}

package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganeo.appli.zentrip.R;

public class MoreFragment extends BaseFragment {


    public MoreFragment() {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.more_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
}

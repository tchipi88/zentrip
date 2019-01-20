package com.ganeo.appli.zentrip.fragment;


import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.AndroidSupportInjection;


public abstract class BaseViewModelFragment<V extends ViewModel> extends BaseFragment {


    @Inject
    protected ViewModelProvider.Factory viewModelFactory;

    protected V viewModel;


    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(getViewModel());
    }


}

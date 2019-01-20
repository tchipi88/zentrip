package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.viewmodel.BookingListViewModel;


public class BookingListFragment extends BaseViewModelFragment<BookingListViewModel> {

    @Override
    protected Class<BookingListViewModel> getViewModel() {
        return BookingListViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.booking_list_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
}

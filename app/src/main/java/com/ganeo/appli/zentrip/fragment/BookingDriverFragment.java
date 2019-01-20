
package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.adapter.DriverListAdapter;
import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.model.Driver;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.OnClick;

import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;

public class BookingDriverFragment extends BaseViewModelFragment<BookingViewModel> implements DriverListAdapter.OnItemClickListener, DriverListAdapter.OnReloadClickListener {

    public static final int PAGE_SIZE = 30;
    @Bind(R.id.drivers)
    RecyclerView recyclerView;
    @Bind(R.id.empty_view)
    View emptyView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.error_ll)
    LinearLayout errorLinearLayout;
    @Bind(R.id.error_tv)
    TextView errorTextView;
    @Bind(R.id.reload_btn)
    Button reloadButton;
    private boolean isLastPage = false;
    private int currentPage = 0;
    private boolean isLoading = false;
    private LinearLayoutManager layoutManager;
    private DriverListAdapter driverListAdapter;
    private Observer<List<Driver>> loadInitialDriversObserver = driverList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (driverList != null) {

            if (driverList.size() == 0) {
                emptyView.setVisibility(View.VISIBLE);
            }
            if (driverList.size() > 0)
                driverListAdapter.addAll(driverList);

            if (driverList.size() >= PAGE_SIZE) {
                driverListAdapter.addFooter();
            } else {
                isLastPage = true;
            }
        }
    };
    private Observer<List<Driver>> loadDriversObserver = driverList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (driverList != null) {
            if (driverList.size() > 0)
                driverListAdapter.addAll(driverList);

            if (driverList.size() >= PAGE_SIZE) {
                driverListAdapter.addFooter();
            } else {
                isLastPage = true;
            }
        }
    };
    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }
        }
    };

    @Override
    protected Class<BookingViewModel> getViewModel() {
        return BookingViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.booking_driver_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        driverListAdapter = new DriverListAdapter();
        driverListAdapter.setOnItemClickListener(this);
        driverListAdapter.setOnReloadClickListener(this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(driverListAdapter);

        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), VERTICAL);
        recyclerView.addItemDecoration(itemDecor);

        // Pagination
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);

        viewModel.getLoading().observe(this, loading -> {
            if (Boolean.FALSE.equals(loading)) {
                isLoading = false;
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.getError().observe(this, error -> {
            if (Boolean.TRUE.equals(error)) {
                errorTextView.setText("Can't load data.\nCheck your network connection.");
                errorLinearLayout.setVisibility(View.VISIBLE);
            }
        });


        viewModel.getRemoveFooter().observe(this, removeFooter -> {
            if (Boolean.TRUE.equals(removeFooter)) {
                driverListAdapter.removeFooter();
            }
        });

        viewModel.getUpdateFooter().observe(this, updateFooter -> {
            if (Boolean.TRUE.equals(updateFooter)) {
                driverListAdapter.updateFooter(DriverListAdapter.FooterType.ERROR);
            }
        });


        viewModel.loadDrivers(currentPage, PAGE_SIZE).observe(this, loadInitialDriversObserver);

        for(Driver driver:Driver.populateData()){
            driverListAdapter.add(driver);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        removeListeners();
        currentPage = 0;
    }


    @Override
    public void onReloadClick() {
        driverListAdapter.updateFooter(DriverListAdapter.FooterType.LOAD_MORE);
        viewModel.loadDrivers(currentPage, PAGE_SIZE).observe(this, loadDriversObserver);
    }


    private void loadMoreItems() {
        isLoading = true;
        currentPage += 1;
        viewModel.loadDrivers(currentPage, PAGE_SIZE).observe(this, loadDriversObserver);

    }


    private void removeListeners() {
        recyclerView.removeOnScrollListener(recyclerViewOnScrollListener);
    }


    @Override
    public void onItemClick(int position, View view) {
        Driver driver = driverListAdapter.getItem(position);
        if (driver != null) {
            Booking booking=viewModel.getBookingObservable().getValue();
            booking.driverId=driver.id;
            viewModel.setBooking(booking);
            viewModel.setDriver(driver);
            NavHostFragment.findNavController(BookingDriverFragment.this).navigate(R.id.action_bookingDriverFragment_to_bookingConfirmationFragment);
        }
    }


    @OnClick(R.id.reload_btn)
    public void onReloadButtonClicked() {
        errorLinearLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        viewModel.loadDrivers(currentPage, PAGE_SIZE).observe(this, loadInitialDriversObserver);
    }


}


package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.adapter.BookingListAdapter;
import com.ganeo.appli.zentrip.adapter.BookingListAdapter;
import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Car;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.OnClick;

import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;


public class BookingListFragment extends BaseViewModelFragment<BookingViewModel> implements  BookingListAdapter.OnReloadClickListener {

   

 

    public static final int PAGE_SIZE = 30;
    @Bind(R.id.bookings)
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
    private BookingListAdapter bookingListAdapter;
    private Observer<List<Booking>> loadInitialBookingsObserver = bookingList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (bookingList != null) {

            if (bookingList.size() == 0) {
                emptyView.setVisibility(View.VISIBLE);
            }
            if (bookingList.size() > 0)
                bookingListAdapter.addAll(bookingList);

            if (bookingList.size() >= PAGE_SIZE) {
                bookingListAdapter.addFooter();
            } else {
                isLastPage = true;
            }
        }
    };
    private Observer<List<Booking>> loadBookingsObserver = bookingList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (bookingList != null) {
            if (bookingList.size() > 0)
                bookingListAdapter.addAll(bookingList);

            if (bookingList.size() >= PAGE_SIZE) {
                bookingListAdapter.addFooter();
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
        return R.layout.booking_list_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        bookingListAdapter = new BookingListAdapter();
        bookingListAdapter.setOnReloadClickListener(this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bookingListAdapter);


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
                bookingListAdapter.removeFooter();
            }
        });

        viewModel.getUpdateFooter().observe(this, updateFooter -> {
            if (Boolean.TRUE.equals(updateFooter)) {
                bookingListAdapter.updateFooter(BookingListAdapter.FooterType.ERROR);
            }
        });


        viewModel.loadBookings(currentPage, PAGE_SIZE).observe(this, loadInitialBookingsObserver);
        for(Booking booking:Booking.populateData()){
            bookingListAdapter.add(booking);
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
        bookingListAdapter.updateFooter(BookingListAdapter.FooterType.LOAD_MORE);
        viewModel.loadBookings(currentPage, PAGE_SIZE).observe(this, loadBookingsObserver);
    }


    private void loadMoreItems() {
        isLoading = true;
        currentPage += 1;
        viewModel.loadBookings(currentPage, PAGE_SIZE).observe(this, loadBookingsObserver);

    }


    private void removeListeners() {
        recyclerView.removeOnScrollListener(recyclerViewOnScrollListener);
    }


   


    @OnClick(R.id.reload_btn)
    public void onReloadButtonClicked() {
        errorLinearLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        viewModel.loadBookings(currentPage, PAGE_SIZE).observe(this, loadInitialBookingsObserver);
    }


}

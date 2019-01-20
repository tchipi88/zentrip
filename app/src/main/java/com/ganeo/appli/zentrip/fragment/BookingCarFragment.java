package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.adapter.CarListAdapter;
import com.ganeo.appli.zentrip.model.Car;
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


public class BookingCarFragment extends BaseViewModelFragment<BookingViewModel> implements CarListAdapter.OnItemClickListener, CarListAdapter.OnReloadClickListener {


    public static final int PAGE_SIZE = 30;
    @Bind(R.id.cars)
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
    private CarListAdapter carListAdapter;
    private Observer<List<Car>> loadInitialCarsObserver = carList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (carList != null) {

            if (carList.size() == 0) {
                emptyView.setVisibility(View.VISIBLE);
            }
            if (carList.size() > 0)
                carListAdapter.addAll(carList);

            if (carList.size() >= PAGE_SIZE) {
                carListAdapter.addFooter();
            } else {
                isLastPage = true;
            }
        }
    };
    private Observer<List<Car>> loadCarsObserver = carList -> {
        isLoading = false;
        progressBar.setVisibility(View.GONE);
        if (carList != null) {
            if (carList.size() > 0)
                carListAdapter.addAll(carList);

            if (carList.size() >= PAGE_SIZE) {
                carListAdapter.addFooter();
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
        return R.layout.booking_car_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        carListAdapter = new CarListAdapter();
        carListAdapter.setOnItemClickListener(this);
        carListAdapter.setOnReloadClickListener(this);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(carListAdapter);

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
                carListAdapter.removeFooter();
            }
        });

        viewModel.getUpdateFooter().observe(this, updateFooter -> {
            if (Boolean.TRUE.equals(updateFooter)) {
                carListAdapter.updateFooter(CarListAdapter.FooterType.ERROR);
            }
        });


        viewModel.loadCars(currentPage, PAGE_SIZE).observe(this, loadInitialCarsObserver);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        removeListeners();
        currentPage = 0;
    }


    @Override
    public void onReloadClick() {
        carListAdapter.updateFooter(CarListAdapter.FooterType.LOAD_MORE);
        viewModel.loadCars(currentPage, PAGE_SIZE).observe(this, loadCarsObserver);
    }


    private void loadMoreItems() {
        isLoading = true;
        currentPage += 1;
        viewModel.loadCars(currentPage, PAGE_SIZE).observe(this, loadCarsObserver);

    }


    private void removeListeners() {
        recyclerView.removeOnScrollListener(recyclerViewOnScrollListener);
    }


    @Override
    public void onItemClick(int position, View view) {
        Car Car = carListAdapter.getItem(position);
        if (Car != null) {
            //TODO set car
            NavHostFragment.findNavController(BookingCarFragment.this).navigate(R.id.action_bookingCarFragment_to_bookingDriverFragment);
        }
    }


    @OnClick(R.id.reload_btn)
    public void onReloadButtonClicked() {
        errorLinearLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        viewModel.loadCars(currentPage, PAGE_SIZE).observe(this, loadInitialCarsObserver);
    }


}

package com.ganeo.appli.zentrip.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.Bind;
import butterknife.OnClick;

public class BookingConfirmationFragment extends BaseViewModelFragment<BookingViewModel> {
    @Override
    protected Class<BookingViewModel> getViewModel() {
        return BookingViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.booking_confirmation_fragment;
    }

    @Bind(R.id.depart)
    TextView depart;
    @Bind(R.id.arrive)
    TextView arrive;
    @Bind(R.id.duree)
    TextView duree;
    @Bind(R.id.car)
    TextView car;
    @Bind(R.id.driver)
    TextView driver;

    ProgressDialog progressDialog = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        viewModel.getBookingObservable().observe(this, booking -> {

            depart.setText("Départ de " + booking.townFrom + " le " + booking.dateDebut);
            arrive.setText("Départ de " + booking.townTo + " le " + booking.dateFin);

        });
        viewModel.getCarObservable().observe(this, car1 -> {
            car.setText(car1.model + " " + car1.marque);
        });
        viewModel.getDriverObservable().observe(this, driver1 -> {
            driver.setText(driver1.getPrenom() + " " + driver1.getNom());
        });

        progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Saving...");


        return rootView;
    }

    @OnClick(R.id.edit)
    public void editResa(View view) {
        NavHostFragment.findNavController(BookingConfirmationFragment.this).navigate(R.id.action_global_bookingFragment);
    }

    @OnClick(R.id.confirm)
    public void confirmResa(View view) {


        progressDialog.show();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

              //  viewModel.addBooking(viewModel.getBookingObservable().getValue());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                //insert Event to Calendar

                NavHostFragment.findNavController(BookingConfirmationFragment.this).navigate(R.id.action_global_bookingsFragment);
            }
        }.execute();




    }

}

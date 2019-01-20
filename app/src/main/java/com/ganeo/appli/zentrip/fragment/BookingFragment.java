package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;

import java.util.Calendar;

import androidx.navigation.fragment.NavHostFragment;
import butterknife.OnClick;
import ru.slybeaver.slycalendarview.SlyCalendarDialog;


public class BookingFragment extends BaseViewModelFragment<BookingViewModel> implements SlyCalendarDialog.Callback {

    @Override
    protected Class<BookingViewModel> getViewModel() {
        return BookingViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.booking_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);


        return rootView;
    }


    @OnClick(R.id.card_dateDebut)
    public void setDateDebut(View view) {
        new SlyCalendarDialog()
                .setSingle(false)
                .setCallback(this)
                .show(getFragmentManager(), "TAG_SLYCALENDAR");
    }

    @OnClick(R.id.card_dateFin)
    public void setDateFin(View view) {
        new SlyCalendarDialog()
                .setSingle(false)
                .setCallback(this)
                .show(getFragmentManager(), "TAG_SLYCALENDAR");
    }

    @OnClick(R.id.btn_booking)
    public void setBooking(View view) {
        NavHostFragment.findNavController(BookingFragment.this).navigate(R.id.action_BookingFragment_to_bookingCarFragment);
    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            if (secondDate == null) {
                firstDate.set(Calendar.HOUR_OF_DAY, hours);
                firstDate.set(Calendar.MINUTE, minutes);
                Toast.makeText(
                        getActivity(),
                        firstDate.toString(),
                        Toast.LENGTH_LONG

                ).show();
            } else {
                Toast.makeText(
                        getActivity(),
                        firstDate.toString() + "  " + secondDate.toString(),
                        Toast.LENGTH_LONG

                ).show();
            }
        }
    }
}

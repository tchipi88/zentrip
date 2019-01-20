package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Town;
import com.ganeo.appli.zentrip.model.enumeration.StatusBooking;
import com.ganeo.appli.zentrip.utils.DateUtils;
import com.ganeo.appli.zentrip.viewmodel.BookingViewModel;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;

import androidx.navigation.fragment.NavHostFragment;
import butterknife.Bind;
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

    @Bind(R.id.townFrom)
    AutoCompleteTextView townFrom;
    @Bind(R.id.townTo)
    AutoCompleteTextView townTo;

    @Bind(R.id.dateDebut)
    TextView dateDebut;
    @Bind(R.id.dateFin)
    TextView dateFin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.select_dialog_item, Town.populate());
        townFrom.setAdapter(adapter);
        townFrom.setThreshold(1);
        townTo.setAdapter(adapter);
        townTo.setThreshold(1);

        dateDebut.setText(DateUtils.getStringDate(LocalDate.now()));
        dateFin.setText(DateUtils.getStringDate(LocalDate.now()));

        viewModel.getBookingObservable().observe(this, booking -> {
            dateDebut.setText(booking.dateDebut);
            dateFin.setText(booking.dateFin);
            townTo.setText(booking.townTo);
            townFrom.setText(booking.townFrom);
        });

        return rootView;
    }


    @OnClick(R.id.card_dateDebut)
    public void setDateDebut(View view) {
        new SlyCalendarDialog()
                .setSingle(false)
                .setCallback(this)
                .setStartDate(new Date())
                .show(getFragmentManager(), "TAG_SLYCALENDAR");
    }

    @OnClick(R.id.card_dateFin)
    public void setDateFin(View view) {
        new SlyCalendarDialog()
                .setSingle(false)
                .setCallback(this)
                .setStartDate(new Date())
                .show(getFragmentManager(), "TAG_SLYCALENDAR");
    }

    @OnClick(R.id.btn_booking)
    public void setBooking(View view) {
        if (!validate()) {
            return;
        }
        Booking booking = viewModel.getBookingObservable().getValue();
        if (booking == null) {
            booking = new Booking();
            booking.status = StatusBooking.NEW;
        }
        booking.dateDebut = dateDebut.getText().toString();
        booking.dateFin = dateFin.getText().toString();
        booking.townFrom = townFrom.getText().toString();
        booking.townTo = townTo.getText().toString();
        viewModel.setBooking(booking);
        NavHostFragment.findNavController(BookingFragment.this).navigate(R.id.action_BookingFragment_to_bookingCarFragment);
    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            dateDebut.setText(DateUtils.getStringDate(new LocalDate(firstDate)));
            if (secondDate != null) {
                dateFin.setText(DateUtils.getStringDate(new LocalDate(secondDate)));
            }
        }
    }

    public boolean validate() {
        boolean valid = true;

        if (townFrom.getText().toString().isEmpty()) {
            townFrom.setError(getResources().getText(R.string.error_field_required));
            return false;
        }
        if (townTo.getText().toString().isEmpty()) {
            townTo.setError(getResources().getText(R.string.error_field_required));
            return false;
        }


        return valid;
    }
}

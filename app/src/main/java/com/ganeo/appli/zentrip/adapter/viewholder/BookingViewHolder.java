package com.ganeo.appli.zentrip.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.model.Booking;
import com.ganeo.appli.zentrip.model.Driver;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BookingViewHolder extends RecyclerView.ViewHolder {

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


    public BookingViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Booking booking) {

        depart.setText("Départ de " + booking.townFrom + " le " + booking.dateDebut);
        arrive.setText("Départ de " + booking.townTo + " le " + booking.dateFin);

        car.setText(booking.carId);
        driver.setText(booking.driverId);

    }
}

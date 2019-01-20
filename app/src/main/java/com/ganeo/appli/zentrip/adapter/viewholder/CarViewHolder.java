package com.ganeo.appli.zentrip.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.model.Car;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CarViewHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.model)
    TextView mNomView;
    @Bind(R.id.marque)
    TextView mPrenomView;

    @Bind(R.id.quickcontact)
    AppCompatImageView quickContactBadge;

    public CarViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Car car) {

        mNomView.setText(car.model);
        mPrenomView.setText(car.marque);

        int adapterPos = getAdapterPosition();
        ViewCompat.setTransitionName(mNomView, "myTransition" + adapterPos);
    }

}
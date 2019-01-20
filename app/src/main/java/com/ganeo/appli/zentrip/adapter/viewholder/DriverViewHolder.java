package com.ganeo.appli.zentrip.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.model.Driver;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DriverViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.nom)
    TextView mNomView;
    @Bind(R.id.prenom)
    TextView mPrenomView;


    public DriverViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Driver driver) {

        mNomView.setText(driver.getNom());
        mPrenomView.setText(driver.getPrenom());

        int adapterPos = getAdapterPosition();
        ViewCompat.setTransitionName(mNomView, "myTransition" + adapterPos);
    }
}

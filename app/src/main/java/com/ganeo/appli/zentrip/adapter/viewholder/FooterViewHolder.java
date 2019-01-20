package com.ganeo.appli.zentrip.adapter.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ganeo.appli.zentrip.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class FooterViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.loading_fl)
    public FrameLayout loadingFrameLayout;
    @Bind(R.id.error_rl)
    public RelativeLayout errorRelativeLayout;
    @Bind(R.id.loading_iv)
    public ProgressBar loadingImageView;
    @Bind(R.id.reload_btn)
    public Button reloadButton;

    public FooterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
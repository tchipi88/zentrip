package com.ganeo.appli.zentrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganeo.appli.zentrip.dto.User;
import com.ganeo.appli.zentrip.preference.PrefsManager;
import com.ganeo.appli.zentrip.preference.PrefsManager_;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseFragment extends Fragment {

    protected PrefsManager prefsManager;
    protected User user;


    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, view);
        prefsManager = PrefsManager_.getInstance_(getActivity());
        user = prefsManager.getCurrentUser();
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}

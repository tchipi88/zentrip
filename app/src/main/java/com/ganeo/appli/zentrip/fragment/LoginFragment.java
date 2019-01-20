package com.ganeo.appli.zentrip.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ganeo.appli.zentrip.R;
import com.ganeo.appli.zentrip.dto.User;
import com.ganeo.appli.zentrip.model.enumeration.Profil;
import com.ganeo.appli.zentrip.preference.PrefsManager_;

import butterknife.Bind;
import butterknife.OnClick;


public class LoginFragment extends BaseFragment {

    private static final String EXTRA_USERNAME = "extra_username";

    private static final String TAG_TASK_FRAGMENT = "tag_task_fragment";

    private static final String TAG_ERROR_DIALOG = "tag_error_dialog";

    @Bind(R.id.login_pbar_loading)
    public ProgressBar pbarLoading;

    @Bind(R.id.email)
    public EditText acptvUsername;

    @Bind(R.id.password)
    public EditText edtPassword;

    @Bind(R.id.btn_login)
    public Button btnValidate;

    ProgressDialog progressDialog = null;


    @Override
    protected int getLayoutRes() {
        return R.layout.login_fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);


        if (prefsManager.isLogged()) {

            //TODO  SessionUtils.gotoHome(getActivity());
            return rootView;
        }

        edtPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                attemptLogin();
                return true;
            }
            return false;
        });

        progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);

        progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getResources().getText(R.string.loading));


        return rootView;
    }


    @OnClick(R.id.link_forgetpassword)
    public void forgetPassword(View v) {
        //TODO NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_resetPasswordRequestFragment);
    }

    /**
     * Tentative de connexion au compte spécifié par le formulaire de connexion. S'il y a des erreurs de formulaire,
     * les erreurs sont présentées et aucune tentative de connexion réelle n'est effectuée.
     */
    @OnClick(R.id.btn_login)
    public void attemptLogin() {


        // Réinitialise les erreurs
        acptvUsername.setError(null);
        edtPassword.setError(null);

        // Stocke les valeurs au moment de la tentative de connexion
        String username = acptvUsername.getText().toString();
        String password = edtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(password)) {
            edtPassword.setError(getString(R.string.login_txt_password_required));
            focusView = edtPassword;
            cancel = true;
        }

        if (TextUtils.isEmpty(username)) {
            acptvUsername.setError(getString(R.string.login_txt_username_required));
            focusView = acptvUsername;
            cancel = true;
        }

        if (cancel) {
            // Une erreur s'est produite ; on focus le premier champ du formulaire avec une erreur
            focusView.requestFocus();
        } else {
            // On affiche un indicateur de progression et on lance une tâche en arrière-plan pour effectuer la tentative de connexion
            showLoading(true);
            final PrefsManager_ prefs = PrefsManager_.getInstance_(getContext());
            prefs.setLogged(true);
            User user = new User();
            user.setNom("TEST");
            user.setProfil(Profil.ROLE_USER);
            user.setEmail(username);
            prefs.setCurrentUser(user);
           /*
            LogUtils.debug(LoginFragment.class, "Authentification réussie");
            Call tokenRequestCall = userApi.getAccessToken(username, password);

            tokenRequestCall.enqueue(new HtaCallback<AccessToken>() {

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    super.onFailure(call, t);
                    ErrorDialogFragment.newInstance(getString(R.string.txt_error), getString(R.string.login_txt_network_error)).show(getFragmentManager(), TAG_ERROR_DIALOG);
                    LogUtils.error(LoginFragment.class, "Authentification échouée, problème réseau");
                }

                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    try {
                        if (response.isSuccessful()) {
                            final PrefsManager_ prefs = PrefsManager_.getInstance_(getContext());
                            prefs.setToken(response.body());
                            SessionUtils.gotoHome(getActivity());
                            LogUtils.debug(LoginFragment.class, "Authentification réussie");
                        } else {
                            Gson gson = new Gson();
                            TokenError tokenError = gson.fromJson(response.errorBody().string(), TokenError.class);
                            if (tokenError.getErrorDescription().contains("User credentials have expired")) {
                                ExpiredPasswordDialogFragment.newInstance("").show(getFragmentManager(), TAG_ERROR_DIALOG);
                            } else {
                                ErrorDialogFragment.newInstance(getString(R.string.txt_error), tokenError.getErrorDescription()).show(getFragmentManager(), TAG_ERROR_DIALOG);
                            }
                            LogUtils.debug(LoginFragment.class, "Authentification échouée, " + tokenError.getErrorDescription());
                        }
                    } catch (IOException e) {
                        ErrorDialogFragment.newInstance(getString(R.string.txt_error), getString(R.string.login_txt_unknown_error)).show(getFragmentManager(), TAG_ERROR_DIALOG);
                        LogUtils.error(LoginFragment.class, "Authentification échouée. Le format de la réponse n'est pas un JSON attendu.", e);
                    }
                }
            });*/

        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    private void showLoading(boolean visible) {
        //pbarLoading.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        if (visible) progressDialog.show();
        else progressDialog.dismiss();
        acptvUsername.setEnabled(!visible);
        edtPassword.setEnabled(!visible);
        btnValidate.setEnabled(!visible);
        if (visible) {
            acptvUsername.clearFocus();
            edtPassword.clearFocus();
        }
    }


}

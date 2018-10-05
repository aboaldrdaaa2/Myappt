package lip.com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.lk;
import com.google.android.gms.internal.ls;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private final Fragment Mj = this;
    private WalletFragmentOptions akk;
    private WalletFragmentInitParams akl;
    private MaskedWalletRequest akm;
    private MaskedWallet akn;
    private Boolean ako;
    private b akt;
    private final com.google.android.gms.dynamic.b aku = com.google.android.gms.dynamic.b.a(this);
    private final c akv = new c();
    private a akw = new a(this);
    private boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    private static class b implements LifecycleDelegate {
        private final lk akr;

        private b(lk lkVar) {
            this.akr = lkVar;
        }

        private int getState() {
            try {
                return this.akr.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.akr.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.akr.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.akr.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.akr.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.akr.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.akr.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) e.e(this.akr.onCreateView(e.h(inflater), e.h(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.akr.a(e.h(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.akr.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.akr.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.akr.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.akr.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.akr.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class c extends com.google.android.gms.dynamic.a<b> implements OnClickListener {
        private c() {
        }

        protected void a(FrameLayout frameLayout) {
            View button = new Button(WalletFragment.this.Mj.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (WalletFragment.this.akk != null) {
                WalletFragmentStyle fragmentStyle = WalletFragment.this.akk.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = WalletFragment.this.Mj.getResources().getDisplayMetrics();
                    i = fragmentStyle.a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void a(f<b> fVar) {
            Activity activity = WalletFragment.this.Mj.getActivity();
            if (WalletFragment.this.akt == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    WalletFragment.this.akt = new b(ls.a(activity, WalletFragment.this.aku, WalletFragment.this.akk, WalletFragment.this.akw));
                    WalletFragment.this.akk = null;
                    fVar.a(WalletFragment.this.akt);
                    if (WalletFragment.this.akl != null) {
                        WalletFragment.this.akt.initialize(WalletFragment.this.akl);
                        WalletFragment.this.akl = null;
                    }
                    if (WalletFragment.this.akm != null) {
                        WalletFragment.this.akt.updateMaskedWalletRequest(WalletFragment.this.akm);
                        WalletFragment.this.akm = null;
                    }
                    if (WalletFragment.this.akn != null) {
                        WalletFragment.this.akt.updateMaskedWallet(WalletFragment.this.akn);
                        WalletFragment.this.akn = null;
                    }
                    if (WalletFragment.this.ako != null) {
                        WalletFragment.this.akt.setEnabled(WalletFragment.this.ako.booleanValue());
                        WalletFragment.this.ako = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = WalletFragment.this.Mj.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    static class a extends com.google.android.gms.internal.ll.a {
        private OnStateChangedListener akx;
        private final WalletFragment aky;

        a(WalletFragment walletFragment) {
            this.aky = walletFragment;
        }

        public void a(int i, int i2, Bundle bundle) {
            if (this.akx != null) {
                this.akx.onStateChanged(this.aky, i, i2, bundle);
            }
        }

        public void a(OnStateChangedListener onStateChangedListener) {
            this.akx = onStateChangedListener;
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.Mj.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.akt != null ? this.akt.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.akt != null) {
            this.akt.initialize(initParams);
            this.akl = null;
        } else if (this.akl == null) {
            this.akl = initParams;
            if (this.akm != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.akn != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.akt != null) {
            this.akt.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.akl != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.akl = walletFragmentInitParams;
            }
            if (this.akm == null) {
                this.akm = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.akn == null) {
                this.akn = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.akk = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.ako = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.Mj.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Mj.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.Q(this.Mj.getActivity());
                this.akk = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.akv.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.akv.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.akk == null) {
            this.akk = WalletFragmentOptions.a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.akk);
        this.akv.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.akv.onPause();
    }

    public void onResume() {
        super.onResume();
        this.akv.onResume();
        FragmentManager fragmentManager = this.Mj.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mj.getActivity()), this.Mj.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.akv.onSaveInstanceState(outState);
        if (this.akl != null) {
            outState.putParcelable("walletFragmentInitParams", this.akl);
            this.akl = null;
        }
        if (this.akm != null) {
            outState.putParcelable("maskedWalletRequest", this.akm);
            this.akm = null;
        }
        if (this.akn != null) {
            outState.putParcelable("maskedWallet", this.akn);
            this.akn = null;
        }
        if (this.akk != null) {
            outState.putParcelable("walletFragmentOptions", this.akk);
            this.akk = null;
        }
        if (this.ako != null) {
            outState.putBoolean("enabled", this.ako.booleanValue());
            this.ako = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.akv.onStart();
    }

    public void onStop() {
        super.onStop();
        this.akv.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.akt != null) {
            this.akt.setEnabled(enabled);
            this.ako = null;
            return;
        }
        this.ako = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.akw.a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.akt != null) {
            this.akt.updateMaskedWallet(maskedWallet);
            this.akn = null;
            return;
        }
        this.akn = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.akt != null) {
            this.akt.updateMaskedWalletRequest(request);
            this.akm = null;
            return;
        }
        this.akm = request;
    }
}

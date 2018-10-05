package lip.com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class d extends Fragment implements OnCancelListener, ConnectionCallbacks, OnConnectionFailedListener {
    private OnConnectionFailedListener DN;
    private GoogleApiClient Et;
    private ConnectionResult Eu;
    private boolean Ev;

    public void a(GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        this.Et = googleApiClient;
        this.Et.registerConnectionCallbacks(this);
        this.DN = onConnectionFailedListener;
        this.Et.registerConnectionCallbacks(this);
        this.Et.registerConnectionFailedListener(this);
    }

    public boolean isInitialized() {
        return this.Et != null;
    }

    /* JADX WARNING: Missing block: B:6:0x0018, code:
            if (com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Missing block: B:8:0x001c, code:
            if (r5 == -1) goto L_0x0006;
     */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x001b;
            case 2: goto L_0x0010;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001f;
    L_0x0008:
        r0 = r3.Et;
        r0.connect();
        r3.Ev = r1;
    L_0x000f:
        return;
    L_0x0010:
        r2 = r3.getActivity();
        r2 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001e:
        goto L_0x0006;
    L_0x001f:
        r0 = r3.DN;
        r1 = r3.Eu;
        r0.onConnectionFailed(r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.d.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.Ev = false;
        this.DN.onConnectionFailed(this.Eu);
    }

    public void onConnected(Bundle connectionHint) {
        this.Ev = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Eu = result;
        if (!this.Ev) {
            int indexOf = getActivity().getSupportFragmentManager().getFragments().indexOf(this);
            if (result.hasResolution()) {
                try {
                    result.startResolutionForResult(getActivity(), ((indexOf + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    this.Et.connect();
                }
            } else if (GooglePlayServicesUtil.isUserRecoverableError(result.getErrorCode())) {
                GooglePlayServicesUtil.b(result.getErrorCode(), getActivity(), this, 2, this);
            } else {
                this.DN.onConnectionFailed(this.Eu);
            }
        }
    }

    public void onConnectionSuspended(int cause) {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.Ev = savedInstanceState.getBoolean("resolving_error", false);
            int i = savedInstanceState.getInt("connection_result_status");
            if (i != 0) {
                this.Eu = new ConnectionResult(i, (PendingIntent) savedInstanceState.getParcelable("resolution_pending_intent"));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.Ev);
        if (this.Eu != null) {
            outState.putInt("connection_result_status", this.Eu.getErrorCode());
            outState.putParcelable("resolution_pending_intent", this.Eu.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.Ev && this.Et != null) {
            this.Et.connect();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.Et != null) {
            this.Et.disconnect();
        }
    }
}

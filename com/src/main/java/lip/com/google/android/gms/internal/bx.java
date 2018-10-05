package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bu.a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class bx extends a {
    private final MediationAdapter nS;

    public bx(MediationAdapter mediationAdapter) {
        this.nS = mediationAdapter;
    }

    private Bundle a(String str, int i, String str2) throws RemoteException {
        eu.D("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.nS instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            eu.c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void a(d dVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        a(dVar, aiVar, str, null, bvVar);
    }

    public void a(d dVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        Bundle bundle = null;
        if (this.nS instanceof MediationInterstitialAdapter) {
            eu.z("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.nS;
                bw bwVar = new bw(new Date(aiVar.lS), aiVar.lT, aiVar.lU != null ? new HashSet(aiVar.lU) : null, aiVar.lV, aiVar.lW);
                if (aiVar.mc != null) {
                    bundle = aiVar.mc.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) e.e(dVar), new by(bvVar), a(str, aiVar.lW, str2), bwVar, bundle);
            } catch (Throwable th) {
                eu.c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void a(d dVar, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        a(dVar, alVar, aiVar, str, null, bvVar);
    }

    public void a(d dVar, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        Bundle bundle = null;
        if (this.nS instanceof MediationBannerAdapter) {
            eu.z("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.nS;
                bw bwVar = new bw(new Date(aiVar.lS), aiVar.lT, aiVar.lU != null ? new HashSet(aiVar.lU) : null, aiVar.lV, aiVar.lW);
                if (aiVar.mc != null) {
                    bundle = aiVar.mc.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) e.e(dVar), new by(bvVar), a(str, aiVar.lW, str2), com.google.android.gms.ads.a.a(alVar.width, alVar.height, alVar.me), bwVar, bundle);
            } catch (Throwable th) {
                eu.c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nS.onDestroy();
        } catch (Throwable th) {
            eu.c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public d getView() throws RemoteException {
        if (this.nS instanceof MediationBannerAdapter) {
            try {
                return e.h(((MediationBannerAdapter) this.nS).getBannerView());
            } catch (Throwable th) {
                eu.c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.nS.onPause();
        } catch (Throwable th) {
            eu.c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.nS.onResume();
        } catch (Throwable th) {
            eu.c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.nS instanceof MediationInterstitialAdapter) {
            eu.z("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nS).showInterstitial();
            } catch (Throwable th) {
                eu.c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}

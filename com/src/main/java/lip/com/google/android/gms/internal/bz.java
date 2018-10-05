package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bu.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nU;
    private final NETWORK_EXTRAS nV;

    public bz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.nU = mediationAdapter;
        this.nV = network_extras;
    }

    private SERVER_PARAMETERS b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                eu.c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.nU.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void a(d dVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        a(dVar, aiVar, str, null, bvVar);
    }

    public void a(d dVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.z("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).requestInterstitialAd(new ca(bvVar), (Activity) e.e(dVar), b(str, aiVar.lW, str2), cb.e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void a(d dVar, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        a(dVar, alVar, aiVar, str, null, bvVar);
    }

    public void a(d dVar, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            eu.z("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.nU).requestBannerAd(new ca(bvVar), (Activity) e.e(dVar), b(str, aiVar.lW, str2), cb.b(alVar), cb.e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nU.destroy();
        } catch (Throwable th) {
            eu.c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public d getView() throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            try {
                return e.h(((MediationBannerAdapter) this.nU).getBannerView());
            } catch (Throwable th) {
                eu.c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.z("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).showInterstitial();
            } catch (Throwable th) {
                eu.c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}

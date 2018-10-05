package lip.com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap ZD;
    private final b ZG;

    static class a implements LifecycleDelegate {
        private final ViewGroup ZH;
        private final IMapViewDelegate ZI;
        private View ZJ;

        public a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.ZI = (IMapViewDelegate) hm.f(iMapViewDelegate);
            this.ZH = (ViewGroup) hm.f(viewGroup);
        }

        public IMapViewDelegate jA() {
            return this.ZI;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.ZI.onCreate(savedInstanceState);
                this.ZJ = (View) e.e(this.ZI.getView());
                this.ZH.removeAllViews();
                this.ZH.addView(this.ZJ);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ZI.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.ZI.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ZI.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ZI.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ZI.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {
        protected f<a> ZF;
        private final ViewGroup ZK;
        private final GoogleMapOptions ZL;
        private final Context mContext;

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.ZK = viewGroup;
            this.mContext = context;
            this.ZL = googleMapOptions;
        }

        protected void a(f<a> fVar) {
            this.ZF = fVar;
            jz();
        }

        public void jz() {
            if (this.ZF != null && gH() == null) {
                try {
                    this.ZF.a(new a(this.ZK, u.H(this.mContext).a(e.h(this.mContext), this.ZL)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.ZG = new b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ZG = new b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.ZG = new b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.ZG = new b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.ZD != null) {
            return this.ZD;
        }
        this.ZG.jz();
        if (this.ZG.gH() == null) {
            return null;
        }
        try {
            this.ZD = new GoogleMap(((a) this.ZG.gH()).jA().getMap());
            return this.ZD;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.ZG.onCreate(savedInstanceState);
        if (this.ZG.gH() == null) {
            b bVar = this.ZG;
            com.google.android.gms.dynamic.a.b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.ZG.onDestroy();
    }

    public final void onLowMemory() {
        this.ZG.onLowMemory();
    }

    public final void onPause() {
        this.ZG.onPause();
    }

    public final void onResume() {
        this.ZG.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.ZG.onSaveInstanceState(outState);
    }
}

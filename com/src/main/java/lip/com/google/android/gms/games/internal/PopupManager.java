package lip.com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.ip;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl OY;
    protected PopupLocationInfo OZ;

    public static final class PopupLocationInfo {
        public IBinder Pa;
        public int Pb;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.Pb = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.Pa = windowToken;
        }

        public Bundle hO() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.Pb);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean Nv = false;
        private WeakReference<View> Pc;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        private void h(View view) {
            int i = -1;
            if (ip.gh()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.OZ.Pb = i;
            this.OZ.Pa = windowToken;
            this.OZ.left = iArr[0];
            this.OZ.top = iArr[1];
            this.OZ.right = iArr[0] + width;
            this.OZ.bottom = iArr[1] + height;
            if (this.Nv) {
                hL();
                this.Nv = false;
            }
        }

        protected void cl(int i) {
            this.OZ = new PopupLocationInfo(i, null);
        }

        public void g(View view) {
            View view2;
            Context context;
            this.OY.hw();
            if (this.Pc != null) {
                view2 = (View) this.Pc.get();
                context = this.OY.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (ip.gg()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.Pc = null;
            context = this.OY.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.j("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = view2;
            }
            if (view != null) {
                h(view);
                this.Pc = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.k("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void hL() {
            if (this.OZ.Pa != null) {
                super.hL();
            } else {
                this.Nv = this.Pc != null;
            }
        }

        public void onGlobalLayout() {
            if (this.Pc != null) {
                View view = (View) this.Pc.get();
                if (view != null) {
                    h(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            h(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.OY.hw();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.OY = gamesClientImpl;
        cl(gravity);
    }

    public static PopupManager a(GamesClientImpl gamesClientImpl, int i) {
        return ip.gd() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    protected void cl(int i) {
        this.OZ = new PopupLocationInfo(i, new Binder());
    }

    public void g(View view) {
    }

    public void hL() {
        this.OY.a(this.OZ.Pa, this.OZ.hO());
    }

    public Bundle hM() {
        return this.OZ.hO();
    }

    public IBinder hN() {
        return this.OZ.Pa;
    }

    public void setGravity(int gravity) {
        this.OZ.gravity = gravity;
    }
}

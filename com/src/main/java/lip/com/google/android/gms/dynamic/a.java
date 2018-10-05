package lip.com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a<T extends LifecycleDelegate> {
    private T LX;
    private Bundle LY;
    private LinkedList<a> LZ;
    private final f<T> Ma = new f<T>() {
        public void a(T t) {
            a.this.LX = t;
            Iterator it = a.this.LZ.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b(a.this.LX);
            }
            a.this.LZ.clear();
            a.this.LY = null;
        }
    };

    private interface a {
        void b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    private void a(Bundle bundle, a aVar) {
        if (this.LX != null) {
            aVar.b(this.LX);
            return;
        }
        if (this.LZ == null) {
            this.LZ = new LinkedList();
        }
        this.LZ.add(aVar);
        if (bundle != null) {
            if (this.LY == null) {
                this.LY = (Bundle) bundle.clone();
            } else {
                this.LY.putAll(bundle);
            }
        }
        a(this.Ma);
    }

    public static void b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence d = GooglePlayServicesUtil.d(context, isGooglePlayServicesAvailable);
        CharSequence e = GooglePlayServicesUtil.e(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(d);
        linearLayout.addView(textView);
        if (e != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.c(context, isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void ca(int i) {
        while (!this.LZ.isEmpty() && ((a) this.LZ.getLast()).getState() >= i) {
            this.LZ.removeLast();
        }
    }

    protected void a(FrameLayout frameLayout) {
        b(frameLayout);
    }

    protected abstract void a(f<T> fVar);

    public T gH() {
        return this.LX;
    }

    public void onCreate(final Bundle savedInstanceState) {
        a(savedInstanceState, new a() {
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.LX.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        a(savedInstanceState, new a() {
            public void b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(a.this.LX.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.LX == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.LX != null) {
            this.LX.onDestroy();
        } else {
            ca(1);
        }
    }

    public void onDestroyView() {
        if (this.LX != null) {
            this.LX.onDestroyView();
        } else {
            ca(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        a(savedInstanceState, new a() {
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.LX.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.LX != null) {
            this.LX.onLowMemory();
        }
    }

    public void onPause() {
        if (this.LX != null) {
            this.LX.onPause();
        } else {
            ca(5);
        }
    }

    public void onResume() {
        a(null, new a() {
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.LX.onResume();
            }

            public int getState() {
                return 5;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.LX != null) {
            this.LX.onSaveInstanceState(outState);
        } else if (this.LY != null) {
            outState.putAll(this.LY);
        }
    }

    public void onStart() {
        a(null, new a() {
            public void b(LifecycleDelegate lifecycleDelegate) {
                a.this.LX.onStart();
            }

            public int getState() {
                return 4;
            }
        });
    }

    public void onStop() {
        if (this.LX != null) {
            this.LX.onStop();
        } else {
            ca(4);
        }
    }
}

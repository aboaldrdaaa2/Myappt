package lip.com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.eu;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private cn kr;

    private void S() {
        if (this.kr != null) {
            try {
                this.kr.S();
            } catch (Throwable e) {
                eu.c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.kr = cm.a(this);
        if (this.kr == null) {
            eu.D("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.kr.onCreate(savedInstanceState);
        } catch (Throwable e) {
            eu.c("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.kr != null) {
                this.kr.onDestroy();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.kr != null) {
                this.kr.onPause();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.kr != null) {
                this.kr.onRestart();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.kr != null) {
                this.kr.onResume();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            if (this.kr != null) {
                this.kr.onSaveInstanceState(outState);
            }
        } catch (Throwable e) {
            eu.c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.kr != null) {
                this.kr.onStart();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.kr != null) {
                this.kr.onStop();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        S();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        S();
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        S();
    }
}

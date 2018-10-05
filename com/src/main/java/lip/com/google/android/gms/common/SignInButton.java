package lip.com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.g.a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.ho;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int Dj;
    private View Dk;
    private OnClickListener Dl;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.Dl = null;
        setStyle(0, 0);
    }

    private void C(Context context) {
        if (this.Dk != null) {
            removeView(this.Dk);
        }
        try {
            this.Dk = hn.b(context, this.mSize, this.Dj);
        } catch (a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.Dk = a(context, this.mSize, this.Dj);
        }
        addView(this.Dk);
        this.Dk.setEnabled(isEnabled());
        this.Dk.setOnClickListener(this);
    }

    private static Button a(Context context, int i, int i2) {
        Button hoVar = new ho(context);
        hoVar.a(context.getResources(), i, i2);
        return hoVar;
    }

    public void onClick(View view) {
        if (this.Dl != null && view == this.Dk) {
            this.Dl.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.Dk.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.Dl = listener;
        if (this.Dk != null) {
            this.Dk.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.Dj);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = buttonSize >= 0 && buttonSize < 3;
        hm.a(z, "Unknown button size %d", Integer.valueOf(buttonSize));
        z = colorScheme >= 0 && colorScheme < 2;
        hm.a(z, "Unknown color scheme %s", Integer.valueOf(colorScheme));
        this.mSize = buttonSize;
        this.Dj = colorScheme;
        C(getContext());
    }
}

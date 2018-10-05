package lip.com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hp;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private View abB;
    private int abC;
    private int abD;
    private OnPlusOneClickListener abE;
    private int mSize;
    private String qY;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener abF;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.abF = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.abB.getTag();
            if (this.abF != null) {
                this.abF.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.abD);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.abC = getAnnotation(context, attrs);
        this.abD = -1;
        C(getContext());
        if (isInEditMode()) {
        }
    }

    private void C(Context context) {
        if (this.abB != null) {
            removeView(this.abB);
        }
        this.abB = g.a(context, this.mSize, this.abC, this.qY, this.abD);
        setOnPlusOneClickListener(this.abE);
        addView(this.abB);
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = hp.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = hp.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    public void initialize(String url, int activityRequestCode) {
        hm.a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.qY = url;
        this.abD = activityRequestCode;
        C(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.qY = url;
        this.abD = 0;
        C(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.abB.layout(0, 0, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.abB;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.abC = annotation;
        C(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.abE = listener;
        this.abB.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        C(getContext());
    }
}

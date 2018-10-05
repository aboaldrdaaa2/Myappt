package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class ck extends FrameLayout implements OnClickListener {
    private final ImageButton oR;
    private final Activity og;

    public ck(Activity activity, int i) {
        super(activity);
        this.og = activity;
        setOnClickListener(this);
        this.oR = new ImageButton(activity);
        this.oR.setImageResource(17301527);
        this.oR.setBackgroundColor(0);
        this.oR.setOnClickListener(this);
        this.oR.setPadding(0, 0, 0, 0);
        int a = et.a((Context) activity, i);
        addView(this.oR, new LayoutParams(a, a, 17));
    }

    public void j(boolean z) {
        this.oR.setVisibility(z ? 4 : 0);
    }

    public void onClick(View view) {
        this.og.finish();
    }
}

package lip.com.google.ads.interactivemedia.v3.b.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
public final class a extends LinearLayout {
    private d a;
    private TextView b;
    private TextView c;
    private List<a> d = new ArrayList();

    /* compiled from: IMASDK */
    public interface a {
        void b();
    }

    public a(Context context, d dVar) {
        super(context);
        this.a = dVar;
        this.b = new TextView(context);
        this.b.setTextColor(dVar.h);
        this.b.setIncludeFontPadding(false);
        this.b.setGravity(16);
        this.b.setEllipsize(TruncateAt.END);
        this.b.setSingleLine();
        int a = c.a(dVar.k, getResources().getDisplayMetrics().density);
        this.b.setPadding(a, a, a, a);
        addView(this.b, new LayoutParams(-2, -2, 1.0f));
        if (dVar.l) {
            this.c = new TextView(context);
            this.c.setTextColor(dVar.o);
            this.c.setTextSize(dVar.p);
            this.c.setText(dVar.n);
            this.c.setIncludeFontPadding(false);
            this.c.setPadding(10, 10, 10, 10);
            this.c.setGravity(16);
            this.c.setEllipsize(TruncateAt.END);
            this.c.setSingleLine();
            Drawable shapeDrawable = new ShapeDrawable(new Shape() {
                public final void draw(Canvas canvas, Paint paint) {
                    canvas.drawLine(0.0f, 0.0f, 0.0f, getHeight(), paint);
                }
            });
            shapeDrawable.getPaint().setColor(dVar.e);
            shapeDrawable.getPaint().setStrokeWidth((float) dVar.f);
            shapeDrawable.getPaint().setStyle(Style.STROKE);
            this.c.setBackgroundDrawable(shapeDrawable);
            this.c.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.a();
                }
            });
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            this.c.setLayoutParams(layoutParams);
            addView(this.c, layoutParams);
        }
    }

    public final void a(String str) {
        this.b.setText(str);
    }

    public final void b(String str) {
        this.c.setText(str);
    }

    public final void a(a aVar) {
        this.d.add(aVar);
    }

    protected final void a() {
        for (a b : this.d) {
            b.b();
        }
    }

    protected final void onSizeChanged(int w, int h, int i, int i2) {
        new GradientDrawable(Orientation.TOP_BOTTOM, this.a.b).setBounds(0, 0, w, h);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() {
            public final void draw(Canvas canvas, Paint paint) {
                canvas.drawLine(0.0f, getHeight(), getWidth(), getHeight(), paint);
            }
        });
        shapeDrawable.getPaint().setColor(this.a.c);
        shapeDrawable.getPaint().setStrokeWidth((float) this.a.d);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.setBounds(0, 0, w, h);
        setBackgroundDrawable(new LayerDrawable(new Drawable[]{r0, shapeDrawable}));
    }
}

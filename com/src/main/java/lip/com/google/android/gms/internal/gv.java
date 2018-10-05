package lip.com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class gv extends ImageView {
    private Uri FO;
    private int FP;
    private int FQ;
    private a FR;

    public interface a {
        Path d(int i, int i2);
    }

    public void al(int i) {
        this.FP = i;
    }

    public int fi() {
        return this.FP;
    }

    public void g(Uri uri) {
        this.FO = uri;
    }

    protected void onDraw(Canvas canvas) {
        if (this.FR != null) {
            canvas.clipPath(this.FR.d(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.FQ != 0) {
            canvas.drawColor(this.FQ);
        }
    }
}

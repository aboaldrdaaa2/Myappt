package lip.com.google.ads.interactivemedia.v3.b;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;

/* compiled from: IMASDK */
public final class k implements CompanionAdSlot {
    private int a;
    private int b;
    private ViewGroup c;

    public final int getWidth() {
        return this.a;
    }

    public final int getHeight() {
        return this.b;
    }

    public final void setSize(int width, int height) {
        this.a = width;
        this.b = height;
    }

    public final ViewGroup getContainer() {
        return this.c;
    }

    public final void setContainer(ViewGroup container) {
        this.c = container;
    }
}

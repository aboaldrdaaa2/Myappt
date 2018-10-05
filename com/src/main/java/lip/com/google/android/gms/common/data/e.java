package lip.com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] EE = new String[]{"data"};
    private final Creator<T> EF;

    public e(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.EF = creator;
    }

    /* renamed from: ad */
    public T get(int i) {
        byte[] f = this.DG.f("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.EF.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}

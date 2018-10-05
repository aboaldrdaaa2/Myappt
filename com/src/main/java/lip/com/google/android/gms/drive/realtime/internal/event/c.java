package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<ParcelableObjectChangedEvent> {
    static void a(ParcelableObjectChangedEvent parcelableObjectChangedEvent, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, parcelableObjectChangedEvent.xM);
        b.a(parcel, 2, parcelableObjectChangedEvent.rR, false);
        b.a(parcel, 3, parcelableObjectChangedEvent.Lm, false);
        b.a(parcel, 4, parcelableObjectChangedEvent.Ls);
        b.a(parcel, 5, parcelableObjectChangedEvent.Lq, false);
        b.a(parcel, 6, parcelableObjectChangedEvent.Lt, false);
        b.c(parcel, 7, parcelableObjectChangedEvent.LF);
        b.c(parcel, 8, parcelableObjectChangedEvent.LG);
        b.G(parcel, C);
    }

    /* renamed from: aV */
    public ParcelableObjectChangedEvent createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    str4 = a.o(parcel, A);
                    break;
                case 3:
                    str3 = a.o(parcel, A);
                    break;
                case 4:
                    z = a.c(parcel, A);
                    break;
                case 5:
                    str2 = a.o(parcel, A);
                    break;
                case 6:
                    str = a.o(parcel, A);
                    break;
                case 7:
                    i2 = a.g(parcel, A);
                    break;
                case 8:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableObjectChangedEvent(i3, str4, str3, z, str2, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bS */
    public ParcelableObjectChangedEvent[] newArray(int i) {
        return new ParcelableObjectChangedEvent[i];
    }
}

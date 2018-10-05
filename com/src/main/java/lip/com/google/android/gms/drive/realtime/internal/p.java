package lip.com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p implements Creator<ParcelableCollaborator> {
    static void a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, parcelableCollaborator.xM);
        b.a(parcel, 2, parcelableCollaborator.Lk);
        b.a(parcel, 3, parcelableCollaborator.Ll);
        b.a(parcel, 4, parcelableCollaborator.rR, false);
        b.a(parcel, 5, parcelableCollaborator.Lm, false);
        b.a(parcel, 6, parcelableCollaborator.Ln, false);
        b.a(parcel, 7, parcelableCollaborator.Lo, false);
        b.a(parcel, 8, parcelableCollaborator.Lp, false);
        b.G(parcel, C);
    }

    /* renamed from: aR */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = a.B(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    z2 = a.c(parcel, A);
                    break;
                case 3:
                    z = a.c(parcel, A);
                    break;
                case 4:
                    str5 = a.o(parcel, A);
                    break;
                case 5:
                    str4 = a.o(parcel, A);
                    break;
                case 6:
                    str3 = a.o(parcel, A);
                    break;
                case 7:
                    str2 = a.o(parcel, A);
                    break;
                case 8:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bO */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}

package lip.com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<m> {
    static void a(m mVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, mVar.xM);
        b.a(parcel, 2, mVar.getUri(), i, false);
        b.a(parcel, 4, mVar.nm(), false);
        b.a(parcel, 5, mVar.getData(), false);
        b.G(parcel, C);
    }

    /* renamed from: cx */
    public m createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int B = a.B(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < B) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int A = a.A(parcel);
            byte[] bArr3;
            switch (a.ar(A)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = a.g(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 2:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = a.q(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = a.r(parcel, A);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == B) {
            return new m(i, uri, bundle, bArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: eg */
    public m[] newArray(int i) {
        return new m[i];
    }
}

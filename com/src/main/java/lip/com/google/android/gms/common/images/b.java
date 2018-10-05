package lip.com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<WebImage> {
    static void a(WebImage webImage, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, webImage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, webImage.getUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, webImage.getWidth());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, webImage.getHeight());
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: ak */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }

    /* renamed from: y */
    public WebImage createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            Uri uri2;
            int g;
            int A = a.A(parcel);
            int i4;
            switch (a.ar(A)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = a.g(parcel, A);
                    A = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    A = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = a.g(parcel, A);
                    A = i4;
                    break;
                case 4:
                    A = a.g(parcel, A);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    a.b(parcel, A);
                    A = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}

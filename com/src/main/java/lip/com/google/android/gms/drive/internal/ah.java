package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ah implements Creator<OnDownloadProgressResponse> {
    static void a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, onDownloadProgressResponse.xM);
        b.a(parcel, 2, onDownloadProgressResponse.Jw);
        b.a(parcel, 3, onDownloadProgressResponse.Jx);
        b.G(parcel, C);
    }

    /* renamed from: ai */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        long j = 0;
        int B = a.B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    j2 = a.i(parcel, A);
                    break;
                case 3:
                    j = a.i(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: be */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}

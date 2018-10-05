package lip.com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChange> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(SnapshotMetadataChange snapshotMetadataChange, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, snapshotMetadataChange.getDescription(), false);
        b.c(parcel, 1000, snapshotMetadataChange.getVersionCode());
        b.a(parcel, 2, snapshotMetadataChange.getPlayedTimeMillis(), false);
        b.a(parcel, 4, snapshotMetadataChange.getCoverImageUri(), i, false);
        b.a(parcel, 5, snapshotMetadataChange.iN(), i, false);
        b.G(parcel, C);
    }

    public SnapshotMetadataChange createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = a.B(parcel);
        int i = 0;
        com.google.android.gms.common.data.a aVar = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str = a.o(parcel, A);
                    break;
                case 2:
                    l = a.j(parcel, A);
                    break;
                case 4:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    aVar = (com.google.android.gms.common.data.a) a.a(parcel, A, com.google.android.gms.common.data.a.CREATOR);
                    break;
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotMetadataChange(i, str, l, aVar, uri);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataChange[] newArray(int size) {
        return new SnapshotMetadataChange[size];
    }
}

package lip.com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, mostRecentGameInfoEntity.ip(), false);
        b.c(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        b.a(parcel, 2, mostRecentGameInfoEntity.iq(), false);
        b.a(parcel, 3, mostRecentGameInfoEntity.ir());
        b.a(parcel, 4, mostRecentGameInfoEntity.is(), i, false);
        b.a(parcel, 5, mostRecentGameInfoEntity.it(), i, false);
        b.a(parcel, 6, mostRecentGameInfoEntity.iu(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: bj */
    public MostRecentGameInfoEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = a.B(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str2 = a.o(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    j = a.i(parcel, A);
                    break;
                case 4:
                    uri3 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cu */
    public MostRecentGameInfoEntity[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}

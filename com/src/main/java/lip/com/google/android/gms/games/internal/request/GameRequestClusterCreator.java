package lip.com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.b(parcel, 1, gameRequestCluster.iw(), false);
        b.c(parcel, 1000, gameRequestCluster.getVersionCode());
        b.G(parcel, C);
    }

    /* renamed from: bk */
    public GameRequestCluster createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    arrayList = a.c(parcel, A, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cv */
    public GameRequestCluster[] newArray(int i) {
        return new GameRequestCluster[i];
    }
}

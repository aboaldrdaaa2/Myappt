package lip.com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        b.c(parcel, 1000, playerLevelInfo.getVersionCode());
        b.a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        b.a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        b.a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        b.G(parcel, C);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int B = a.B(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    j2 = a.i(parcel, A);
                    break;
                case 2:
                    j = a.i(parcel, A);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) a.a(parcel, A, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) a.a(parcel, A, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}

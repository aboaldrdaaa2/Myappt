package lip.com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, playerEntity.getPlayerId(), false);
        b.a(parcel, 2, playerEntity.getDisplayName(), false);
        b.a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        b.a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        b.a(parcel, 5, playerEntity.getRetrievedTimestamp());
        b.c(parcel, 6, playerEntity.gS());
        b.a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        b.a(parcel, 8, playerEntity.getIconImageUrl(), false);
        b.a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        b.a(parcel, 14, playerEntity.getTitle(), false);
        b.a(parcel, 15, playerEntity.gU(), i, false);
        b.a(parcel, 17, playerEntity.gT());
        b.a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        b.c(parcel, 1000, playerEntity.getVersionCode());
        b.G(parcel, C);
    }

    /* renamed from: be */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str = a.o(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    j = a.i(parcel, A);
                    break;
                case 6:
                    i2 = a.g(parcel, A);
                    break;
                case 7:
                    j2 = a.i(parcel, A);
                    break;
                case 8:
                    str3 = a.o(parcel, A);
                    break;
                case 9:
                    str4 = a.o(parcel, A);
                    break;
                case 14:
                    str5 = a.o(parcel, A);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) a.a(parcel, A, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) a.a(parcel, A, (Creator) PlayerLevelInfo.CREATOR);
                    break;
                case 17:
                    z = a.c(parcel, A);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cc */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }
}

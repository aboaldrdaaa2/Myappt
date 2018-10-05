package lip.com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.millennialmedia.android.MMException;

public class GameEntityCreator implements Creator<GameEntity> {
    static void a(GameEntity gameEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, gameEntity.getApplicationId(), false);
        b.a(parcel, 2, gameEntity.getDisplayName(), false);
        b.a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        b.a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        b.a(parcel, 5, gameEntity.getDescription(), false);
        b.a(parcel, 6, gameEntity.getDeveloperName(), false);
        b.a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        b.a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        b.a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        b.a(parcel, 10, gameEntity.gM());
        b.a(parcel, 11, gameEntity.gO());
        b.a(parcel, 12, gameEntity.gP(), false);
        b.c(parcel, 13, gameEntity.gQ());
        b.c(parcel, 14, gameEntity.getAchievementTotalCount());
        b.c(parcel, 15, gameEntity.getLeaderboardCount());
        b.a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        b.a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        b.c(parcel, 1000, gameEntity.getVersionCode());
        b.a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        b.a(parcel, 18, gameEntity.getIconImageUrl(), false);
        b.a(parcel, 21, gameEntity.isMuted());
        b.a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        b.a(parcel, 23, gameEntity.areSnapshotsEnabled());
        b.a(parcel, 22, gameEntity.gN());
        b.G(parcel, C);
    }

    /* renamed from: bd */
    public GameEntity createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
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
                    str3 = a.o(parcel, A);
                    break;
                case 4:
                    str4 = a.o(parcel, A);
                    break;
                case 5:
                    str5 = a.o(parcel, A);
                    break;
                case 6:
                    str6 = a.o(parcel, A);
                    break;
                case 7:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 10:
                    z = a.c(parcel, A);
                    break;
                case 11:
                    z2 = a.c(parcel, A);
                    break;
                case 12:
                    str7 = a.o(parcel, A);
                    break;
                case 13:
                    i2 = a.g(parcel, A);
                    break;
                case 14:
                    i3 = a.g(parcel, A);
                    break;
                case 15:
                    i4 = a.g(parcel, A);
                    break;
                case 16:
                    z3 = a.c(parcel, A);
                    break;
                case 17:
                    z4 = a.c(parcel, A);
                    break;
                case 18:
                    str8 = a.o(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = a.o(parcel, A);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str10 = a.o(parcel, A);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    z5 = a.c(parcel, A);
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    z6 = a.c(parcel, A);
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    z7 = a.c(parcel, A);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cb */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }
}

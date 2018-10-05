package lip.com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    static void a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, extendedGameEntity.getGame(), i, false);
        b.c(parcel, 1000, extendedGameEntity.getVersionCode());
        b.c(parcel, 2, extendedGameEntity.hR());
        b.a(parcel, 3, extendedGameEntity.hS());
        b.c(parcel, 4, extendedGameEntity.hT());
        b.a(parcel, 5, extendedGameEntity.hU());
        b.a(parcel, 6, extendedGameEntity.hV());
        b.a(parcel, 7, extendedGameEntity.hW(), false);
        b.a(parcel, 8, extendedGameEntity.hX());
        b.a(parcel, 9, extendedGameEntity.hY(), false);
        b.b(parcel, 10, extendedGameEntity.hQ(), false);
        b.a(parcel, 11, extendedGameEntity.hZ(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: bg */
    public ExtendedGameEntity createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    gameEntity = (GameEntity) a.a(parcel, A, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = a.g(parcel, A);
                    break;
                case 3:
                    z = a.c(parcel, A);
                    break;
                case 4:
                    i3 = a.g(parcel, A);
                    break;
                case 5:
                    j = a.i(parcel, A);
                    break;
                case 6:
                    j2 = a.i(parcel, A);
                    break;
                case 7:
                    str = a.o(parcel, A);
                    break;
                case 8:
                    j3 = a.i(parcel, A);
                    break;
                case 9:
                    str2 = a.o(parcel, A);
                    break;
                case 10:
                    arrayList = a.c(parcel, A, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) a.a(parcel, A, (Creator) SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: co */
    public ExtendedGameEntity[] newArray(int i) {
        return new ExtendedGameEntity[i];
    }
}

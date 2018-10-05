package lip.com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(EventEntity eventEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, eventEntity.getEventId(), false);
        b.c(parcel, 1000, eventEntity.getVersionCode());
        b.a(parcel, 2, eventEntity.getName(), false);
        b.a(parcel, 3, eventEntity.getDescription(), false);
        b.a(parcel, 4, eventEntity.getIconImageUri(), i, false);
        b.a(parcel, 5, eventEntity.getIconImageUrl(), false);
        b.a(parcel, 6, eventEntity.getPlayer(), i, false);
        b.a(parcel, 7, eventEntity.getValue());
        b.a(parcel, 8, eventEntity.getFormattedValue(), false);
        b.a(parcel, 9, eventEntity.isVisible());
        b.G(parcel, C);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = a.B(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str5 = a.o(parcel, A);
                    break;
                case 2:
                    str4 = a.o(parcel, A);
                    break;
                case 3:
                    str3 = a.o(parcel, A);
                    break;
                case 4:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    str2 = a.o(parcel, A);
                    break;
                case 6:
                    player = (PlayerEntity) a.a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = a.i(parcel, A);
                    break;
                case 8:
                    str = a.o(parcel, A);
                    break;
                case 9:
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}

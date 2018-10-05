package lip.com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a implements Creator<AddEventListenerRequest> {
    static void a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, addEventListenerRequest.xM);
        b.a(parcel, 2, addEventListenerRequest.Hz, i, false);
        b.c(parcel, 3, addEventListenerRequest.Iq);
        b.a(parcel, 4, addEventListenerRequest.Ir, i, false);
        b.G(parcel, C);
    }

    /* renamed from: R */
    public AddEventListenerRequest createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int i3;
            DriveId driveId2;
            int g;
            PendingIntent pendingIntent2;
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            PendingIntent pendingIntent3;
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    pendingIntent3 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    g = i2;
                    int i4 = i;
                    driveId2 = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, DriveId.CREATOR);
                    pendingIntent2 = pendingIntent;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i2;
                    pendingIntent3 = pendingIntent;
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 4:
                    pendingIntent2 = (PendingIntent) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, PendingIntent.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = i3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == B) {
            return new AddEventListenerRequest(i2, driveId, i, pendingIntent);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aM */
    public AddEventListenerRequest[] newArray(int i) {
        return new AddEventListenerRequest[i];
    }
}

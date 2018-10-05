package lip.com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new p();
    final boolean Lk;
    final boolean Ll;
    final String Lm;
    final String Ln;
    final String Lo;
    final String Lp;
    final String rR;
    final int xM;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.xM = versionCode;
        this.Lk = isMe;
        this.Ll = isAnonymous;
        this.rR = sessionId;
        this.Lm = userId;
        this.Ln = displayName;
        this.Lo = color;
        this.Lp = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.rR.equals(((ParcelableCollaborator) obj).rR);
    }

    public int hashCode() {
        return this.rR.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.Lk + ", isAnonymous=" + this.Ll + ", sessionId=" + this.rR + ", userId=" + this.Lm + ", displayName=" + this.Ln + ", color=" + this.Lo + ", photoUrl=" + this.Lp + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        p.a(this, dest, flags);
    }
}

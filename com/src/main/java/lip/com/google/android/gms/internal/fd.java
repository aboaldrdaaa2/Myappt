package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class fd implements Parcelable {
    @Deprecated
    public static final Creator<fd> CREATOR = new Creator<fd>() {
        @Deprecated
        /* renamed from: C */
        public fd[] newArray(int i) {
            return new fd[i];
        }

        @Deprecated
        /* renamed from: k */
        public fd createFromParcel(Parcel parcel) {
            return new fd(parcel);
        }
    };
    private String mValue;
    private String xG;
    private String xH;

    @Deprecated
    fd(Parcel parcel) {
        readFromParcel(parcel);
    }

    public fd(String str, String str2, String str3) {
        this.xG = str;
        this.xH = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.xG = in.readString();
        this.xH = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.xG;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.xG);
        out.writeString(this.xH);
        out.writeString(this.mValue);
    }
}

package lip.com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef extends d implements MostRecentGameInfo {
    private final PlayerColumnNames Ng;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.Ng = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.a(this, obj);
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.a(this);
    }

    public String ip() {
        return getString(this.Ng.Sg);
    }

    public String iq() {
        return getString(this.Ng.Sh);
    }

    public long ir() {
        return getLong(this.Ng.Si);
    }

    public Uri is() {
        return aw(this.Ng.Sj);
    }

    public Uri it() {
        return aw(this.Ng.Sk);
    }

    public Uri iu() {
        return aw(this.Ng.Sl);
    }

    /* renamed from: iv */
    public MostRecentGameInfo freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) freeze()).writeToParcel(dest, flags);
    }
}

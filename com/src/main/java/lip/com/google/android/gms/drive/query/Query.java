package lip.com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new a();
    final LogicalFilter KE;
    final String KF;
    final SortOrder KG;
    final int xM;

    public static class Builder {
        private String KF;
        private SortOrder KG;
        private final List<Filter> KH = new ArrayList();

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.KH.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.Lf, this.KH), this.KF, this.KG);
        }

        public Builder setPageToken(String token) {
            this.KF = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.KG = sortOrder;
            return this;
        }
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder) {
        this.xM = versionCode;
        this.KE = clause;
        this.KF = pageToken;
        this.KG = sortOrder;
    }

    Query(LogicalFilter clause, String pageToken, SortOrder sortOrder) {
        this(1, clause, pageToken, sortOrder);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.KE;
    }

    public String getPageToken() {
        return this.KF;
    }

    public SortOrder getSortOrder() {
        return this.KG;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}

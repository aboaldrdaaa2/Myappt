package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new d();
    final ComparisonFilter<?> KP;
    final FieldOnlyFilter KQ;
    final LogicalFilter KR;
    final NotFilter KS;
    final InFilter<?> KT;
    final MatchAllFilter KU;
    final HasFilter KV;
    private final Filter KW;
    final int xM;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter) {
        this.xM = versionCode;
        this.KP = comparisonField;
        this.KQ = fieldOnlyFilter;
        this.KR = logicalFilter;
        this.KS = notFilter;
        this.KT = containsFilter;
        this.KU = matchAllFilter;
        this.KV = hasFilter;
        if (this.KP != null) {
            this.KW = this.KP;
        } else if (this.KQ != null) {
            this.KW = this.KQ;
        } else if (this.KR != null) {
            this.KW = this.KR;
        } else if (this.KS != null) {
            this.KW = this.KS;
        } else if (this.KT != null) {
            this.KW = this.KT;
        } else if (this.KU != null) {
            this.KW = this.KU;
        } else if (this.KV != null) {
            this.KW = this.KV;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        this.xM = 2;
        this.KP = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.KQ = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.KR = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.KS = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.KT = filter instanceof InFilter ? (InFilter) filter : null;
        this.KU = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.KV = filter instanceof HasFilter ? (HasFilter) filter : null;
        if (this.KP == null && this.KQ == null && this.KR == null && this.KS == null && this.KT == null && this.KU == null && this.KV == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        }
        this.KW = filter;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        d.a(this, out, flags);
    }
}

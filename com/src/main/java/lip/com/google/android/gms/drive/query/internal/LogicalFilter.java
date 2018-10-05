package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter implements SafeParcelable, Filter {
    public static final Creator<LogicalFilter> CREATOR = new h();
    private List<Filter> KH;
    final Operator KL;
    final List<FilterHolder> KY;
    final int xM;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.xM = versionCode;
        this.KL = operator;
        this.KY = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.xM = 1;
        this.KL = operator;
        this.KY = new ArrayList(additionalFilters.length + 1);
        this.KY.add(new FilterHolder(filter));
        this.KH = new ArrayList(additionalFilters.length + 1);
        this.KH.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.KY.add(new FilterHolder(filter2));
            this.KH.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.xM = 1;
        this.KL = operator;
        this.KH = new ArrayList();
        this.KY = new ArrayList();
        for (Filter filter : filters) {
            this.KH.add(filter);
            this.KY.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        h.a(this, out, flags);
    }
}

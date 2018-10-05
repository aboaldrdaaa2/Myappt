package lip.com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] Sn = new String[]{"requestId", "outcome"};
    private final int CT;
    private final HashMap<String, Integer> So;

    public static final class Builder {
        private int CT = 0;
        private HashMap<String, Integer> So = new HashMap();

        public Builder cw(int i) {
            this.CT = i;
            return this;
        }

        public RequestUpdateOutcomes iy() {
            return new RequestUpdateOutcomes(this.CT, this.So);
        }

        public Builder v(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.So.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.CT = statusCode;
        this.So = outcomeMap;
    }

    public static RequestUpdateOutcomes U(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.cw(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int ae = dataHolder.ae(i);
            builder.v(dataHolder.c("requestId", i, ae), dataHolder.b("outcome", i, ae));
        }
        return builder.iy();
    }

    public Set<String> getRequestIds() {
        return this.So.keySet();
    }

    public int getRequestOutcome(String requestId) {
        hm.b(this.So.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.So.get(requestId)).intValue();
    }
}

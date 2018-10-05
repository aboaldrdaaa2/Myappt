package lip.com.google.android.gms.common.api;

import com.google.android.gms.internal.hm;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final PendingResult<?>[] DC;
    private final Status yz;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.yz = status;
        this.DC = pendingResults;
    }

    public Status getStatus() {
        return this.yz;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        hm.b(resultToken.mId < this.DC.length, (Object) "The result token does not belong to this batch");
        return this.DC[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}

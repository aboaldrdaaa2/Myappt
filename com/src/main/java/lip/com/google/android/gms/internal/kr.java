package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class kr extends d implements Moment {
    private kp adp;

    public kr(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private kp kE() {
        synchronized (this) {
            if (this.adp == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.adp = kp.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.adp;
    }

    public String getId() {
        return kE().getId();
    }

    public ItemScope getResult() {
        return kE().getResult();
    }

    public String getStartDate() {
        return kE().getStartDate();
    }

    public ItemScope getTarget() {
        return kE().getTarget();
    }

    public String getType() {
        return kE().getType();
    }

    public boolean hasId() {
        return kE().hasId();
    }

    public boolean hasResult() {
        return kE().hasId();
    }

    public boolean hasStartDate() {
        return kE().hasStartDate();
    }

    public boolean hasTarget() {
        return kE().hasTarget();
    }

    public boolean hasType() {
        return kE().hasType();
    }

    /* renamed from: kD */
    public kp freeze() {
        return kE();
    }
}

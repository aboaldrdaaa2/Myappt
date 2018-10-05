package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new i();
    String aiK;
    String aiL;
    String aje;
    String ajf;
    int ajg;
    String description;
    private final int xM;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            LineItem.this.aiL = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            LineItem.this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            LineItem.this.aje = quantity;
            return this;
        }

        public Builder setRole(int role) {
            LineItem.this.ajg = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            LineItem.this.aiK = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            LineItem.this.ajf = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.xM = 1;
        this.ajg = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.xM = versionCode;
        this.description = description;
        this.aje = quantity;
        this.ajf = unitPrice;
        this.aiK = totalPrice;
        this.ajg = role;
        this.aiL = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.aiL;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.aje;
    }

    public int getRole() {
        return this.ajg;
    }

    public String getTotalPrice() {
        return this.aiK;
    }

    public String getUnitPrice() {
        return this.ajf;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        i.a(this, dest, flags);
    }
}

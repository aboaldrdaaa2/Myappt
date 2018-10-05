package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new f();
    String aiQ;
    String aiR;
    ProxyCard aiS;
    String aiT;
    Address aiU;
    Address aiV;
    String[] aiW;
    UserAddress aiX;
    UserAddress aiY;
    InstrumentInfo[] aiZ;
    private final int xM;

    private FullWallet() {
        this.xM = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.xM = versionCode;
        this.aiQ = googleTransactionId;
        this.aiR = merchantTransactionId;
        this.aiS = proxyCard;
        this.aiT = email;
        this.aiU = billingAddress;
        this.aiV = shippingAddress;
        this.aiW = paymentDescriptions;
        this.aiX = buyerBillingAddress;
        this.aiY = buyerShippingAddress;
        this.aiZ = instrumentInfos;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.aiU;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.aiX;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.aiY;
    }

    public String getEmail() {
        return this.aiT;
    }

    public String getGoogleTransactionId() {
        return this.aiQ;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.aiZ;
    }

    public String getMerchantTransactionId() {
        return this.aiR;
    }

    public String[] getPaymentDescriptions() {
        return this.aiW;
    }

    public ProxyCard getProxyCard() {
        return this.aiS;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.aiV;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        f.a(this, out, flags);
    }
}

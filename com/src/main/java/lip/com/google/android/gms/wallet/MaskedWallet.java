package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.hm;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new k();
    String aiQ;
    String aiR;
    String aiT;
    Address aiU;
    Address aiV;
    String[] aiW;
    UserAddress aiX;
    UserAddress aiY;
    InstrumentInfo[] aiZ;
    LoyaltyWalletObject[] ajC;
    OfferWalletObject[] ajD;
    private final int xM;

    public final class Builder {
        private Builder() {
        }

        public MaskedWallet build() {
            return MaskedWallet.this;
        }

        public Builder setBillingAddress(Address billingAddress) {
            MaskedWallet.this.aiU = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            MaskedWallet.this.aiX = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            MaskedWallet.this.aiY = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            MaskedWallet.this.aiT = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            MaskedWallet.this.aiQ = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            MaskedWallet.this.aiZ = instrumentInfos;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjects) {
            MaskedWallet.this.ajC = loyaltyWalletObjects;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWallet.this.aiR = merchantTransactionId;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjects) {
            MaskedWallet.this.ajD = offerWalletObjects;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            MaskedWallet.this.aiW = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            MaskedWallet.this.aiV = shippingAddress;
            return this;
        }
    }

    private MaskedWallet() {
        this.xM = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.xM = versionCode;
        this.aiQ = googleTransactionId;
        this.aiR = merchantTransactionId;
        this.aiW = paymentDescriptions;
        this.aiT = email;
        this.aiU = billingAddress;
        this.aiV = shippingAddress;
        this.ajC = loyaltyWalletObjects;
        this.ajD = offerWalletObjects;
        this.aiX = buyerBillingAddress;
        this.aiY = buyerShippingAddress;
        this.aiZ = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        hm.f(maskedWallet);
        return ng().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder ng() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
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

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.ajC;
    }

    public String getMerchantTransactionId() {
        return this.aiR;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.ajD;
    }

    public String[] getPaymentDescriptions() {
        return this.aiW;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.aiV;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        k.a(this, dest, flags);
    }
}

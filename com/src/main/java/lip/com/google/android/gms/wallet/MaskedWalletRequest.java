package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new l();
    String aiL;
    String aiR;
    boolean ajF;
    boolean ajG;
    boolean ajH;
    String ajI;
    String ajJ;
    boolean ajK;
    boolean ajL;
    CountrySpecification[] ajM;
    boolean ajN;
    boolean ajO;
    ArrayList<CountrySpecification> ajP;
    Cart aja;
    private final int xM;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.ajP == null) {
                MaskedWalletRequest.this.ajP = new ArrayList();
            }
            MaskedWalletRequest.this.ajP.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (MaskedWalletRequest.this.ajP == null) {
                    MaskedWalletRequest.this.ajP = new ArrayList();
                }
                MaskedWalletRequest.this.ajP.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            MaskedWalletRequest.this.ajO = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            MaskedWalletRequest.this.ajN = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.aja = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.aiL = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.ajI = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.ajL = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.ajJ = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.aiR = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.ajF = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.ajG = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            MaskedWalletRequest.this.ajK = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.ajH = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.xM = 3;
        this.ajN = true;
        this.ajO = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping) {
        this.xM = versionCode;
        this.aiR = merchantTransactionId;
        this.ajF = phoneNumberRequired;
        this.ajG = shippingAddressRequired;
        this.ajH = useMinimalBillingAddress;
        this.ajI = estimatedTotalPrice;
        this.aiL = currencyCode;
        this.ajJ = merchantName;
        this.aja = cart;
        this.ajK = shouldRetrieveWalletObjects;
        this.ajL = isBillingAgreement;
        this.ajM = allowedShippingCountrySpecifications;
        this.ajN = allowPrepaidCard;
        this.ajO = allowDebitCard;
        this.ajP = allowedCountrySpecificationsForShipping;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.ajO;
    }

    public boolean allowPrepaidCard() {
        return this.ajN;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.ajP;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.ajM;
    }

    public Cart getCart() {
        return this.aja;
    }

    public String getCurrencyCode() {
        return this.aiL;
    }

    public String getEstimatedTotalPrice() {
        return this.ajI;
    }

    public String getMerchantName() {
        return this.ajJ;
    }

    public String getMerchantTransactionId() {
        return this.aiR;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public boolean isBillingAgreement() {
        return this.ajL;
    }

    public boolean isPhoneNumberRequired() {
        return this.ajF;
    }

    public boolean isShippingAddressRequired() {
        return this.ajG;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.ajK;
    }

    public boolean useMinimalBillingAddress() {
        return this.ajH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        l.a(this, dest, flags);
    }
}

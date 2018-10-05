package lip.com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new a();
    List<CountrySpecification> UE;
    private final int xM;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.UE == null) {
                UserAddressRequest.this.UE = new ArrayList();
            }
            UserAddressRequest.this.UE.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (UserAddressRequest.this.UE == null) {
                UserAddressRequest.this.UE = new ArrayList();
            }
            UserAddressRequest.this.UE.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.UE != null) {
                UserAddressRequest.this.UE = Collections.unmodifiableList(UserAddressRequest.this.UE);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.xM = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.xM = versionCode;
        this.UE = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}

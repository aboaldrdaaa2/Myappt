package lip.com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.kp;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private final Set<Integer> acs = new HashSet();
        private String adf;
        private kn adn;
        private kn ado;
        private String qX;
        private String xG;

        public Moment build() {
            return new kp(this.acs, this.xG, this.adn, this.adf, this.ado, this.qX);
        }

        public Builder setId(String id) {
            this.xG = id;
            this.acs.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.adn = (kn) result;
            this.acs.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.adf = startDate;
            this.acs.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.ado = (kn) target;
            this.acs.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String type) {
            this.qX = type;
            this.acs.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}

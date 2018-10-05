package lip.com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.Lf, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.Lf, filters);
    }

    public static Filter contains(SearchableMetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.Li, (SearchableMetadataField) field, (Object) value);
    }

    public static <T> Filter eq(SearchableMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.La, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.Ld, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.Le, (SearchableMetadataField) field, (Object) value);
    }

    public static <T> Filter in(SearchableCollectionMetadataField<T> field, T value) {
        return new InFilter((SearchableCollectionMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.Lb, (SearchableMetadataField) field, (Object) value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.Lc, (SearchableMetadataField) field, (Object) value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.Lg, filter, additionalFilters);
    }

    public static Filter or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.Lg, filters);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.KI);
    }
}

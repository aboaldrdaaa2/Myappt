package lip.com.google.ads.mediation;

import com.google.android.gms.internal.eu;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String message) {
            super(message);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    protected void a() {
    }

    public void load(Map<String, String> parameters) throws MappingException {
        Field field;
        Map hashMap = new HashMap();
        for (Field field2 : getClass().getFields()) {
            Parameter parameter = (Parameter) field2.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field2);
            }
        }
        if (hashMap.isEmpty()) {
            eu.D("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : parameters.entrySet()) {
            field = (Field) hashMap.remove(entry.getKey());
            if (field != null) {
                try {
                    field.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    eu.D("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    eu.D("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Bad Type");
                }
            } else {
                eu.z("Unexpected server option: " + ((String) entry.getKey()) + " = \"" + ((String) entry.getValue()) + "\"");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                eu.D("Required server option missing: " + ((Parameter) field3.getAnnotation(Parameter.class)).name());
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (stringBuilder.length() > 0) {
            throw new MappingException("Required server option(s) missing: " + stringBuilder.toString());
        }
        a();
    }
}

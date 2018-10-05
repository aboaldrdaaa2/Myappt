package lip.com.google.ads.interactivemedia.v3.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* compiled from: IMASDK */
public final class b {
    static final Type[] a = new Type[0];

    /* compiled from: IMASDK */
    private static final class a implements Serializable, GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = b.a(type);
        }

        public final Type getGenericComponentType() {
            return this.a;
        }

        public final boolean equals(Object o) {
            return (o instanceof GenericArrayType) && b.a((Type) this, (GenericArrayType) o);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return b.c(this.a) + "[]";
        }
    }

    /* compiled from: IMASDK */
    private static final class b implements Serializable, ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        public b(Type type, Type type2, Type... typeArr) {
            boolean z = true;
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z2 = type != null || cls.getEnclosingClass() == null;
                a.a(z2);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                a.a(z);
            }
            this.a = type == null ? null : b.a(type);
            this.b = b.a(type2);
            this.c = (Type[]) typeArr.clone();
            while (i < this.c.length) {
                a.a(this.c[i]);
                b.e(this.c[i]);
                this.c[i] = b.a(this.c[i]);
                i++;
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        public final Type getRawType() {
            return this.b;
        }

        public final Type getOwnerType() {
            return this.a;
        }

        public final boolean equals(Object other) {
            return (other instanceof ParameterizedType) && b.a((Type) this, (ParameterizedType) other);
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ b.a(this.a);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder((this.c.length + 1) * 30);
            stringBuilder.append(b.c(this.b));
            if (this.c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(b.c(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                stringBuilder.append(", ").append(b.c(this.c[i]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    /* compiled from: IMASDK */
    private static final class c implements Serializable, WildcardType {
        private final Type a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            boolean z;
            boolean z2 = true;
            a.a(typeArr2.length <= 1);
            if (typeArr.length == 1) {
                z = true;
            } else {
                z = false;
            }
            a.a(z);
            if (typeArr2.length == 1) {
                a.a(typeArr2[0]);
                b.e(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z2 = false;
                }
                a.a(z2);
                this.b = b.a(typeArr2[0]);
                this.a = Object.class;
                return;
            }
            a.a(typeArr[0]);
            b.e(typeArr[0]);
            this.b = null;
            this.a = b.a(typeArr[0]);
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        public final Type[] getLowerBounds() {
            if (this.b == null) {
                return b.a;
            }
            return new Type[]{this.b};
        }

        public final boolean equals(Object other) {
            return (other instanceof WildcardType) && b.a((Type) this, (WildcardType) other);
        }

        public final int hashCode() {
            return (this.b != null ? this.b.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
        }

        public final String toString() {
            if (this.b != null) {
                return "? super " + b.c(this.b);
            }
            if (this.a == Object.class) {
                return "?";
            }
            return "? extends " + b.c(this.a);
        }
    }

    static /* synthetic */ void e(Type type) {
        boolean z = ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        a.a(z);
    }

    private static GenericArrayType f(Type type) {
        return new a(type);
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(a(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Class<?> b(Type type) {
        Object obj = type;
        while (!(obj instanceof Class)) {
            if (obj instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) obj).getRawType();
                a.a(rawType instanceof Class);
                return (Class) rawType;
            } else if (obj instanceof GenericArrayType) {
                return Array.newInstance(b(((GenericArrayType) obj).getGenericComponentType()), 0).getClass();
            } else {
                if (obj instanceof TypeVariable) {
                    return Object.class;
                }
                if (obj instanceof WildcardType) {
                    obj = ((WildcardType) obj).getUpperBounds()[0];
                } else {
                    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + obj + "> is of type " + (obj == null ? "null" : obj.getClass().getName()));
                }
            }
        }
        return (Class) obj;
    }

    public static boolean a(Type type, Type type2) {
        Object obj = type2;
        Object obj2 = type;
        while (obj2 != obj) {
            if (obj2 instanceof Class) {
                return obj2.equals(obj);
            }
            if (obj2 instanceof ParameterizedType) {
                if (!(obj instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) obj2;
                ParameterizedType parameterizedType2 = (ParameterizedType) obj;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                Object obj3 = (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) ? 1 : null;
                return obj3 != null && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            } else if (obj2 instanceof GenericArrayType) {
                if (!(obj instanceof GenericArrayType)) {
                    return false;
                }
                GenericArrayType genericArrayType = (GenericArrayType) obj;
                obj2 = ((GenericArrayType) obj2).getGenericComponentType();
                obj = genericArrayType.getGenericComponentType();
            } else if (obj2 instanceof WildcardType) {
                if (!(obj instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) obj2;
                WildcardType wildcardType2 = (WildcardType) obj;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            } else if (!(obj2 instanceof TypeVariable)) {
                return false;
            } else {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj2;
                TypeVariable typeVariable2 = (TypeVariable) obj;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            }
        }
        return true;
    }

    public static String c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private static Type a(Type type, Class<?> cls, Class<?> cls2) {
        Class cls3 = cls;
        Type type2 = type;
        while (cls2 != cls3) {
            if (cls2.isInterface()) {
                Class[] interfaces = cls3.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls3.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        type = cls3.getGenericInterfaces()[i];
                        cls3 = interfaces[i];
                        type2 = type;
                        break;
                    }
                }
            }
            if (cls3.isInterface()) {
                return cls2;
            }
            while (cls3 != Object.class) {
                Class<?> superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    type = cls3.getGenericSuperclass();
                    cls3 = superclass;
                    type2 = type;
                } else {
                    Class<?> cls4 = superclass;
                }
            }
            return cls2;
        }
        return type2;
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        a.a(cls2.isAssignableFrom(cls));
        return a(type, (Class) cls, a(type, (Class) cls, (Class) cls2));
    }

    public static Type d(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type b = b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0039 A:{SYNTHETIC} */
    public static Type a(Type r9, Class<?> r10, Type r11) {
        /*
        r4 = 1;
        r3 = 0;
        r0 = r11;
    L_0x0003:
        r1 = r0 instanceof java.lang.reflect.TypeVariable;
        if (r1 == 0) goto L_0x0048;
    L_0x0007:
        r1 = r0;
        r1 = (java.lang.reflect.TypeVariable) r1;
        r0 = r1.getGenericDeclaration();
        r2 = r0 instanceof java.lang.Class;
        if (r2 == 0) goto L_0x003a;
    L_0x0012:
        r0 = (java.lang.Class) r0;
        r2 = r0;
    L_0x0015:
        if (r2 == 0) goto L_0x0046;
    L_0x0017:
        r0 = a(r9, r10, r2);
        r5 = r0 instanceof java.lang.reflect.ParameterizedType;
        if (r5 == 0) goto L_0x0046;
    L_0x001f:
        r5 = r2.getTypeParameters();
        r2 = r3;
    L_0x0024:
        r6 = r5.length;
        if (r2 >= r6) goto L_0x0040;
    L_0x0027:
        r6 = r5[r2];
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x003d;
    L_0x002f:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r0 = r0.getActualTypeArguments();
        r0 = r0[r2];
    L_0x0037:
        if (r0 != r1) goto L_0x0003;
    L_0x0039:
        return r0;
    L_0x003a:
        r0 = 0;
        r2 = r0;
        goto L_0x0015;
    L_0x003d:
        r2 = r2 + 1;
        goto L_0x0024;
    L_0x0040:
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
    L_0x0046:
        r0 = r1;
        goto L_0x0037;
    L_0x0048:
        r1 = r0 instanceof java.lang.Class;
        if (r1 == 0) goto L_0x0066;
    L_0x004c:
        r1 = r0;
        r1 = (java.lang.Class) r1;
        r1 = r1.isArray();
        if (r1 == 0) goto L_0x0066;
    L_0x0055:
        r0 = (java.lang.Class) r0;
        r1 = r0.getComponentType();
        r2 = a(r9, r10, r1);
        if (r1 == r2) goto L_0x0039;
    L_0x0061:
        r0 = f(r2);
        goto L_0x0039;
    L_0x0066:
        r1 = r0 instanceof java.lang.reflect.GenericArrayType;
        if (r1 == 0) goto L_0x007b;
    L_0x006a:
        r0 = (java.lang.reflect.GenericArrayType) r0;
        r1 = r0.getGenericComponentType();
        r2 = a(r9, r10, r1);
        if (r1 == r2) goto L_0x0039;
    L_0x0076:
        r0 = f(r2);
        goto L_0x0039;
    L_0x007b:
        r1 = r0 instanceof java.lang.reflect.ParameterizedType;
        if (r1 == 0) goto L_0x00ba;
    L_0x007f:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r1 = r0.getOwnerType();
        r5 = a(r9, r10, r1);
        if (r5 == r1) goto L_0x00ac;
    L_0x008b:
        r1 = r4;
    L_0x008c:
        r2 = r0.getActualTypeArguments();
        r6 = r2.length;
    L_0x0091:
        if (r3 >= r6) goto L_0x00ae;
    L_0x0093:
        r7 = r2[r3];
        r7 = a(r9, r10, r7);
        r8 = r2[r3];
        if (r7 == r8) goto L_0x00a9;
    L_0x009d:
        if (r1 != 0) goto L_0x00a7;
    L_0x009f:
        r1 = r2.clone();
        r1 = (java.lang.reflect.Type[]) r1;
        r2 = r1;
        r1 = r4;
    L_0x00a7:
        r2[r3] = r7;
    L_0x00a9:
        r3 = r3 + 1;
        goto L_0x0091;
    L_0x00ac:
        r1 = r3;
        goto L_0x008c;
    L_0x00ae:
        if (r1 == 0) goto L_0x0039;
    L_0x00b0:
        r1 = r0.getRawType();
        r0 = new com.google.ads.interactivemedia.v3.a.b.b$b;
        r0.<init>(r5, r1, r2);
        goto L_0x0039;
    L_0x00ba:
        r1 = r0 instanceof java.lang.reflect.WildcardType;
        if (r1 == 0) goto L_0x0039;
    L_0x00be:
        r0 = (java.lang.reflect.WildcardType) r0;
        r1 = r0.getLowerBounds();
        r2 = r0.getUpperBounds();
        r5 = r1.length;
        if (r5 != r4) goto L_0x00e6;
    L_0x00cb:
        r2 = r1[r3];
        r2 = a(r9, r10, r2);
        r1 = r1[r3];
        if (r2 == r1) goto L_0x0039;
    L_0x00d5:
        r0 = new com.google.ads.interactivemedia.v3.a.b.b$c;
        r1 = new java.lang.reflect.Type[r4];
        r5 = java.lang.Object.class;
        r1[r3] = r5;
        r4 = new java.lang.reflect.Type[r4];
        r4[r3] = r2;
        r0.<init>(r1, r4);
        goto L_0x0039;
    L_0x00e6:
        r1 = r2.length;
        if (r1 != r4) goto L_0x0039;
    L_0x00e9:
        r1 = r2[r3];
        r1 = a(r9, r10, r1);
        r2 = r2[r3];
        if (r1 == r2) goto L_0x0039;
    L_0x00f3:
        r0 = new com.google.ads.interactivemedia.v3.a.b.b$c;
        r2 = new java.lang.reflect.Type[r4];
        r2[r3] = r1;
        r1 = a;
        r0.<init>(r2, r1);
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.a.b.b.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }
}

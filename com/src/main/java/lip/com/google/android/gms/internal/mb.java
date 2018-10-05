package lip.com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class mb<M extends ma<M>, T> {
    protected final Class<T> amY;
    protected final boolean amZ;
    protected final int tag;
    protected final int type;

    private mb(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.amY = cls;
        this.tag = i2;
        this.amZ = z;
    }

    public static <M extends ma<M>, T extends me> mb<M, T> a(int i, Class<T> cls, int i2) {
        return new mb(i, cls, i2, false);
    }

    protected void a(mg mgVar, List<Object> list) {
        list.add(u(ly.p(mgVar.anc)));
    }

    protected boolean eM(int i) {
        return i == this.tag;
    }

    final T i(List<mg> list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        mg mgVar;
        if (this.amZ) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                mgVar = (mg) list.get(i2);
                if (eM(mgVar.tag) && mgVar.anc.length != 0) {
                    a(mgVar, arrayList);
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            T cast = this.amY.cast(Array.newInstance(this.amY.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        }
        i = list.size() - 1;
        mg mgVar2 = null;
        while (mgVar2 == null && i >= 0) {
            mgVar = (mg) list.get(i);
            if (!eM(mgVar.tag) || mgVar.anc.length == 0) {
                mgVar = mgVar2;
            }
            i--;
            mgVar2 = mgVar;
        }
        return mgVar2 == null ? null : this.amY.cast(u(ly.p(mgVar2.anc)));
    }

    protected Object u(ly lyVar) {
        Class componentType = this.amZ ? this.amY.getComponentType() : this.amY;
        try {
            me meVar;
            switch (this.type) {
                case 10:
                    meVar = (me) componentType.newInstance();
                    lyVar.a(meVar, mh.eO(this.tag));
                    return meVar;
                case 11:
                    meVar = (me) componentType.newInstance();
                    lyVar.a(meVar);
                    return meVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}

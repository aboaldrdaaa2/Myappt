package lip.com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class lv {

    public static class a {
        public final lw amp;
        public final List<Asset> amq;

        public a(lw lwVar, List<Asset> list) {
            this.amp = lwVar;
            this.amq = list;
        }
    }

    private static int a(String str, com.google.android.gms.internal.lw.a.a[] aVarArr) {
        int i = 14;
        for (com.google.android.gms.internal.lw.a.a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    static int a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static a a(DataMap dataMap) {
        lw lwVar = new lw();
        List arrayList = new ArrayList();
        lwVar.amr = a(dataMap, arrayList);
        return new a(lwVar, arrayList);
    }

    private static com.google.android.gms.internal.lw.a.a a(List<Asset> list, Object obj) {
        int i = 0;
        com.google.android.gms.internal.lw.a.a aVar = new com.google.android.gms.internal.lw.a.a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.amv = new com.google.android.gms.internal.lw.a.a.a();
        int i2;
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.amv.amx = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.amv.amB = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.amv.amA = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.amv.amy = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.amv.amz = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.amv.amD = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.amv.amC = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.amv.amw = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.amv.amG = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.amv.amH = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.amv.amI = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            aVar.amv.amJ = (long) a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            aVar.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set keySet = dataMap.keySet();
            com.google.android.gms.internal.lw.a[] aVarArr = new com.google.android.gms.internal.lw.a[keySet.size()];
            Iterator it = keySet.iterator();
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                aVarArr[i2] = new com.google.android.gms.internal.lw.a();
                aVarArr[i2].name = str;
                aVarArr[i2].amt = a((List) list, dataMap.get(str));
                i = i2 + 1;
            }
            aVar.amv.amE = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.lw.a.a[] aVarArr2 = new com.google.android.gms.internal.lw.a.a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 14;
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                com.google.android.gms.internal.lw.a.a a = a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i4 == 14 && a.type != 14) {
                        i2 = a.type;
                    } else if (a.type != i4) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        i2 = i4;
                    }
                    aVarArr2[i3] = a;
                    i3++;
                    i4 = i2;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.amv.amF = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    public static DataMap a(a aVar) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.lw.a aVar2 : aVar.amp.amr) {
            a(aVar.amq, dataMap, aVar2.name, aVar2.amt);
        }
        return dataMap;
    }

    private static ArrayList a(List<Asset> list, com.google.android.gms.internal.lw.a.a.a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.amF.length);
        for (com.google.android.gms.internal.lw.a.a aVar2 : aVar.amF) {
            if (aVar2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.lw.a aVar3 : aVar2.amv.amE) {
                    a(list, dataMap, aVar3.name, aVar3.amt);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(aVar2.amv.amx);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.amv.amB));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void a(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.lw.a.a aVar) {
        int i = aVar.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        com.google.android.gms.internal.lw.a.a.a aVar2 = aVar.amv;
        if (i == 1) {
            dataMap.putByteArray(str, aVar2.amw);
        } else if (i == 11) {
            dataMap.putStringArray(str, aVar2.amG);
        } else if (i == 12) {
            dataMap.putLongArray(str, aVar2.amH);
        } else if (i == 15) {
            dataMap.putFloatArray(str, aVar2.amI);
        } else if (i == 2) {
            dataMap.putString(str, aVar2.amx);
        } else if (i == 3) {
            dataMap.putDouble(str, aVar2.amy);
        } else if (i == 4) {
            dataMap.putFloat(str, aVar2.amz);
        } else if (i == 5) {
            dataMap.putLong(str, aVar2.amA);
        } else if (i == 6) {
            dataMap.putInt(str, aVar2.amB);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) aVar2.amC);
        } else if (i == 8) {
            dataMap.putBoolean(str, aVar2.amD);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) aVar2.amJ));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.lw.a aVar3 : aVar2.amE) {
                a(list, dataMap2, aVar3.name, aVar3.amt);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = a(str, aVar2.amF);
            ArrayList a = a(list, aVar2, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.lw.a[] a(DataMap dataMap, List<Asset> list) {
        Set keySet = dataMap.keySet();
        com.google.android.gms.internal.lw.a[] aVarArr = new com.google.android.gms.internal.lw.a[keySet.size()];
        int i = 0;
        Iterator it = keySet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return aVarArr;
            }
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            aVarArr[i2] = new com.google.android.gms.internal.lw.a();
            aVarArr[i2].name = str;
            aVarArr[i2].amt = a((List) list, obj);
            i = i2 + 1;
        }
    }
}

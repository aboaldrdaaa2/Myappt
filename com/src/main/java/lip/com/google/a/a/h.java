package lip.com.google.a.a;

import com.google.b.a.b;
import java.nio.ByteBuffer;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
public final class h {

    /* compiled from: IMASDK */
    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public static byte[] a(byte[] bArr, String str) throws a, com.google.b.a.a {
        if (bArr.length != 16) {
            throw new a();
        }
        try {
            byte[] a = b.a(str);
            if (a.length <= 16) {
                throw new a();
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        } catch (Throwable e22) {
            throw new a(e22);
        } catch (Throwable e222) {
            throw new a(e222);
        } catch (Throwable e2222) {
            throw new a(e2222);
        } catch (Throwable e22222) {
            throw new a(e22222);
        }
    }
}

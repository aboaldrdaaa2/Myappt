package lip.com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class o {
    private final m jQ;
    private final SecureRandom kl;

    public class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public o(m mVar, SecureRandom secureRandom) {
        this.jQ = mVar;
        this.kl = secureRandom;
    }

    static void c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] b(String str) throws a {
        try {
            byte[] a = this.jQ.a(str, false);
            if (a.length != 32) {
                throw new a();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new a(e);
        }
    }

    public byte[] c(byte[] bArr, String str) throws a {
        if (bArr.length != 16) {
            throw new a();
        }
        try {
            byte[] a = this.jQ.a(str, false);
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
        } catch (Throwable e222222) {
            throw new a(e222222);
        }
    }
}

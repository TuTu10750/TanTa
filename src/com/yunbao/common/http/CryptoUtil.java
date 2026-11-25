package com.yunbao.common.http;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /tmp/classes2.dex */
public class CryptoUtil {
    public static String decrypt(String str, String str2, String str3) {
        byte[] decode = Base64.decode(str, 0);
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        byte[] bytes2 = str3.getBytes(charset);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(decode));
    }
}

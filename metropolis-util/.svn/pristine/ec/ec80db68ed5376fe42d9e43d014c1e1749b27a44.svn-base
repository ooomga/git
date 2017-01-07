package net.juntech.util.verify;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import net.sf.json.JSONObject;



public class AESUtil {
    // 加密
    @SuppressWarnings("static-access")
	public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new Base64().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    @SuppressWarnings("static-access")
	public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "smilemobile12345";
        //  String cKey = "smilemobile";
        // 需要加密的字串
        String cSrc = "abcde放到放到放到fg";
        System.out.println(cSrc);
        // 加密
        String enString = AESUtil.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AESUtil.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);

        JSONObject json = new JSONObject();
        json.put("uuid", "c93c93cf-be3d-4aa3-824d-5774d4c520d2");
        json.put("filename", "IMG_20160513_155453.jpg");
        json.put("type", "002");
        json.put("md5", "22a2656e06690b5d85d7ad11e31ace38");
        
        System.err.println("json="+json.toString());
        String encrypt = AESUtil.Encrypt(json.toString(), "0123456789111213");
        System.err.println(encrypt);
        String m = "YXpk1X18kAJQ8uBrqavbXI0H3kSFQDqadni3OJ6nwysX24qqj7w3Y7p72Lh8dMnlQiQWmfmes63aZns8X92iONN32bBpUMLGyLw7yBVzZGrGTg/h7faEvwFZbSHG/3YbJg2rHCYo45QpszGLhG7C0dO0N9P60y8+KI7/GMvfzV00xasxfq6c9uZsfhmRUWOy";
        System.err.println("==========================================================");
        String decrypt = AESUtil.Decrypt(m, "0123456789111213");
        System.err.println(decrypt);
		
    }
}

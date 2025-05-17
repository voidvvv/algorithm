package cn.zkj.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/26
 * @version: 01
 */
public class UtilTest {

    public static void main(String[] args) throws Exception {
        String fileIn = "D:\\files\\vedio\\新建文件夹\\1.ts";
        String fileOut = "D:\\files\\vedio\\新建文件夹\\de_out.ts";

        FileInputStream is = new FileInputStream(fileIn);
        FileOutputStream os = new FileOutputStream(fileOut);
        byte[] buff = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read(buff)) != -1){
            bos.write(buff, 0, i);
            bos.flush();
        }
        byte[] decrypt = Decrypt(bos.toByteArray(), 0, bos.size(), "0b2f1849aefdefaa");
        os.write(decrypt, 0, i);
        os.flush();
        os.close();
        is.close();
    }

    private static int findA() {
        return 20;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;

    }

    /*
     * 解密方法
     * content 需要解密的密文
     * key 解密的秘钥
     * return 解密后的内容
     */
    public static String Decrypt(String content, String key) throws Exception {
        try {
            byte[] encrypted1 = content.getBytes();//先用base64解密

            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = key.getBytes("ASCII"); //参数类型
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");  //"算法/模式/补码方式"
            //CBC模式需要配置偏移量，设置这个后，不会出来同一个明文加密为同一个密文的问题，达到密文唯一性
            IvParameterSpec iv = new IvParameterSpec("0000000000000000".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static byte[] Decrypt (byte[] encrypted1, int s, int l, String key) {
        try {
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = key.getBytes(); //参数类型
            System.out.println(Arrays.toString(raw));
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC");  //"算法/模式/补码方式"
            //CBC模式需要配置偏移量，设置这个后，不会出来同一个明文加密为同一个密文的问题，达到密文唯一性
            IvParameterSpec iv = new IvParameterSpec("0000000000000000".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            try {
                byte[] original = cipher.doFinal(encrypted1, s, l);
                return original;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

package cn.zkj.algorithm;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Author: KJ.ZHAO
 * Date: 2021/11/11 13:23
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
//        FileReader fileReader = new FileReader("testFile.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testFile.csv"), StandardCharsets.UTF_16LE));

        String s = br.readLine();
        StringBuilder sql = new StringBuilder(" insert into agent_scm_suppliers_account ( ");
        String[] st = s.split("\t");

        for (String p :st){
            sql.append(p);
            sql.append(",");
        }
        System.out.println(sql);
        sql.append(") values ");


        if ((s = br.readLine())!=null){
            String[] split = s.split("\t");

            sql.append("(");
            for (int x=0;x<split.length;x++){
                if (x==0){
                    sql.append(split[x]);
                }else {
                    sql.append(" , ");
                    sql.append(split[x]);
                }
            }
            sql.append("),");
        }
        System.out.println(sql);

//        String charset = charset("testFile.csv");
//        System.out.println(charset);

    }

    public static String replace(String s){
        return s.replaceAll("\"","");
    }


    /**
     * 判断文本文件的字符集，文件开头三个字节表明编码格式。
     * <a href="http://blog.163.com/wf_shunqiziran/blog/static/176307209201258102217810/">参考的博客地址</a>
     *
     * @param path
     * @return
     * @throws Exception
     * @throws Exception
     */
    public static String charset(String path) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            bis.mark(0); // 读者注： bis.mark(0);修改为 bis.mark(100);我用过这段代码，需要修改上面标出的地方。
            // Wagsn注：不过暂时使用正常，遂不改之
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1) {
                bis.close();
                return charset; // 文件编码为 ANSI
            } else if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE"; // 文件编码为 Unicode
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE"; // 文件编码为 Unicode big endian
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8"; // 文件编码为 UTF-8
                checked = true;
            }
            bis.reset();
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80 - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) { // 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--文件-> [" + path + "] 采用的字符集为: [" + charset + "]");
        return charset;
    }
}

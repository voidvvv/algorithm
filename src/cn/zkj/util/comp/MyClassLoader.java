package cn.zkj.util.comp;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/25 14:25
 */
public class MyClassLoader extends URLClassLoader {
    private URL[] urls;

    public MyClassLoader(URL[] urls) {
        super(urls);
        this.urls = urls;
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> aClass = super.loadClass(name);
        if (aClass==null){
            return null;

        }else {
            return aClass;
        }
    }
}

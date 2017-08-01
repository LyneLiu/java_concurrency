package org.jvm.loader;

import org.jvm.loader.classloader.MyClassLoader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * 1、从本地系统中加载.class文件；
 * 2、通过网络下载.class文件；
 * 3、从zip、jar等归档文件中加载.class文件；
 * 4、从专有数据库中获取.class文件；
 * 5、将java源文件动态编译为.class文件。
 *
 * @author nn_liu
 * @Created 2017-07-31-15:11
 */
public class ClassLoaderMethod {

    public void loadFromLocal(){
        MyClassLoader myCLoader = new MyClassLoader("MyClassLoader");
        myCLoader.setPath("F:\\lyne\\coding_repo\\java_vm\\target\\classes\\");
        Class<?> clazz;
        try {
            clazz = myCLoader.loadClass("org.concurrent.chapter01.CountTask");
            System.out.println(clazz.getClassLoader().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Any URL that ends with a ' /' is assumed to refer to a directory.
     * http://www.oracle.com/technetwork/articles/java/classloaders-140370.html
     */
    public void loadFromRemote(){
        try{
            URL url = new URL("https://github.com/LyneLiu/java_concurrency/tree/master/src/main/java/org/remote/");
            URL[] urls = new URL[]{url};
            ClassLoader classLoader = new URLClassLoader(urls);
            Class clazz = classLoader.loadClass("HelloWorld");
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("print");
            method.invoke(obj);
            System.out.println(clazz.getClassLoader().toString());
        } catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void loadFromArchive(){

    }

    public void loadFromDB(){

    }

    public void loadFromJavaSource(){

    }

    public static void main(String[] args) {
        ClassLoaderMethod method = new ClassLoaderMethod();

        //method.loadFromLocal();

        method.loadFromRemote();

    }

}

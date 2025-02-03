
import java.lang.reflect.Method;

import common.DynamicClasses.DynamicClassLoader;

public class LoadClass {
    public static void main (String[] args){

        String classPath = "C:\\Users\\carlos.ds\\Documents\\GITHUB\\CoreJava\\bin\\";
        String className = "com.example.HelloWorldPackage.HelloWorld";
        String DynamicMethod = "printHelloWorld";
        try{
            DynamicClassLoader loader = new DynamicClassLoader(classPath);
            Class<?> myClass = loader.findClass(className);
            Object instance = myClass.getDeclaredConstructor().newInstance();
                Method metodo = myClass.getMethod(DynamicMethod);
                metodo.invoke(instance);
            

            System.out.println("Class loaded: " + myClass.getName());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

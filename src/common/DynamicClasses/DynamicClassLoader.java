package common.DynamicClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DynamicClassLoader extends ClassLoader{
    private String classPath;

    public DynamicClassLoader(String classPath){
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        try{
            String filePath = classPath + name.replace('.', '\\') + ".class";
            File file = new File(filePath);

            FileInputStream fis = new FileInputStream(file);
            byte[] classBytes = fis.readAllBytes();

            fis.close();

            return defineClass(name, classBytes, 0,classBytes.length);


        }catch(IOException e){
            throw new ClassNotFoundException("no se encontro la clase "+ name, e);
        }
    }
}

package org.generate;

import javassist.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by flysLi on 2017/8/30.
 */
public class GenerateNewClassByJavassist {
    public static void main(String[] args) throws Exception {
        //初始化容器
        ClassPool pool = ClassPool.getDefault();

        //通过cp生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("org.generate.Emp");

        //制造字段，首先制造私有化的字段
        CtField enameField = new CtField(pool.getCtClass("java.lang.String"), "ename", ctClass);
        //设为私有化
        enameField.setModifiers(Modifier.PRIVATE);
        //添加至类中
        ctClass.addField(enameField);

        //给字段添加get、set方法
        ctClass.addMethod(CtNewMethod.getter("getEname", enameField));
        ctClass.addMethod(CtNewMethod.setter("setEname", enameField));

        //制造构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n")
                .append("ename=\"yy\";\n")
                .append("\n}");
        ctConstructor.setBody(buffer.toString());
        //将构造函数添加到新类中
        ctClass.addConstructor(ctConstructor);

        //添加自定义方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printInfo", new CtClass[]{}, ctClass);
        //设置自定义方法的修饰符
        ctMethod.setModifiers(Modifier.PUBLIC);
        //为自定义方法设置函数体
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append("{\nSystem.out.println(\"begin!\");\n")
                .append("System.out.println(ename);\n")
                .append("System.out.println(\"over!\");\n")
                .append("}");
        ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);


        //为了验证效果，下面使用反射执行方法printInfo
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        obj.getClass().getMethod("printInfo", new Class[]{}).invoke(obj, new Object[]{});


        /*把生成的class文件写入硬盘*/
        String path = "D:\\学习\\生成java\\Emp.class";
        byte[] byArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File(path));
        fos.write(byArr);
        fos.close();

        System.out.println("执行结束");
    }
}

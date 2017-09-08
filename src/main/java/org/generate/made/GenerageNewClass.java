package org.generate.made;

import javassist.*;
import org.generate.entity.Field;
import org.generate.entity.TableInfo;
import org.utils.lang.StringUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by flysLi on 2017/8/30.
 */
@SuppressWarnings("all")
public class GenerageNewClass {

    private ClassPool pool;
    private TableInfo tableInfo;
    private CtClass ctClass;

    public GenerageNewClass(TableInfo tableInfo) {
        //初始化容器
        this.pool = ClassPool.getDefault();
        //初始化类参数
        this.tableInfo = tableInfo;
    }

    public void GenerageMethod() {

    }

    public void makeGlass() throws Exception {
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

    public void makePackage() {
        //通过cp生成一个public新类Emp.java
        ctClass = pool.makeClass(this.tableInfo.getPackageName() + "." + this.tableInfo.getClassName());
    }

    public void makeJava() {
        this.makePackage();
        try {
            this.makeField();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.makeConstructor();
        try {
            this.ctClass.writeFile("D:\\学习\\生成java");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeConstructor() {

    }

    public void makeField() throws Exception {

        List<Field> fieldList = this.tableInfo.getFieldList();
        for (Field field : fieldList) {
            //制造字段，首先制造私有化的字段
            CtField enameField = new CtField(this.formatType(field.getType()), field.getName(), ctClass);
            //设为私有化
            enameField.setModifiers(Modifier.PRIVATE);

            //添加至类中
            ctClass.addField(enameField);

            //给字段添加get、set方法
            ctClass.addMethod(CtNewMethod.getter("set" + StringUtil.shouzimudaxie(field.getName()), enameField));
            ctClass.addMethod(CtNewMethod.setter("set" + StringUtil.shouzimudaxie(field.getName()), enameField));
        }
    }

    public void makeMethod() {
        //制造构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n")
                .append("\n}");
        try {
            ctConstructor.setBody(buffer.toString());
            //将构造函数添加到新类中
            ctClass.addConstructor(ctConstructor);
                /*把生成的class文件写入硬盘*/
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public void writer() {
        String path = "D:\\学习\\生成java\\" + StringUtil.shouzimudaxie(this.tableInfo.getClassName()) + ".class";
        byte[] byArr = new byte[0];
        FileOutputStream fos = null;
        try {
            byArr = ctClass.toBytecode();
            fos = new FileOutputStream(new File(path));
            fos.write(byArr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 类型转换
     *
     * @param type
     * @return
     */
    public CtClass formatType(String type) {

        try {
            type = type.toLowerCase();
            if (type.indexOf("int") > -1) {
                return CtClass.intType;
            }
            if (type.indexOf("double") > -1) {
                return CtClass.doubleType;
            }
            if (type.indexOf("date") > -1) {
                return pool.getCtClass("java.util.Date");
            }
            if (type.indexOf("datetime") > -1) {
                return pool.getCtClass("java.util.Date");
            }
            if (type.indexOf("boolean") > -1) {
                return CtClass.booleanType;
            }
            if (type.indexOf("varchar") > -1) {
                return pool.getCtClass("java.lang.String");
            }
            if (type.indexOf("char") > -1) {
                return CtClass.charType;
            }
            if (type.indexOf("decimal") > -1) {
                return CtClass.doubleType;
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        try {
            return pool.getCtClass("java.lang.Object");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package crawler.anger;

import crawler.jasiel.Container;
import crawler.jasiel.ResourcesContainer;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 1.初始化各组件
 * 2.组建注入
 *
 * @author flysLi
 * @date 2018/3/19
 */
@SuppressWarnings("All")
public class WormApplicationContext {

    private Map<String, Object> objects = new HashMap<String, Object>(10);

    public WormApplicationContext(String packing) {
        /*2018/3/19 扫描包下所有的类，装入容器*/
        Set<Class<?>> classList = this.getClasses(packing);
        /*将所有的非接口类型实例化*/
        for (Class<?> cls : classList) {
            //TODO 2018/3/19 权宜之计：出现莫名其妙的问题，貌似只有这样能解决;
            if (cls.getName().indexOf("WormApplicatio") > -1) {
                continue;
            }
            if (!cls.isInterface()) {
                Map<String, Object> map = new HashMap<>(10);
                try {
                    this.objects.put(cls.getName(), cls.newInstance());
                } catch (InstantiationException e) {
                    System.err.println("不能实例化" + cls.getName() + "类");
                    System.err.println(e.getMessage());
                } catch (IllegalAccessException e) {
                    System.err.println("反射时调用了private方法所导致的该错误" + cls.getName());
                    System.err.println(e.getMessage());
                }
            }
        }
        /*将部分组件的属性进行注入*/
        for (String key : objects.keySet()) {
            Object object = objects.get(key);
            /*可被注入类*/
            if (object instanceof WormDepth) {
                this.ioc(object);
            }
            if (object instanceof WormPlane) {
                this.ioc(object);
            }
        }
    }

    /**
     * 将对象注入到某些属性中
     *
     * @param object
     */
    private void ioc(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(AutoWired.class) != null) {
                field.setAccessible(true);
                try {
                    if (this.getCustomInstance(field.getType()) == null) {
                        field.set(object, this.getDefaultObject(field.getType()));
                        this.log(object + "中的属性" + field.getType().getName() + "已经注入了自定义的实现");
                    } else {
                        field.set(object, this.getCustomInstance(field.getType()));
                        this.log(object + "中的属性" + field.getType().getName() + "已经注入了默认的实现");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取某个bean
     *
     * @param <T>
     * @param t
     * @return
     */
    public <T> T getBean(Class<T> t) {
        for (String key : objects.keySet()) {
            Object object = objects.get(key);
            if (object.getClass().getName().equals(t.getTypeName())) {
                return (T) object;
            }
        }
        return null;
    }

    private void log(String msg) {
        System.out.println("[" + new Date() + "]INFO:" + msg);
    }

    /**
     * 通过接口类型获得实现类
     *
     * @param cls 接口类型
     * @return
     */
    private Object getCustomInstance(Class<?> cls) {
        for (String key : objects.keySet()) {
            Object object = objects.get(key);
            Class<?>[] interfaces = object.getClass().getInterfaces();
            for (Class<?> i : interfaces) {
                if (cls.getName().equals(i.getName()) && i.getAnnotation(Compont.class) != null) {
                    return objects.get(key);
                }
            }
        }
        return null;
    }

    /**
     * 获取默认的实现
     *
     * @param cls
     * @return
     */
    private Object getDefaultObject(Class<?> cls) {
        for (String key : objects.keySet()) {
            Object object = objects.get(key);
            Class clas = object.getClass();
            Class<?>[] interfaces = clas.getInterfaces();
            for (Class<?> i : interfaces) {
                if (cls.getName().equals(i.getName())) {
                    return object;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        WormApplicationContext applicationContext = new WormApplicationContext("crawler.anger");
        Worm wormDepth = applicationContext.getBean(WormDepth.class);
        Container container = ResourcesContainer.getInstance();
        container.addLink("http://www.sina.com.cn");
        wormDepth.grab();
    }

    private Set<Class<?>> getClasses(String pack) {
        // 第一个class类的集合
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 获取包的名字 并进行替换
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(packageName, filePath,
                            recursive, classes);
                } else if ("jar".equals(protocol)) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                    System.err.println("jar类型的扫描");
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection())
                                .getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx)
                                            .replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(
                                                packageName.length() + 1, name
                                                        .length() - 6);
                                        try {
                                            // 添加到classes
                                            classes.add(Class
                                                    .forName(packageName + '.'
                                                            + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            @Override
            public boolean accept(File file) {
                return (recursive && file.isDirectory())
                        || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "."
                                + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0,
                        file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

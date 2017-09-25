package test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by flysLi on 2017/9/19.
 * <p>
 * 模仿ArrayList实现
 * </p>
 */
@SuppressWarnings("All")
public class FlrrayList extends AbstractList {
    private Object[] elementData;
    private int size;

    public FlrrayList() {

        //数组的长度默认为10
        this(10);
    }

    public Object get(int index) {
        return this.elementData[index];
    }

    public FlrrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("容量不能小于0");
        }
        //初始化数组
        this.elementData = new Object[initialCapacity];
    }

    /**
     * 数组中添加数据
     *
     * @param o <p>可以为任意类型</p>
     */
    public void add(int index, Object o) {
        if (index > size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     * 添加
     *
     * @param o
     * @return
     */
    public boolean add(Object o) {
        return false;
    }

    public void forEach(Consumer action) {

    }

    public Spliterator spliterator() {
        return null;
    }

    public Stream stream() {
        return null;
    }

    public Stream parallelStream() {
        return null;
    }

    /**
     * 检查是否下标越界
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
    }

    /**
     * 得到数据的长度
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean removeIf(Predicate filter) {
        return false;
    }

    public void replaceAll(UnaryOperator operator) {

    }

    public void sort(Comparator c) {

    }

    public static void main(String[] args) {
        String[] strs = new String[10];
        System.out.println(strs.length);
    }
}

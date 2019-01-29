package me.kaishun.平时自己想的一些算法.小区切换序列;

public class Model implements Comparable<Model> {
    public String eci;
    public int count;

    public Model(String eci,int count) {
        this.eci = eci;
        this.count = count;
    }

    @Override
    public int compareTo(Model o) {
        //从大到小排序
        return o.count-this.count;
    }

    public void addCount(int num) {
        count = count+num;
    }
}

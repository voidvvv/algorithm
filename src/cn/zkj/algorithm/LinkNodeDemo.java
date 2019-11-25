package cn.zkj.algorithm;

public class LinkNodeDemo {
    private int id;
    private String name;
    LinkNodeDemo next;

    public LinkNodeDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkNodeDemo{" +
                "学号=" + id +
                ", 名字='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkNodeDemo getNext() {
        return next;
    }

    public void setNext(LinkNodeDemo next) {
        this.next = next;
    }
}

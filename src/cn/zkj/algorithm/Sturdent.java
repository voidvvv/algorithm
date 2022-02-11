package cn.zkj.algorithm;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sturdent {
    private int id;
    private String name;
    private String gender;

    public static void main(String[] args) {
        System.out.println(new Date().getTime()/1000);
        System.out.println(Timestamp.valueOf(LocalDateTime.parse("2021-12-10 19:15:50", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).getTime());
    }
    @Override
    public String toString() {
        return "Sturdent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

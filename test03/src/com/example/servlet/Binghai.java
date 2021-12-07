package com.example.servlet;

/**
 * @author youngoo
 * @date 2021/12/7 17:58
 */
public class Binghai {
    private int id;
    private String name;
    private String mainDamage;
    private String occurredLaw;

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

    public String getMainDamage() {
        return mainDamage;
    }

    public void setMainDamage(String mainDamage) {
        this.mainDamage = mainDamage;
    }

    public String getOccurredLaw() {
        return occurredLaw;
    }

    public void setOccurredLaw(String occurredLaw) {
        this.occurredLaw = occurredLaw;
    }

    @Override
    public String toString() {
        return "Binghai{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainDamage='" + mainDamage + '\'' +
                ", occurredLaw='" + occurredLaw + '\'' +
                '}';
    }
}

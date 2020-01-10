package com2020.se;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/1/10 0010
 */
public class WolfDemo {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WolfDemo{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}

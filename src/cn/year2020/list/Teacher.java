package cn.year2020.list;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/9/2 0002
 */
public class Teacher implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}

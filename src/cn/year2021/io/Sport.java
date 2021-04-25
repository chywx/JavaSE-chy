package cn.year2021.io;/**
 * @author chy
 * @date 2021/4/25 0025 下午 15:06
 * Description：
 */

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/4/25 0025
 */
public class Sport implements Serializable {

    private static final long serialVersionUID = 22745109274267266L;

    private Integer id;

    private String name;

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

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


}

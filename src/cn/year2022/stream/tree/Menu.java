package cn.year2022.stream.tree;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * https://mp.weixin.qq.com/s/3No-NtDAu6l9TzpB4mKCvw
 */
public class Menu {

    /**
     * id
     */
    public Integer id;
    /**
     * 名称
     */
    public String name;
    /**
     * 父id ，根节点为0
     */
    public Integer parentId;
    /**
     * 子节点信息
     */
    public List<Menu> childList;


    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }


    @Test
    public void testtree() {
//模拟从数据库查询出来
        List<Menu> menus = Arrays.asList(
            new Menu(1, "根节点", 0),
            new Menu(2, "子节点1", 1),
            new Menu(3, "子节点1.1", 2),
            new Menu(4, "子节点1.2", 2),
            new Menu(5, "根节点1.3", 2),
            new Menu(6, "根节点2", 1),
            new Menu(7, "根节点2.1", 6),
            new Menu(8, "根节点2.2", 6),
            new Menu(9, "根节点2.2.1", 7),
            new Menu(10, "根节点2.2.2", 7),
            new Menu(11, "根节点3", 1),
            new Menu(12, "根节点3.1", 11)
        );

//获取父节点
        List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
            (m) -> {
                m.setChildList(getChildrens(m, menus));
                return m;
            }
        ).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        System.out.println(JSON.toJSON(collect));
    }

    /**
     * 递归查询子节点
     *
     * @param root 根节点
     * @param all 所有节点
     * @return 根节点信息
     */
    private List<Menu> getChildrens(Menu root, List<Menu> all) {
        List<Menu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
            (m) -> {
                m.setChildList(getChildrens(m, all));
                return m;
            }
        ).collect(Collectors.toList());
        return children;
    }


}




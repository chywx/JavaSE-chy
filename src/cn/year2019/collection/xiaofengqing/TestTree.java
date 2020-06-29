package cn.year2019.collection.xiaofengqing;

import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/12/9 0009
 */
public class TestTree {

    public static void main(String[] args) {
        List<Question> list = new ArrayList<>();
        list.add(new Question(1, "一级1", 0));
        list.add(new Question(2, "一级2", 0));
        list.add(new Question(3, "一级3", 0));
        list.add(new Question(4, "二级1-1", 1));
        list.add(new Question(5, "二级2-1", 2));
        list.add(new Question(6, "二级2-2", 2));
        list.add(new Question(7, "二级3-1", 3));
        list.add(new Question(8, "二级3-2", 3));
        System.out.println(list);
        for (Question question : list) {
            System.out.println(question);
        }

        List<Question> collect = list.stream().filter(p -> p.getParentId() == 0).collect(Collectors.toList());
        for (Question question : collect) {
            for (Question q : list) {
                if (question.getId().equals(q.getParentId())) {
                    question.getQuestions().add(q);
                }
            }
        }
        System.out.println(collect);
        String string = JSONArray.toJSONString(collect);
        System.out.println(string);

    }
}

class Question {

    private Integer id;
    private String label;
    private Integer parentId;
    private List<Question> questions = new ArrayList<>();

    public Question() {
    }

    public Question(Integer id, String label, Integer parentId) {
        this.id = id;
        this.label = label;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Question{" +
            "id=" + id +
            ", label='" + label + '\'' +
            ", parentId=" + parentId +
            ", questions=" + questions +
            '}';
    }
}

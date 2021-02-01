package cn.year2021;/**
 * @author chy
 * @date 2021/1/28 0028 下午 17:57
 * Description：
 */

import java.io.Serializable;
import java.util.Base64;
import java.util.List;
import org.springframework.util.SerializationUtils;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/28 0028
 */
public class Ser {

    // TODO 失败
    public static void main(String[] args) {
//        Aaa aaa = new Aaa();
//        List<String> strings = new ArrayList<String>() {{
//            add("chy");
//            add("xxp");
//        }};
//        aaa.setName(strings);
//        byte[] serialize = SerializationUtils.serialize(aaa);

        String s = "rO0ABXNyABtjb20uZ2JhbmsuYmV0LmVzLnJvY2tldC5BYWF+XInlXQsaTwIAAUwABG5hbWV0ABBMamF2YS91dGlsL0xpc3Q7eHBzcgA0Y29tLmdiYW5rLmJldC5lcy5yb2NrZXQuRWxhc3RpY3NlYXJjaE1hdGNoTGlzdGVuZXIkMT4RxO6aPP+ZAgAAeHIAE2phdmEudXRpbC5BcnJheUxpc3R4gdIdmcdhnQMAAUkABHNpemV4cAAAAAJ3BAAAAAJ0AANjaHl0AAN4eHB4";
//        String s = Base64.getEncoder().encodeToString(serialize);
        System.out.println(s);

        byte[] decode = Base64.getDecoder().decode(s);
        Aaa bbb = (Aaa) SerializationUtils.deserialize(decode);
        System.out.println(bbb);

    }

}

class Aaa implements Serializable {

    private static final long serialVersionUID = 9105304164837825103L;

    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}

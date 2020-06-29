package cn.year2018.chy.design.adapter.a2;

public class Clienter {
    public static void main(String[] args) {
        Ps2 p = new Adapter(new Usber());
        p.isPs2();
    }
}

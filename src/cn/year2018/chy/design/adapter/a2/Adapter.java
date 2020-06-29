package cn.year2018.chy.design.adapter.a2;

// 对象适配器，通过在适配器对象中构造对应的对象
public class Adapter implements Ps2 {
    private Usb usb;


    public Adapter(Usb usb) {
        super();
        this.usb = usb;
    }


    @Override
    public void isPs2() {
        usb.isUsb();
    }

}

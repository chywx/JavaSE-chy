package com.chy.design.template;

public abstract class HouseTemplate {
    protected HouseTemplate(String name){
        this.name = name;
    }

    protected String name;

    protected abstract void buildDoor();

    protected abstract void buildWindow();

    protected abstract void buildWall();

    protected abstract void buildBase();

    protected abstract void buildToilet();

    //钩子方法
    protected boolean isBuildToilet(){
        return true;
    }

    //公共逻辑
    public final void buildHouse(){
        buildBase();
        buildWall();
        buildDoor();
        buildWindow();
        if(isBuildToilet()){
            buildToilet();
        }
    }
}

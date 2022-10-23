package me.xflyiwnl.iridiumbuilds.objects;

public class BuildObject implements Nameable {

    String name;

    public BuildObject(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}

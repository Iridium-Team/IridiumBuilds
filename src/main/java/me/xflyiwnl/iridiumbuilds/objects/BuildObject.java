package me.xflyiwnl.iridiumbuilds.objects;

import java.util.UUID;

public class BuildObject implements Nameable, Uniqueable {

    String name;
    UUID uuid;

    public BuildObject(String name) {
        this.name = name;
        uuid = UUID.randomUUID();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUUID() {
        return null;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}

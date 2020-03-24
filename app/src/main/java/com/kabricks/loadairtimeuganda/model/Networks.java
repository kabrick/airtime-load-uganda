package com.kabricks.loadairtimeuganda.model;

public class Networks {
    private String slogan;
    private String network_name;
    private String image;

    public Networks(String slogan, String network_name, String image) {
        this.slogan = slogan;
        this.network_name = network_name;
        this.image = image;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getNetwork_name() {
        return network_name;
    }

    public void setNetwork_name(String network_name) {
        this.network_name = network_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

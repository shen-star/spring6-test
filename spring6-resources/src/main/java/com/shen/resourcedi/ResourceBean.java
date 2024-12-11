package com.shen.resourcedi;

import org.springframework.core.io.Resource;

public class ResourceBean {
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void printResourceInfo() {
        System.out.println(this.resource.getFilename());
        System.out.println(this.resource.getDescription());
    }
}

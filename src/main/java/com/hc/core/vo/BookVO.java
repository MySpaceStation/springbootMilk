package com.hc.core.vo;

import java.io.Serializable;

/**
 * Created by milk.huchan on 2017/3/11.
 */
public class BookVO implements Serializable {

    private String id;

    private String author;

    private String name;

    private boolean inStock;

    private String cat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}

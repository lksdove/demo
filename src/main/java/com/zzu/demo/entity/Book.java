package com.zzu.demo.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Book implements Serializable {


    @NotNull(message = "id不能为空")
    private Integer id;
    private String name;
    private String des;
    @DecimalMax(value = "100.0", message = "传入参数价格不能大于100")
    private Double price;

    public Book(Integer id, String name, String des, Double price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
}

package site.binghai.Entity.Business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 线路类
 * @Param imgUrl 图片
 * @Param price 费用
 * @Param suggestion 建议
 */
@Entity
public class Line {
    @Id
    @GeneratedValue
    private int id;
    private String city;
    private String name;
    private String pdescribe;
    private String imgUrl;
    private double price;
    private String suggestion;

    public Line(String city, String name, String describe, String imgUrl, double price, String suggestion) {
        this.city = city;
        this.name = name;
        this.pdescribe = describe;
        this.imgUrl = imgUrl;
        this.price = price;
        this.suggestion = suggestion;
    }

    public Line() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdescribe() {
        return pdescribe;
    }

    public void setPdescribe(String pdescribe) {
        this.pdescribe = pdescribe;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

package cn.itcast.recommend.engine.domain;

public class Product {
    private String id;//商品编号
    private String name;//商品名称
    private String price;//商品价格
    private String img;//商品图片地址
    private String url;//跳转到详情页
    private int status;//商品状态

    public Product() {
        this.status =1;
    } //上线

    public Product(String id, String name, String price, String url, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.img = img;
        this.status = 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Product obj1 = (Product) obj;
        return this.id.equals(obj1.getId());
    }
}

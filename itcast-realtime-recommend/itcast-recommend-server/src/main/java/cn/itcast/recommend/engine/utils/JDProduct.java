package cn.itcast.recommend.engine.utils;

import cn.itcast.recommend.engine.domain.Product;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Describe: 请补充类描述
 */
public class JDProduct {

    public static void main(String[] args) throws Exception {
        System.out.println(getProduct());
    }

    public static List<Product> getProduct() {
        String url = "https://sale.jd.com/act/iklG3xhS1LRcQqNJ.html";
        List<Product> list = getProductsByUrl(url);
        return list;
    }

    private static List<Product> getProductsByUrl(String url) {
        List<Product> list = new ArrayList<Product>();
        try {
            Document doucument = Jsoup.connect(url).get();
            Elements elements = doucument.getElementsByClass("jItem");
            for (Element element : elements) {
                String price = element.select("span.jdNum").text();
                price = price.replaceAll(" ", "");
                if (StringUtils.isBlank(price)) {
                    price = new Random().nextInt(1000) + "";
                }
                String title = element.select("div[title].jDesc").attr("title");
                String producturl = element.select("div[title].jDesc > a").attr("href");
                String skuid = null;
                if (StringUtils.isNotBlank(producturl)) {
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(producturl);
                    StringBuffer buffer = new StringBuffer();
                    while (matcher.find()) {
                        buffer.append(matcher.group());
                        skuid = buffer.toString();
                    }
                }
                String pic = element.select("img[original]").attr("original");
                if (StringUtils.isNotBlank(skuid) &&
                        StringUtils.isNotBlank(title) &&
                        StringUtils.isNotBlank(price) &&
                        StringUtils.isNotBlank(pic) &&
                        StringUtils.isNotBlank(producturl)) {
                    list.add(new Product(skuid, title, price, producturl, pic));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

}

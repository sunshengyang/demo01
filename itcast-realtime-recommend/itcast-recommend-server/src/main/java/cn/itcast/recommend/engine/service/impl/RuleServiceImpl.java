package cn.itcast.recommend.engine.service.impl;


import cn.itcast.recommend.engine.domain.Product;
import cn.itcast.recommend.engine.domain.Template;
import cn.itcast.recommend.engine.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class RuleServiceImpl implements RuleService {

    public Template getTemplateByAdId(String adId) {
        Template template = new Template();
        template.setNum(4);
        template.setType(1);
        Map<Integer, Product> map = new HashMap<Integer, Product>();
        //String skuid, String title, String price, String producturl, String pic
        map.put(new Integer(1), new Product("1739475", "我的推荐，你的选择", "199999", "http://item.jd.com/1739475.html", "http://img13.360buyimg.com/n6/s488x350_jfs/t2476/214/1387387908/47235/648d8471/5653ca40N964e7ee4.jpg"));
        template.setProducts(map);
        return "121".equals(adId) ? template : null;
    }

    public boolean isExist(String adId) {
        return "121".equals(adId);
    }
}

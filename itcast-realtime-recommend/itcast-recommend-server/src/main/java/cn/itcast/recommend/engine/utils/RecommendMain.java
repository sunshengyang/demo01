package cn.itcast.recommend.engine.utils;

import cn.itcast.recommend.engine.domain.Product;
import cn.itcast.recommend.engine.service.RecommendService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class RecommendMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");
        RecommendService recommendService = (RecommendService) ctx.getBean("recommendServiceImpl");
        long start = System.currentTimeMillis();
        //根据用户guyong的浏览记录，为广告位121，推荐24个商品
        // cookie  http协议
        List<Product> list = recommendService.recomend("121", "guyong", "1139274,4356708,3477298");
        for (Product product : list) {
            System.out.println(product);
        }
        System.out.println("推荐耗时：" + (System.currentTimeMillis() - start));
    }
}

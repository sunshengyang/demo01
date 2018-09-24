package cn.itcast.recommend.engine.controller;

import cn.itcast.recommend.engine.domain.Product;
import cn.itcast.recommend.engine.service.RecommendService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping(value = "/ad", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String rec(String aid, String callback) {
        //System.out.println(aid);
       // ArrayList<Product> products = new ArrayList<Product>();
      //  products.add(new Product("283397", "剑南春 水晶剑 52度 单瓶装白酒 500ml 口感浓香型", "388", "https://item.jd.com/283397.html", "https://img11.360buyimg.com/n1/s450x450_jfs/t6214/49/368477431/462778/ead8e3db/593e0a7aN037e4adf.jpg"));
       // products.add(new Product("836075", "维达(Vinda) 卷纸 蓝色经典3层140g卫生纸*30卷", "58", "https://item.jd.com/836075.html", "https://img11.360buyimg.com/n1/s450x450_jfs/t3703/245/278494991/464071/68d05710/58046718Nbcbca0ba.jpg"));
        List<Product> products = recommendService.recomend(aid, "guyong", "1040870,1039778,1488814,1039878");
        Gson gson = new Gson();
        String content = gson.toJson(products);
        String result = callback + "(" + content + ")";
        return result;
    }
}

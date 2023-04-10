package com.jaycabasag.mobileecommerce.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Configuration
public class ShopConfig {
    @Bean
    CommandLineRunner commandLineRunner(ShopRepository shopRepository){
        Shop shop1 = new Shop(
                "Apple Store",
                "apple-store",
                "Shop the latest Apple products, including the iPhone, iPad, Mac, and Apple Watch.",
                "1 Infinite Loop, Cupertino, CA 95014, United States",
                "+1-408-996-1010",
                "support@apple.com",
                "https://1000logos.net/wp-content/uploads/2016/10/Apple-Logo-500x281.png",
                "https://www.apple.com",
                true,
                "Apple Inc.",
                2000,
                new Date(),
                new Date()
        );
        Shop shop2 = new Shop(
                "ASUS Online Store",
                "asus-online-store",
                "Shop the latest ASUS laptops, desktops, and accessories online.",
                "4F-1, No. 150, Jian Yi Road, Zhonghe District, New Taipei City 23585, Taiwan",
                "+886-2-2894-3447",
                "support@asus.com",
                "https://logos-world.net/wp-content/uploads/2020/07/Asus-Logo-700x394.png",
                "https://www.asus.com",
                true,
                "ASUSTeK Computer Inc.",
                1200,
                new Date(),
                new Date()
        );
        Shop shop3 = new Shop(
                "Huawei Online Store",
                "huawei-online-store",
                "Shop the latest Huawei smartphones, tablets, and accessories online.",
                "Shenzhen, China",
                "+86-755-28780808",
                "support@huawei.com",
                "https://logos-world.net/wp-content/uploads/2020/04/Huawei-Logo-700x394.png",
                "https://consumer.huawei.com",
                true,
                "Huawei Technologies Co., Ltd.",
                188000,
                new Date(),
                new Date()
        );

        Shop shop4 = new Shop(
                "OPPO Online Store",
                "oppo-online-store",
                "Shop the latest OPPO smartphones, smartwatches, and accessories online.",
                "Guangdong, China",
                "+86-755-26733199",
                "support@oppo.com",
                "https://1000logos.net/wp-content/uploads/2018/10/Oppo-logo-500x240.png",
                "https://www.oppo.com",
                true,
                "Guangdong OPPO Mobile Telecommunications Corp., Ltd.",
                100000,
                new Date(),
                new Date()
        );

        Shop shop5 = new Shop(
                "Samsung Online Store",
                "samsung-online-store",
                "Shop the latest Samsung smartphones, tablets, and accessories online.",
                "Seocho District, Seoul, South Korea",
                "+82-2-2255-7111",
                "support@samsung.com",
                " https://1000logos.net/wp-content/uploads/2017/06/Samsung-Logo-2-500x281.png",
                "https://www.samsung.com",
                true,
                "Samsung Electronics Co., Ltd.",
                500000,
                new Date(),
                new Date()
        );

        Shop shop6 = new Shop(
                "Xiaomi Online Store",
                "xiaomi-online-store",
                "Shop the latest Xiaomi smartphones, laptops, and accessories online.",
                "Beijing, China",
                "+86-10-6060-8686",
                "support@xiaomi.com",
                "https://1000logos.net/wp-content/uploads/2021/08/Xiaomi-logo.png",
                "https://www.mi.com",
                true,
                "Xiaomi Corporation",
                200000,
                new Date(),
                new Date()
        );


        return args -> {
            shopRepository.saveAll(List.of(shop1, shop2, shop3, shop4, shop5, shop6 ));
        };
    }
}

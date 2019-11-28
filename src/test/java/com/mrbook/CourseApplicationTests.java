package com.mrbook;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CourseApplicationTests {

    @Test
    void contextLoads() {
        String pwd = "511324200001170277";
        String md5_pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        String user = "201713160402";
        String sign = "1574926146889";
        String s = user + sign + md5_pwd;
        String r = DigestUtils.md5DigestAsHex(s.getBytes());
        System.out.println(r);
    }

    @Test
    void test() {
        System.out.println(new Date().getTime());
    }

    @Test
    void http() {
        String pwd = "511324200001170277";
        String md5_pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        String user = "201713160402";
        long sign = new Date().getTime();
        String s = user + sign + md5_pwd;
        String r = DigestUtils.md5DigestAsHex(s.getBytes());
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://202.115.133.173:805/Common/Handler/UserLogin.ashx"))
                .POST(HttpRequest.BodyPublishers
                        .ofString("Action=Login&userName=" + user +
                                "&pwd=" + r +
                                "&sign=" + sign))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<String> cookies = response.headers().allValues("Set-Cookie");
            String token1 = cookies.get(0).substring(0, 43);
            String token2 = cookies.get(1).substring(0, 47);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

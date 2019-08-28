package com.example.hjmtest;

import com.example.hjmtest.logic.controller.HttpClientResult;
import com.example.hjmtest.logic.controller.HttpClientUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HjmtestApplicationTests {

    /**
     * Description: 测试get无参请求
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:9090/hello/get");
        System.out.println(result);
    }

    @Test
    public void testGets() throws Exception {
        HttpClientResult result = HttpClientUtils.doGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18737873431");
//        System.out.println( result);
//        String str=result.toString();
//       // JSONObject.parseObject(str).getString("telString");
//        JSONObject object1=JSONObject.fromObject(str);
//        JSONArray object2=object1.getJSONArray("HttpClientResult");
//        for(int i=0;i<object2.size();i++){
//            System.out.print(object2.getJSONObject(i).get("telString"));
//        }
//        System.out.println(result.toString());
    }

    /**
     * Description: 测试get带参请求
     *
     * @throws Exception
     */
    @Test
    public void testGetWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "helloworld");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:9090/hello/getWithParam", params);
        System.out.println(result);
    }

    /**
     * Description: 测试post带请求头不带请求参数
     *
     * @throws Exception
     */
    @Test
    public void testPost() throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "123");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:9090/hello/post", headers, null);
        System.out.println(result);
    }

    /**
     * Description: 测试post带参请求
     *
     * @throws Exception
     */
    @Test
    public void testPostWithParam() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("code", "0");
        params.put("message", "helloworld");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:9090/hello/postWithParam", params);
        System.out.println(result);
    }


}

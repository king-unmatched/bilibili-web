package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.entity.User;
import com.jk.pojo.Result;
import com.jk.service.UserService;
import com.jk.util.CheckSumBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("loginus")
    public String loginus(){
        return "login";
    }
    @RequestMapping("svip")
    public String svip(){
        return "svip";
    }
    @RequestMapping("logins")
    public String logins(){
        return "logins";
    }
    @RequestMapping("buyvip")
    public String buyvip(){
        return "buyvip";
    }
    @RequestMapping("tonesefl")
    public String tonesefl(){
        return "tonesefl";
    }

    @RequestMapping("login")
    @ResponseBody
    public Result login(HttpServletRequest request, User user){
        User login = userService.login(user.getUsercode());
        if (login != null && !"".equals(login)) {
            //判断密码是否存在
            if (user.getPassword().equals(login.getPassword())) {
                //登录成功
                request.getSession().setAttribute("sysUser", login);
                return new Result(true, "登录成功！");
            } else {
                return new Result(false,"密码错误！");
            }
        } else {
            return new Result(false, "账号不存在！");
        }
    }
    @RequestMapping("sysUser")
    @ResponseBody
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        User name = (User) request.getSession().getAttribute("sysUser");
        String user = JSONObject.toJSONString(name);
        System.out.println(user);
        out.write(String.valueOf(user));
        out.flush();
        out.close();
    }
    @RequestMapping("zhuxiao")
    public String zhuxiao(HttpServletRequest request){
        request.getSession().removeAttribute("sysUser");
        return "index";
    }
    //发送验证码的请求路径URL
    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String APP_KEY="1c580adace5b5a892a970a7dd1b26807";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="400ebd808dc6";
    //随机数 结合APP_SECRET生成加密内容
    private static final String NONCE="123456";
    //短信模板ID
    private static final String TEMPLATEID="14895086";
    //手机号
    private static String MOBILE=null;
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN="6";
    @RequestMapping("dxcode")
    @ResponseBody
    public void dxcode(String phoneNumber) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //创建httpPost请求
        HttpPost httpPost = new HttpPost(SERVER_URL);
        //获得当前系统时间，规定生成加密时间，默认是5秒
        String curTime = String.valueOf((new Date()).getTime()/1000L);
        //根据APP_SECRET+随机数+当前时间生成加密认证规则
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        //密钥的随机数生成加密的随机数
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        //请求报文格式x-www-form-urlencoded，以from表单提交数据
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //创建一个页面表单集合NameValuePair，name代表name，value代表value.
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //BasicNameValuePair 基本的表单元素，key为input里面的name，value为input中的value值
        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
        MOBILE=phoneNumber;
        nvps.add(new BasicNameValuePair("mobile", MOBILE));
        nvps.add(new BasicNameValuePair("codeLen", CODELEN));
        //设置request body信息
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response=httpClient.execute(httpPost);
            String message = EntityUtils.toString(response.getEntity());
            Map<String, ?> responseMap = JSON.parseObject(message,Map.class);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.putAll(responseMap);
            System.out.println(message);
            Integer statuscode = (Integer) paramMap.get("code");
            if(statuscode==200){
                redisTemplate.opsForValue().set("sendCode"+phoneNumber, (String)paramMap.get("obj"), 60, TimeUnit.SECONDS);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @RequestMapping("loginto")
    @ResponseBody
    public Result loginto(User ccc,String code,String phoneNumber,HttpServletRequest request) {
        String user = (String) redisTemplate.opsForValue().get("sendCode" + phoneNumber);
        if (code.equals(user)) {
            userService.loginto(ccc);
            return new Result(true, "注册成功");
        } else {
            return new Result(false, "验证失败");
        }
    }
    @RequestMapping("xiu")
    @ResponseBody
    public void xiu(Integer id,String password){
        userService.xiu(id,password);
    }

    @RequestMapping("center")
    public String shop(){
        return "center";
    }
    @RequestMapping("qxvip")
    public String qxvip(){
        return "qxvip";
    }
    @RequestMapping("kgklishi")
    public String kgklishi(){
        return "kgklishi";
    }
    @RequestMapping("qqxinxi")
    public String qqxinxi(){
        return "qqxinxi";
    }
    @RequestMapping("zhguanli")
    public String zhguanli(){
        return "zhguanli";
    }

}

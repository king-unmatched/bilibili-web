package com.jk.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.entity.Order;
import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("svip")
public class PayController {
    @Autowired
    private UserService UserService;

    private final String APP_ID = "2016103100781627";
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChUl/p0Nj7yR+R30NcqwF1Zfv+OIbPvIYTklBIJMDEdBYCwpHJc2a8NRk3dEUjYfnCs15rYWTiCLrUF/rIaClajPmIXMi3vPQrqn9DUJlw5nJsJ9AeVxEIq2wLUctA+8grJiudiNv8hHkOAfn1IZqjq4WboTyBJHrCN+zVky0RjcuitnzaqWp2Qg6KJ5zUDELo+lV3/K9akwQM/J7F5Qc8u6YCLG6K1NBBpP04SQNYkS2+fRjNwPl0kc64QkssROAARbF+dEm70t3ymX3iKcgEHzIAT7WHdEruW2CTASja7fegEkA/pybLlotkgdnPytbCkYL6+dUoeIgenYcDtgnFAgMBAAECggEBAISUs5jw+HMt3xE+oRj2vbMjRs+u2zS9Zp+NHwe7lOWf1jscdz5N5oAFT50gpHWo3uBiE9ZCa+vMaudGcefkmx/9PlMQljFTTITakc7b3c9IxX8X1VYqDijG4XwIE/hrNR4pN603vjwxD2AwxaHtpS6gF6VJBPXJ6k3WMoFwfJiwVx0eVUszUSbulXF8VK21v415wgW23+aGodOAHG+CT55nm21EU7p6uXy2kIc1VBlVSxAwSdWD8tB4+80ILPYwkwsTt9IZJ9hjJyRof7B5z3bU/s5FS0AsZsw++W3GKZ7YA46IuKzDlphfdp3eaYPUcKW2zfEyrkbd+rkvh+DAwoECgYEA0WsTq+rdgOxaW7IDPQSeesF60gLgXBLo/LQIxwAS1ozH1BqhmAea1lwTMrR8XGgCf/4bqBzMxt0t3SyOWh6rhj0vpxaNlub+mQFe+sALzpaiCgFeLpsX8cXb/2NC8xT/zC14zVpkSQFHFWSf3hTRrXOcdXrqvxkhDvpLrFGFCyECgYEAxTSI8ZnzPJiDIO15ebphcR8aVaVjGVRrKz79942NQdZf2KslvzblcwxKr3d8MnDsgCT3VuScOl2ACEY8/5mpcqZ5bQRHZyIFsp6Jusf+WSsneKhIMLiaPKWSvXPTme/1OKJyQAIFK8lqo3SWUGrwKp1hEgtHtfsOBc4uLGOLriUCgYBpEzPcl8yqKm0wAwKS9CVcbIXmp+DQ8gALA34/8y6AjkSZjP81m+M52Rsc3uhjKSDP/bz8ve6VfVbM2dVXLHpdsYeea7eBVse6F7EDWabS8ku9f3A1LEZ4XhGDc9ecxhWO6eXqC4e0BbsX5dQ9Bu8p+48udw0f80jeDgI4JPL/YQKBgFL6YAUI+kgtBD/+rHaD7ixjIfmXtbMayl1QDBz1+tIRGhNZMHDc8H8QVPywEhpHWbwx0cFGQFZusUjKBTCnv5z2X3F3s3O55RvbiaiGLofmmJ00cevOQVfzc2M0MX08crp54Aj+0J40CiLtE7KSzKuhvQ6SoIH6OVRIBTW4TTXhAoGBAM+JhgddsEjlh9Mdv1b9mDLPexsbzG3h6vohggruwoJMJ5YOSO7gszxS591T2QPCTY/E5Su1smQDJY3ISQGI1DNMKxSKXDukPcDPSIdpe/yhGJs4es5eWFjy7Mag75cbiBVQXhSQz4B57B63yNauTclATUHBHEAPZCd/8yJ/szKM";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoVJf6dDY+8kfkd9DXKsBdWX7/jiGz7yGE5JQSCTAxHQWAsKRyXNmvDUZN3RFI2H5wrNea2Fk4gi61Bf6yGgpWoz5iFzIt7z0K6p/Q1CZcOZybCfQHlcRCKtsC1HLQPvIKyYrnYjb/IR5DgH59SGao6uFm6E8gSR6wjfs1ZMtEY3LorZ82qlqdkIOiiec1AxC6PpVd/yvWpMEDPyexeUHPLumAixuitTQQaT9OEkDWJEtvn0YzcD5dJHOuEJLLETgAEWxfnRJu9Ld8pl94inIBB8yAE+1h3RK7ltgkwEo2u33oBJAP6cmy5aLZIHZz8rWwpGC+vnVKHiIHp2HA7YJxQIDAQAB\n";
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT ="JSON";
    private final String SIGN_TYPE = "RSA2";
    private final String NOTIFY_URL = "http://127.0.0.1:8763/svip/alipay";
    private final String RETURN_URL = "http://localhost:8763/svip/returnUrl";

    @RequestMapping("alipay")
    public void alipay(String price,String name,String miaoshu,HttpServletResponse httpResponse) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =price;
        //订单名称，必填
        String subject =name;
        //商品描述，可空
        String body = miaoshu;
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(!signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态4
            User user = (User) request.getSession().getAttribute("sysUser");
            Date date = new Date();
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);//设置起时间
            if (total_amount.equals("20.00")||total_amount.equals("50.00")){
                if (user.getStatus()==0){
                    cal.setTime(user.getCreatetime());
                    cal.add(Calendar.MONTH, 1);
                }else{
                    cal.add(Calendar.MONTH, 1);
                }
                user.setCreatetime(cal.getTime());
            }
            if (total_amount.equals("45.00")||total_amount.equals("88.00")){
                if (user.getStatus()==0){
                    cal.setTime(user.getCreatetime());
                    cal.add(Calendar.MONTH, 3);
                }else{
                    cal.add(Calendar.MONTH, 3);
                }
                user.setCreatetime(cal.getTime());
            }
            if (total_amount.equals("198.00")||total_amount.equals("288.00")){
                if (user.getStatus()==0){
                    cal.setTime(user.getCreatetime());
                    cal.add(Calendar.YEAR, 1);
                }else{
                    cal.add(Calendar.YEAR, 1);
                }
                user.setCreatetime(cal.getTime());
            }
            List<Order> all = UserService.findAll(out_trade_no);
            if (all==null){
                UserService.creatOrder(out_trade_no,trade_no,total_amount);
                UserService.update(sim.format(user.getCreatetime()),user.getId());
            }
            return "svip";//跳转付款成功页面
        }else{
            return "buyvip";//跳转付款失败页面
        }

    }

    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        //System.out.println("111111111::::"+cal.getTime());
        cal.add(Calendar.YEAR, 1);//增加一年
        //cd.add(Calendar.DATE, n);//增加一天
        //cd.add(Calendar.DATE, -10);//减10天
        //cd.add(Calendar.MONTH, n);//增加一个月
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("输出::"+sim.format(cal.getTime()));
    }
}

package com.hc.http;

/**
 * Created by ThinkPad on 2017/6/5.
 */

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestHttpUtil {

    public static final String GET_URL = "";
    //POST请求本地测试地址
//    public static final String POST_URL = "http://desktop-ldc5c95/k3cloud/services/CMKVIPCardWebService.asmx";
//    //本地数据中心ID
//    public static final String DATA_CENTER_ID = "596479d699d2b3";//5932904c3ddc00";
//  public static final String POST_URL = "http://192.168.51.105/k3cloud/services/CMKVIPCardWebService.asmx";
  public static final String POST_URL = "http://club.iport.com.cn/k3cloud/services/CMKVIPCardWebService.asmx";
  public static final String DATA_CENTER_ID = "596497200e64a2";
    //用户名
    public static final String USERNAME = "demo";
    //密码
    public static final String PASSWORD = "123456";
    //token
    public static final String USERTOKEN = "";

    public static final String WX_POST_URL = "";


    /**
     * 接口调用 GET
     */
    public static void httpURLConectionGET(String path) {
        try {
            URL url = new URL(GET_URL + path);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
    }

    /**
     * 接口调用  POST
     */
    public static void httpURLConnectionPOST(String param, String path) {
        try {
            URL url = new URL(POST_URL + path);

            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中

            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);

            // 设置连接输入流为true
            connection.setDoInput(true);

            // 设置请求方式为post
            connection.setRequestMethod("POST");

            // post请求缓存设为false
            connection.setUseCaches(false);

            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);

            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();

            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());

            // 将参数输出到连接
            dataout.writeBytes(param);

            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)

//            System.out.println(connection.getResponseCode());

            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据

            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
//                sb.append(bf.readLine());
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试系统登录
    static void testLogin(){
        String param = "";
        String path = "/TestLoginSystemAuth ";
        try {
            String dataCenterID = URLEncoder.encode(DATA_CENTER_ID, "utf-8");
            String userName = URLEncoder.encode(USERNAME, "utf-8");
            String passWord = URLEncoder.encode(PASSWORD, "utf-8");
            String userToken = URLEncoder.encode(USERTOKEN, "utf-8");
            String isEncrypt = URLEncoder.encode("false", "utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("dataCenterID",dataCenterID);
            map.put("userName",userName);
            map.put("passWord",passWord);
            map.put("userToken",userToken);
            map.put("isEncrypt",isEncrypt);
            param = "lstParams="+JSON.toJSONString(map);
            System.out.println("请求参数为:"+param);
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpURLConnectionPOST(param, path);
    }

    //查询会员卡信息
    static void queryVIPCardInfo(){
        String param = "";
        String path = "/QueryVIPCardInfo";
        try {
            String dataCenterID = URLEncoder.encode(DATA_CENTER_ID, "utf-8");
            String userName = URLEncoder.encode(USERNAME, "utf-8");
            String passWord = URLEncoder.encode(PASSWORD, "utf-8");
            String userToken = URLEncoder.encode(USERTOKEN, "utf-8");
            String isEncrypt = URLEncoder.encode("false", "utf-8");
            String CardNo = URLEncoder.encode("86000001", "utf-8");
            String MobileNo = URLEncoder.encode("", "utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("dataCenterID",dataCenterID);
            map.put("userName",userName);
            map.put("passWord",passWord);
            map.put("userToken",userToken);
            map.put("isEncrypt",isEncrypt);
            map.put("CardNo",CardNo);
            map.put("MobileNo",MobileNo);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(new Date());

            map.put("TimeStamp",date);
            param = "lstParams="+JSON.toJSONString(map);

            System.out.println("请求参数:"+param);
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpURLConnectionPOST(param, path);
    }

    //查询会员信息
    static void queryVIPMemberInfo (){
        String param = "";
        String path = "/QueryVIPMemberInfo";
        try {
            String dataCenterID = URLEncoder.encode(DATA_CENTER_ID, "utf-8");
            String userName = URLEncoder.encode(USERNAME, "utf-8");
            String passWord = URLEncoder.encode(PASSWORD, "utf-8");
            String userToken = URLEncoder.encode(USERTOKEN, "utf-8");
            String isEncrypt = URLEncoder.encode("false", "utf-8");
            String CardNo = URLEncoder.encode("86000001", "utf-8");
            String MobileNo = URLEncoder.encode("", "utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("dataCenterID",dataCenterID);
            map.put("userName",userName);
            map.put("passWord",passWord);
            map.put("userToken",userToken);
            map.put("isEncrypt",isEncrypt);
            map.put("CardNo",CardNo);
            map.put("Mobile",MobileNo);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(new Date());

            map.put("TimeStamp",date);
            param = "lstParams="+JSON.toJSONString(map);

            System.out.println("请求参数:"+param);
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpURLConnectionPOST(param, path);
    }



    //会员注册
    static void registerMember(){
        String param = "";
        String path = "/RegisterVIPMember";
        try {
            String dataCenterID = URLEncoder.encode(DATA_CENTER_ID, "utf-8");
            String userName = URLEncoder.encode(USERNAME, "utf-8");
            String passWord = URLEncoder.encode(PASSWORD, "utf-8");
            String userToken = URLEncoder.encode(USERTOKEN, "utf-8");
            String isEncrypt = URLEncoder.encode("false", "utf-8");
            String VipName = URLEncoder.encode("测试001", "utf-8");
            String BranchNumber = URLEncoder.encode("100.15025", "utf-8");
            String FEmail = URLEncoder.encode("123@qq.com", "utf-8");
            String FName = URLEncoder.encode("张三", "utf-8");
            String Sex = URLEncoder.encode("男", "utf-8");
            String FBirthday = URLEncoder.encode("2006-10-01", "utf-8");
            String MobileNo = URLEncoder.encode("13812345678", "utf-8");
            String CardType = URLEncoder.encode("01", "utf-8");
            String CardNo = URLEncoder.encode("13812345678", "utf-8");
            Map<String, String> map = new HashMap<>();
            Map<String, String> vipParams = new HashMap<>();
            Map<String, String> cardParams = new HashMap<>();
            map.put("dataCenterID",dataCenterID);
            map.put("userName",userName);
            map.put("passWord",passWord);
            map.put("userToken",userToken);
            map.put("isEncrypt",isEncrypt);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(new Date());
            map.put("TimeStamp",date);

            vipParams.put("FEmail",FEmail);
            vipParams.put("VipName",VipName);
            vipParams.put("BranchNumber",BranchNumber);
            vipParams.put("FName",FName);
            vipParams.put("Sex",Sex);
            vipParams.put("FBirthday",FBirthday);
            vipParams.put("MobileNo",MobileNo);
            cardParams.put("CardType",CardType);
            cardParams.put("CardNo",CardNo);

            String cardParam = JSON.toJSONString(cardParams);

            String vipParam = JSON.toJSONString(vipParams);

            map.put("vipParams",cardParam);
            map.put("cardParams",vipParam);

            param = "lstParams="+JSON.toJSONString(map);

            System.out.println("请求参数:"+param);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        httpURLConnectionPOST(param, path);
    }

    static void TestCardAcctTransAction(){
        String param = "";
        String path = "/TestCardAcctTransAction";
        try {
            String dataCenterID = URLEncoder.encode(DATA_CENTER_ID, "utf-8");
            String userName = URLEncoder.encode(USERNAME, "utf-8");
            String passWord = URLEncoder.encode(PASSWORD, "utf-8");
            String userToken = URLEncoder.encode(USERTOKEN, "utf-8");
            String isEncrypt = URLEncoder.encode("false", "utf-8");
            String BranchNumber = URLEncoder.encode("100.15025", "utf-8");
            String CardNo = URLEncoder.encode("123@qq.com", "utf-8");
            String BillNo = URLEncoder.encode("张三", "utf-8");
            String OrgNumber = URLEncoder.encode("男", "utf-8");
            String FOperType = URLEncoder.encode("2006-10-01", "utf-8");
            String Note = URLEncoder.encode("2006-10-01", "utf-8");
            Map<String, String> map = new HashMap<>();
            Map<String, String> vipParams = new HashMap<>();
            Map<String, String> cardParams = new HashMap<>();
            map.put("dataCenterID",dataCenterID);
            map.put("userName",userName);
            map.put("passWord",passWord);
            map.put("userToken",userToken);
            map.put("isEncrypt",isEncrypt);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(new Date());
            map.put("TimeStamp",date);


            vipParams.put("BranchNumber",BranchNumber);
            cardParams.put("CardNo",CardNo);

            String cardParam = JSON.toJSONString(cardParams);

            String vipParam = JSON.toJSONString(vipParams);

            map.put("vipParams",cardParam);
            map.put("cardParams",vipParam);

            param = "lstParams="+JSON.toJSONString(map);

            System.out.println("请求参数:"+param);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        httpURLConnectionPOST(param, path);
    }

    public static void main(String[] args) {
//          testLogin();
//          queryVIPCardInfo();
//          registerMember();
//          queryVIPMemberInfo();
        System.out.println(99>>2);
    }

}
package com.example.shoppingmall.Service.weatherAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//컨테이너에 bean을 등록하여 contoroller가 불러올 수 있도록 선언
@Service
public class WeatherTest {

    //메서드마다 기능은 꼭 하나씩만 하도록 규칙 SOLID
    public void resultAPI() {
        String result =readAPI();

        // 파싱받아서 가공하는 라이브러리 JAVA
        //1. SimpleJson : 대용량 데이터 처리 속도가 빠름
        //2. Jackson : 평균적으로 빠름
        //3. Gson : 간단한 데이터 처리 속도가 빠름

        Gson resultGson = new GsonBuilder().setPrettyPrinting().create();
        String element = resultGson.toJson(result);

        System.out.println(element);
    }

    public String readAPI() {

        //인증키
        String Key = "ep78w%2F4dGR0jOQHB9akjcx7dwLZrHkk4CzBbXY1fp485qeexcSv6mzUAlZaX0MB5AnXCWMgY%2FUl2f8yYZ%2BRnVA%3D%3D";

        //데이터를 파싱받을 변수
        String brResult = "";

        //데이터를 받아와서 String 객체로 만들기 전에 한 줄씩 더해야 하므로, StringBuffer
        StringBuffer sb = new StringBuffer();

        //JSON API라는 것은 네트워크 통신을 데이터를 다운받아 서비스할 수 있도록 가공하기 위한 데이터
        //네트워크 통신이 끊기거나 예외적인 상황을 상정

        try {

            //https는 인증서가 필요하므로 http로 데이터 다운
            URL url = new URL("http://apis.data.go.kr/1360000/WthrChartInfoService/getAuxillaryChart?serviceKey=" +
                    "ep78w%2F4dGR0jOQHB9akjcx7dwLZrHkk4CzBbXY1fp485qeexcSv6mzUAlZaX0MB5AnXCWMgY%2FUl2f8yYZ%2BRnVA%3D%3D&pageNo=1&numOfRows=10&dataType=json&code1=N500&code2=ANL&time=20220828");
            //인증서가 필요한 객체
            HttpURLConnection con =(HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            while ((brResult = br.readLine()) != null) {
                sb.append(brResult);
            }

            br.close();;
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

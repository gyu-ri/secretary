package com.nj.secretary.services.diary.controller;


import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.domain.Translate;
import com.nj.secretary.services.diary.service.DiaryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/restDiary/*")
public class DiaryRestController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("getOthersDiaryList")
    public List<Diary> getOthersDiaryList(@RequestParam("shareStatus") String shareStatus, @RequestParam("userId") String userId, Model model){
        System.out.println("getOthersDiaryList start in controller");
        System.out.println("test : " + shareStatus + userId);
        List<Diary> list = diaryService.getOthersDiaryList();
        System.out.println("parse test : " + list);
        System.out.println("getOthersDiaryList finish in controller");
        model.addAttribute("list", list);
        return list;
    }

    @PostMapping("moveToBin")
    public List<Diary> moveToBin(@RequestBody List<String> id, HttpSession session){
        session.setAttribute("userId", "user02");
        String userId = (String) session.getAttribute("userId");


        System.out.println("Move to Bin 확인 : " + id);
//       for(String diary : id){
//
//           int diaryId = Integer.parseInt(diary);
//           diaryService.moveToBin(diaryId);
//       }
        System.out.println("삭제하기 위한 diary 객체 리스트 : " + id);
        for(int i = 0; i<id.size(); i++){
            diaryService.moveToBin(Integer.parseInt(id.get(i)));
        }
        List<Diary> list = diaryService.getDiaryList(userId);

        return list;
    }
    @GetMapping(value = "getDiaryList")
    public List<Diary> listDiary(@RequestParam("userId") String user){

        System.out.println("listDiary start in  Rest Controller");
        List<Diary> list = diaryService.getDiaryList(user);
        System.out.println("list : " + list);
        System.out.println("listDiary Rest Controller 완료");
        return list;
    }

    @GetMapping("getTagDiaryList")
    public List<Diary> getTagDiaryList(@RequestParam("userId") String userId, Model model){

        System.out.println("getTagDiaryList start");
        System.out.println("parameter : " + userId);
        List<Diary> list = diaryService.getTagDiaryList(userId);

        model.addAttribute("list", list);
        System.out.println("list? : " + list);
        System.out.println("getTagDiaryList end");
        return list;
    }

    @PostMapping("translateDiary")
    public String translateDiary(@RequestBody Translate translate){
        System.out.println(translate.getText());
        String clientId = "dKcP13Dm48SnFKYaKHjP";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "EI6YagCrnn";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(translate.getText(), "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source="+translate.getSource()+"&target="+translate.getTarget()+"&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "";
    }


}

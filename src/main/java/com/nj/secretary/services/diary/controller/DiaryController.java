package com.nj.secretary.services.diary.controller;


import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.service.DiaryService;
import com.google.gson.JsonObject;
import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.service.MonologueService;
import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {

    @Autowired
    DiaryService diaryService;
    @Autowired
    MonologueService monologueService;
    @Autowired
    UserService userService;


    @GetMapping("addDiary")
    public String addDiary(){
        return "diary/emotion";
    }


    @PostMapping("addDiarys")
    public String addDiary(@ModelAttribute("diary") Diary diary, Model model, @RequestParam("tag_text" +
            "") String tag_text){
        System.out.println("shareStatus : " + diary.getShareStatus());

        if(diary.getShareStatus().trim().equals("0,1")) {
            diary.setShareStatus("1");
        }
        System.out.println("diary : " + diary);
        System.out.println("다이어리 내용들 : " + diary.getDiaryTitle() + diary.getDiaryText());
        System.out.println("tag : " + tag_text);
        String[] tags = tag_text.split(",");

        diaryService.addDiary(diary);
        for(String tag : tags){
            diaryService.addFiles(tag);
        }
        System.out.println("다이어리 추가 완료");

        return "diary/getDiary";
    }


    @GetMapping("write")
    public String writeDiary(Diary diary){
        System.out.println("들어왔다 가야지");

        return "diary/boardWrite";
    }


    @PostMapping(value = "fileUpload", produces = "application/json")
    @ResponseBody
    public JsonObject fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("파일 업로드 시작");

        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\summertnote_image\\";    //저장될 파일 경로로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
        System.out.println("오리지널 파일 이름 : " + originalFileName);
        // 랜덤 UUID+확장자로 저장될 savedFileName
        String savedFileName = UUID.randomUUID() + extension;

        System.out.println("저장될 파일 이름 : " + savedFileName);
        File targetFile = new File(fileRoot + savedFileName);

        System.out.println("타겟 파일 이름 : " + targetFile);
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode", "success");
            System.out.println("addproperty해준 경로 : " + "url");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	// 실패시 저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }
        System.out.println("파일 업로드 끝" + jsonObject);
        return jsonObject;

    }


    @GetMapping(value = "getDiaryList")
    public String listDiary(HttpSession session, Model model){

        System.out.println("listDiary start in controller");
        session.setAttribute("userId", "윤도영");

        System.out.println("session 확인 : " + session.getAttribute("userId"));

       List<Diary> list = diaryService.getDiaryList((session.getAttribute("userId")).toString());
       System.out.println("list : " + list);
        model.addAttribute("list", list);
        model.addAttribute("user",session.getAttribute("userId"));
        System.out.println("listDiary controller 완료");
        return "diary/getDiaryList";
    }


    @GetMapping("getDiary")
    public String getDiary(@RequestParam("diaryNo") int diaryNo,Model model){
        System.out.println(diaryNo);
        System.out.println(diaryService.getDiary(diaryNo));
        model.addAttribute("diary",diaryService.getDiary(diaryNo));
        model.addAttribute("role", "admin");
        return "diary/getDiary";
    }


    @GetMapping("updateDiary")
    public String updateDiary(@RequestParam("diaryId") int diaryNo, Model model){
        System.out.println(diaryNo);
        System.out.println("update Diary");

        model.addAttribute("diary",diaryService.getDiary(diaryNo));
        return "diary/updateDiary";
    }


    @PostMapping("updateDiary")
    public String updateDiary(@ModelAttribute("diary") Diary diary, Model model){
        System.out.println("shareStatus : " + diary.getShareStatus());

        if(diary.getShareStatus().trim().equals("0,1")) {
            diary.setShareStatus("1");
        }
        System.out.println("diary : " + diary);
        System.out.println("다이어리 내용들 : " + diary.getDiaryTitle() + diary.getDiaryText());
        diaryService.updateDiary(diary);
        System.out.println("다이어리 추가 완료");

        return "diary/getDiary";
    }

    @GetMapping("binDiaryList")
    public String binDiaryList(HttpSession session,Model model){
        session.setAttribute("user","윤도영");

        model.addAttribute("diaryList",diaryService.getBinList((String) session.getAttribute("user")));
        return "diary/binDiary";
    }


    @GetMapping("adminPost")
    public String adminPost(Model model){
        System.out.println("admin Post start");
            List<Diary> diaryList = diaryService.getReportedDiaryList();
        System.out.println("diaryList get finish");
            List<Monologue> monoList = monologueService.getReportedMonoList();
        System.out.println("diaryList : " + diaryList);
        System.out.println("monoList : " + monoList);

        model.addAttribute("diaryList", diaryList);
        model.addAttribute("monoList", monoList);

        return "diary/adminPost";
    }


    
}
package com.nj.secretary.services.monologue.controller;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.service.MonologueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restMonologue/*")
public class MonologueRestController {

    @Autowired
    MonologueService monologueService;

    @GetMapping("getReportedMonologueList")
    public List<Monologue> adminPost(Model model){
        System.out.println("admin post in MonologueRestController start");
        List<Monologue> monologueList = monologueService.getReportedMonoList();

        model.addAttribute("monologueList", monologueList);

        return monologueList;
    }

    @PostMapping("setBlindMonologue")
    public int setBlindMonologue(@RequestBody String id){

        System.out.println("monologue check : " + id);
        int num = Integer.parseInt(id.split("=")[1]);
        System.out.println("parsing id : " + num);
        //        int num = Integer.parseInt();
       monologueService.setBlindMonologue(num);
        System.out.println("setBlindMonologue from MonologueRestController finish");
        return 1;
    }

    @GetMapping("getMonologueReportReason")
    public List<Monologue> getMonologueReportReason(@RequestParam("monologueId") int monologueId){
        System.out.println("getMonologueReportReason in monologueRestController start");
        System.out.println("parameter check : " + monologueId);

        List<Monologue> list = monologueService.getMonologueReportReason(monologueId);
        System.out.println("getMonologueReportReason in monologueRestController Finish");

        return list;
    }
}

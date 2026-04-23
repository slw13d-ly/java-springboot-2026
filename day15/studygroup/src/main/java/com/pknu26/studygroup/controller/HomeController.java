package com.pknu26.studygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pknu26.studygroup.dto.Site;
import com.pknu26.studygroup.service.SiteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SiteService siteService;

    @GetMapping("/")
    public String home(Model model) {

        Site title1 = this.siteService.getSiteByContentKey("CAROUSEL_1_TITLE");

        model.addAttribute("title1", title1);
        return "home";
    }
}
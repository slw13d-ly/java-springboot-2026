package com.pknu26.studygroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu26.studygroup.dto.Site;
import com.pknu26.studygroup.mapper.SiteMapper;
import com.pknu26.studygroup.validation.SiteForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SiteService {

    private final SiteMapper siteMapper;

    public List<Site> getSiteList() {
        return siteMapper.findAll();
    }

    public Site getSite(Long id) {
        return siteMapper.findById(id);
    }

    public Site getSiteByContentKey(String contentKey) {
        return siteMapper.findByContentKey(contentKey);
    }

    public void delete(Long id) {
        siteMapper.delete(id);
    }

    public void create(SiteForm siteForm) {
        
        Site site = new Site();
        site.setContentKey(siteForm.getContentKey());
        site.setContentBody(siteForm.getContentBody());        

        siteMapper.insert(site);
    }

    public void update(SiteForm siteForm) {
        
        Site site = siteMapper.findById(siteForm.getId());
        site.setContentKey(siteForm.getContentKey());
        site.setContentBody(siteForm.getContentBody());

        siteMapper.update(site);
    }    
}
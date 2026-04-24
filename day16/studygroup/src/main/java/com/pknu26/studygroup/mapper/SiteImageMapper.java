package com.pknu26.studygroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.studygroup.dto.SiteImage;

@Mapper
public interface SiteImageMapper {

    List<SiteImage> findAll();

    List<SiteImage> findAllActive();

    SiteImage findById(Long id);

    SiteImage findByImageKey(String imageKey);

    void insert(SiteImage siteImage);

    void update(SiteImage siteImage);

    void delete(Long id);
}

package com.pknu26.studygroup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pknu26.studygroup.dto.StudyApplication;

@Mapper
public interface StudyApplicationMapper {

    void insertApplication(StudyApplication studyApplication);

    int countByPostIdAndUserId(@Param("postId") Long postId,
                               @Param("userId") Long userId);

    List<StudyApplication> findByPostId(Long postId);

    List<StudyApplication> findByUserId(Long userId);

    StudyApplication findById(Long applicationId);

    void updateStatus(@Param("applicationId") Long applicationId,
                      @Param("status") String status);

    int countApprovedByPostId(Long postId);
}

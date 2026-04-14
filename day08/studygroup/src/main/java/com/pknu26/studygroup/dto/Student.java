package com.pknu26.studygroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // 멤버변수 getter 메서드 자동 생성
@Setter // 멤버변수 setter 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 파라미터 생성자 자동 생성
public class Student {
    
    private Long id;
    private String name;
    private Integer age;
    private String major;
    
    // public Student() { // 기본 생성자 - @NoArgsConstructor으로 필요 없음
    // }

    // public Student(Long id, String name, Integer age, String major) { // 파라미터 생성자 - @AllArgsConstructor으로 필요 없음
    //     this.id = id;
    //     this.name = name;
    //     this.age = age;
    //     this.major = major;
    // }
    
}

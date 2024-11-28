package com.example.secondproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity //1. 엔티티 선언
@Getter//자바 빈에 의해 getId와 같은 메서드 자동 생성. 표현 규약이 있음. 그걸 참조.
public class Article {
    @Id //3. id값 선언
    @GeneratedValue//4.id 값 자동 생성 선언.
    private Long id;

    //2. Article 엔티티의 필드(열) 선언
    @Column
    private String title;
    @Column
    private String content;

    public Article() {

    }

    public void patch(Article article) {//업데이트를 위해 들어온 값에 특정 필드 값만 수정하기 위함. 모두 변경을 막기위함.
        //예를 들어 content는 수정했는데 title은 수정을 안했다 가정하자. 이 함수가 없으면 title값은 null이 되어버림.
        //이때 if문을 통해 업데이트 할 내용이 없는 필드는 그냥 그대로 두는 것.
        if(article.title!=null)
            this.title = article.title;
        if(article.content!=null)
            this.content = article.content;
    }

    //toString은 객체의 정보를 문자열로 제공한다. 디버깅 하기 편해진다.
}

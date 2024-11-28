package com.example.secondproject.service;

import com.example.secondproject.dto.ArticleForm;
import com.example.secondproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        //1. 예상데이터
        Article a = new Article(1L,"1111","11111");
        Article b = new Article(2L,"2222","22222");
        Article c = new Article(3L,"3333","33333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        //2. 실제데이터
        List<Article> articles = articleService.index();
        //3. 비교 및 검증
        assertEquals(expected.toString(),articles.toString());//articles 라는 인스턴스가 애초에 없는데 왜 이렇게 알려주는거지?

    }

    @Test
    void show_success_exist_id() {
        long id = 1L;
        Article expected = new Article(id, "1111", "11111");
        Article article = articleService.show(id);
        assertEquals(expected.toString(), article.toString());//이거 만약 toString 없이 하면 안되나? 안됨.
        //Expected :com.example.secondproject.entity.Article@7b897456<Article(id=1, title=1111, content=11111)>
        //Actual   :com.example.secondproject.entity.Article@2b551e7b<Article(id=1, title=1111, content=11111)>
        //이런 오류가 발생함. Article 뒤에 @값이 다름. 엔티티 아이디가 달라서 다르다고 나옴.
    }
    @Test
    void show_failure() {
        long id = -1L;
        Article expected = null;
        Article article = articleService.show(id);
        assertEquals(expected.toString(),article.toString());
    }
    @Transactional
    @Test
    void create_success_title_content_dto(){
        String title = "4444";
        String content = "44444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L,title,content);

        Article article = articleService.create(dto);

        assertEquals(dto.toString(),expected.toString());
    }

    @Test
    void create_failure(){
        String title = "4444";
        String content = "44444";
        Long id = 4L;
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected,article);
    }



}
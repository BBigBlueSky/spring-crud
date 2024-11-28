package com.example.secondproject.repository;

import com.example.secondproject.entity.Article;
import com.example.secondproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정게시물 모든 댓글 조회")
    void findByArticleId() {
        long articleId = 4L;
        List<Comment> comments= commentRepository.findByArticleId(articleId);
        //3. 예상 데이터
        Article article = new Article(4L, "당신의 인생 영화는?","댓글 고"); //부모 게시글 생성
        Comment a = new Comment(1L, article,"Park","굿 윌 헌팅");  // 댓글 객체 작성
        Comment b = new Comment(2L, article,"Kim","아이 엠 샘");
        Comment c = new Comment(3L, article, "Choi","쇼생크 탈출");
        List<Comment> expected = Arrays.asList(a, b, c);//댓글 객체 합치기
        assertEquals(expected.toString(),comments.toString(),"4번 글의 모든 댓글을 출력");//object객체는 toString하면
        // 저장중인 메모리 해쉬코드를 반환. 이러면 내용이같아도 동작안함. toString오버라이딩해서 사용해야함.

    }

    @Test
    @DisplayName("특정 닉네임 모든 댓글 조회")
    void findByNickname() {
        String nickname = "Park";
        List<Comment> comments = commentRepository.findByNickname(nickname);
        Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 고"),
                nickname, "굿 윌 헌팅");
        Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 고고"),
                nickname, "치킨");
        Comment c = new Comment(7L, new Article(6L, "당신의 취미는?",  "댓글 고고고"),
                nickname, "조깅");
        List<Comment> expected = Arrays.asList(a, b, c);

        assertEquals(expected.toString(),comments.toString());

    }
}
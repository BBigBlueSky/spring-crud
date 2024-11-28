
INSERT INTO article(id,title,content) values(1,1111,11111);
INSERT INTO article(id,title,content) values(2,2222,22222);
INSERT INTO article(id,title,content) values(3,3333,33333);
INSERT INTO article(id,title, content) VALUES(4,'당신의 인생 영화는?', '댓글 고');
INSERT INTO article(id,title, content) VALUES(5,'당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(id,title, content) VALUES(6,'당신의 취미는?', '댓글 고고고');--id가 not null조건이 있음.

INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '쇼생크 탈출');
--5번 article comment
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '초밥');
--6번 article comment
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '독서');
package me.ohjisu.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ohjisu.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }


    @NoArgsConstructor
    @Getter
    public static class ArticleViewResponse {
        private Long id;
        private String title;
        private String content;
        private LocalDateTime createdAt;

        public ArticleViewResponse(Article article) {
            this.id = article.getId();
            this.title = article.getTitle();
            this.content = article.getContent();
            this.createdAt = article.getCreatedAt();
        }

    }
}

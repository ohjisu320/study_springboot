package me.ohjisu.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ohjisu.springbootdeveloper.domain.Article;
import me.ohjisu.springbootdeveloper.dto.AddArticleRequest;
import me.ohjisu.springbootdeveloper.dto.UpdateArticleRequest;
import me.ohjisu.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 하나 조회
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글 지우기
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정하기
    // BlogService.java

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article; // Article 객체를 반환
    }


}

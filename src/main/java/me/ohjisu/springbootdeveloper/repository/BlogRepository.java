package me.ohjisu.springbootdeveloper.repository;

import me.ohjisu.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}

package com.fastcampus.projectboard.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fastcampus.projectboard.config.JpaConfig;
import com.fastcampus.projectboard.domain.Article;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@DataJpaTest
@Import(JpaConfig.class)
class JpaRepositoryTest {

	@Autowired ArticleRepository articleRepository;
	@Autowired ArticleCommentRepository articleCommentRepository;

	@Autowired
	DataSource dataSource;
	@BeforeEach
	void init() throws SQLException {
		DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
		System.out.println(metaData.getURL());
	}
	@DisplayName("select 테스트")
	@Test
	void givenTestData_whenSelection_thenWorksFine() throws Exception{
		List<Article> articles = articleRepository.findAll();
		assertThat(articles).isNotNull()
			.hasSize(100);
	}

	@DisplayName("insert 테스트")
	@Test
	void givenTestData_whenInsert_thenWorksFine() throws Exception{
		long previousCount = articleRepository.count();
		Article article = Article.of("new article", "new content", "#spring");
		Article savedArticle = articleRepository.save(article);

		assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
	}

	@DisplayName("update 테스트")
	@Test
	void givenTestData_whenUpdate_thenWorksFine() throws Exception{
		Article article = articleRepository.findById(1L).orElseThrow();
		String updatedHashtag = "#springboot";
		article.setHashtag(updatedHashtag);

		Article savedArticle = articleRepository.saveAndFlush(article);

		assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
	}

	@DisplayName("delete 테스트")
	@Test
	void givenTestData_whenDelete_thenWorksFine() throws Exception{
		Article article = articleRepository.findById(1L).orElseThrow();
		long previousArticleCount = articleRepository.count();
		long previousArticleCommentCount = articleCommentRepository.count();
		int deleteCommentsSize = article.getArticleComments().size();

		articleRepository.delete(article);

		assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
		assertThat(articleCommentRepository.count()).isEqualTo(
			previousArticleCommentCount - deleteCommentsSize);


	}
}
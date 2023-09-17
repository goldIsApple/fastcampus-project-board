package com.fastcampus.projectboard.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


@Disabled
@DisplayName("Data REST API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class DatRestTest {

	@Autowired
	private MockMvc mockMvc;


	@DisplayName("[api] 게시글 리스트 조회")
	@Test
	void givenNothing_whenRequestingArticles_thenReturnsArticleSJsonResponse() throws Exception{
	    // given
		mockMvc.perform(get("/api/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());

	    // when

	    // then

	}

	@DisplayName("[api] 게시글 단건 조회")
	@Test
	void givenNothing_whenRequestingArticle_1_thenReturnsArticleJsonResponse() throws Exception{
		// given
		mockMvc.perform(get("/api/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());
		// when
		// then
	}
	@DisplayName("[api] 게시글 -> 댓글 리스트 조회")
	@Test
	void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentJsonResponse() throws Exception{
		// given
		mockMvc.perform(get("/api/articles/1/articleComments"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());
		// when
		// then
	}

	@DisplayName("[api]댓글 리스트 조회")
	@Test
	void givenNothing_whenRequestingArticleComments_thenReturnsArticleCommentsJsonResponse() throws Exception{
		// given
		mockMvc.perform(get("/api/articleComments"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());
		// when
		// then
	}

	@DisplayName("[api]댓글 단건 조회")
	@Test
	void givenNothing_whenRequestingArticleComment_thenReturnsArticleCommentJsonResponse() throws Exception{
		// given
		mockMvc.perform(get("/api/articleComments/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());
		// when
		// then
	}

}

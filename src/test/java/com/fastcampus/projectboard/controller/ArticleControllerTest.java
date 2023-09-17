package com.fastcampus.projectboard.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@DisplayName("[view][GET] 게시글 리스트 {게시판} 페이지 - 정상호출")
	@Test
	void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception{
		// given
		mockMvc.perform(get("/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML))
			.andExpect(model().attributeExists("articles"))
			.andDo(print());
		// when

		// then
	}

	

	@DisplayName("[view][GET] 게시글 상세 페이지 - 정상호출")
	@Test
	void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception{
		// given
		mockMvc.perform(get("/articles/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML))
			.andExpect(model().attributeExists("article"))
			.andDo(print());
		// when

		// then

	}

	@DisplayName("[view][GET] 게시글 검색 전용 페이지 - 정상호출")
	@Test
	void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception{
		// given
		mockMvc.perform(get("/articles/search"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML))
			.andDo(print());
		// when

		// then
	}

	@DisplayName("[view][GET] 게시글 해시태그 검색 페이지 - 정상호출")
	@Test
	void givenNothing_whenRequestingArticleHashTagSearchView_thenReturnsArticleHashTagSearchView() throws Exception{
		// given
		mockMvc.perform(get("/articles/search"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_HTML))
			.andDo(print());
		// when

		// then
	}

}
package com.fastcampus.projectboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Getter
@ToString
@Table( indexes = {
	@Index(columnList = "content"),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class ArticleComment extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Setter
	@ManyToOne(optional = false,fetch = FetchType.LAZY )
	@Exclude
	private Article article; // 게시글 (ID)

	@Setter
	@Column(nullable = false,length = 500)
	private String content; // 본문


	private ArticleComment(Article article, String content) {
		this.article = article;
		this.content = content;
	}
	private static ArticleComment of (Article article, String content) {
		return new ArticleComment(article, content);
	}
}

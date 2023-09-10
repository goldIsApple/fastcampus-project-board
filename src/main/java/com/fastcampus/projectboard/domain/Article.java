package com.fastcampus.projectboard.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "Article", indexes = {
	@Index(columnList = "title"),
	@Index(columnList = "hashtag"),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Article extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(nullable = false, length = 500)
	private String title; // 제목
	@Setter
	@Column(nullable = false, length = 500)
	private String content; // 본문
	@Setter
	private String hashtag; // 해시태그

	@OrderBy("id")
	@OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
	@Exclude
	private final Set<ArticleComment> articleComments = new LinkedHashSet<>();


	private Article(String title, String content, String hashtag) {
		this.title = title;
		this.content = content;
		this.hashtag = hashtag;
	}

	public static Article of(String title, String content, String hashtag) {
		return new Article(title, content, hashtag);
	}

/*	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Article article)) {
			return false;
		}
		return id!=null && id.equals(article.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}*/
}

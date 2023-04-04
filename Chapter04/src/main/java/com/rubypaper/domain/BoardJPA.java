package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@lombok.Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "BoardJPA")
public class BoardJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String writer;
	@Column(nullable = false)
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createDate;
	
	@ColumnDefault("0")
	private Long cnt;

	private BoardJPA(Builder builder) {

		this.id = builder.id;
		this.title = builder.title;
		this.writer = builder.writer;
		this.content = builder.content;
		this.createDate = builder.createDate;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Long id;
		private String title;
		private String writer;
		private String content;
		private Date createDate;
		private Builder() {
		};

		private Builder(Long id, String title, String writer, String content, Date createDate) {
			this.id = id;
			this.title = title;
			this.writer = writer;
			this.content = content;
			this.createDate = createDate;
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder writer(String writer) {
			this.writer = writer;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder createDate(Date createDate) {
			this.createDate = createDate;
			return this;
		}

		public BoardJPA build() {
			return new BoardJPA(this);
		}

	}

}
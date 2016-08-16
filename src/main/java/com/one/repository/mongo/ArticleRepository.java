package com.one.repository.mongo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.one.entity.mongo.Article;

/**
 * Created by Jay on 2015/5/26.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {

}

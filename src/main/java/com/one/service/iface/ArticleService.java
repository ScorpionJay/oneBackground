package com.one.service.iface;

import java.util.Date;
import java.util.List;

import com.one.weixin.vo.ArticleVo;
import com.one.weixin.vo.PaginationVo;

/**
 * Created by Jay on 2015/5/26.
 */
public interface ArticleService {

	/**
	 * Add
	 * @param articleVo
	 */
    void addArticle(ArticleVo articleVo);
    
    
    /**
	 * Delete
	 * @param articleId	文章id
	 */
    void deleteById(String articleId);
	
    /**
     * Get article by Id
     * @param articleId     文章id
     * @return
     */
    ArticleVo findById(String articleId);

    /**
     * 获取根据时间排序后的文章
     * @param date      时间
     * @return
     */
    List<ArticleVo> findAritcleBySortWithDate(Date date);

    /**
     * 根据分页页码和每页显示数量获取文章
     * @param pageNumber    页码
     * @param pageSize      每页显示数量
     * @return PaginationVo 分页对象
     */
    PaginationVo findAritcleByPagination(Integer pageNumber,Integer pageSize);

}

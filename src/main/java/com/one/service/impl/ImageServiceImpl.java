package com.one.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.one.entity.mongo.Image;
import com.one.repository.mongo.ImageRepository;
import com.one.service.iface.FileService;
import com.one.service.iface.IImageService;
import com.one.weixin.vo.PaginationVo;
import com.one.weixin.vo.WxArticleVo;

/**
 * Image service implement
 * @author 		Jay
 * @time		2015-6-4
 */
@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	FileService fileService;
	
    
    @Autowired
    MongoTemplate mongoTemplate; 
	
	@Override
	public void saveImage(Image image) {
		imageRepository.save(image);
	}

	@Override
	public PaginationVo findImageByPagination(Integer page, Integer size) {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"date"));
    	query.skip((page-1)*size);
		query.limit(size);
    	List<Image> list = mongoTemplate.find(query, Image.class);
        List<WxArticleVo> articleVoList = new ArrayList<WxArticleVo>();
/*        for(Image image : list){
        	ArticleVo articleVo = new ArticleVo(article.getArticleId(), article.getTitle(), article.getSummary(),article.getContent(), article.getDate());
        	articleVoList.add(articleVo);
        }*/
        
        PaginationVo paginationVo = new PaginationVo();
        paginationVo.setTotalItems(mongoTemplate.find(null, Image.class).size());
        paginationVo.setData(list);;
        
        return paginationVo;
	}

	@Override
	public Image findImageById(String id) {
		return imageRepository.findOne(id);
	}

	@Override
	public void deleteImageById(String id) {
		imageRepository.delete(new Image(id));

	}

}


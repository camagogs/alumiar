package com.project.alumiar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.alumiar.models.NewsLetter;
import com.project.alumiar.repository.NewsLetterRerpository;

@Service
public class NewsLetterService {
	
	@Autowired
	private NewsLetterRerpository newsRepository;
	
	public Iterable<NewsLetter> list(){
		
		Iterable<NewsLetter> users = newsRepository.findAll();
		
		return users;
	}
	
	public NewsLetter save(NewsLetter NewsLetter) {
		return newsRepository.saveAndFlush(NewsLetter);
	}
	
	
	public void delete(Long id) {
		newsRepository.delete(id);
	}
	
	public NewsLetter edit(Long id) {
		return newsRepository.findOne(id);
	}
	

}

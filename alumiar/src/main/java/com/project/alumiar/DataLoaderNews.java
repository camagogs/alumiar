package com.project.alumiar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.alumiar.models.NewsLetter;
import com.project.alumiar.repository.NewsLetterRerpository;

@Component
public class DataLoaderNews {
	
	private NewsLetterRerpository newsrepository;
	
	@Autowired
	public DataLoaderNews (NewsLetterRerpository newsrepository) {
		this.newsrepository = newsrepository;
	}
	
	@PostConstruct
	private void createNewsLetter() {
		NewsLetter n = new NewsLetter();
		
		n.setNome("Braullio");
		
		n.setEmail("braullio.soares_2012@hotmail.com");
		
		newsrepository.save(n);
		
	}
}

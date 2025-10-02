package com.fabirvale.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fabirvale.workshopmongo.domain.Post;
import com.fabirvale.workshopmongo.resources.util.URL;
import com.fabirvale.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping("/{id}")
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/titlesearch")
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
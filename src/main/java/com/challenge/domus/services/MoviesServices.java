package com.challenge.domus.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.domus.beans.Movie;
import com.challenge.domus.beans.ResponseMovies;
import com.challenge.domus.beans.ResponseServices;

@Service
public class MoviesServices {

	private final RestTemplate restTemplate;

	public MoviesServices(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
	}

	/**
	 * Return the directors who directed threshold o more movies.
	 * 
	 * @param threshold
	 * @return
	 */
	public ResponseServices getDirectors(int threshold) {
		List<Movie> movies = getDataFromUrl();

		Map<String, Integer> movies4Director = new HashMap<>();
		movies.forEach((m -> {
			movies4Director.merge(m.getDirector(), 1, Integer::sum);
		}));

		ResponseServices rs = new ResponseServices();
		rs.setDirectores(getDirectorByThreshold(movies4Director, threshold));

		return rs;
	}

	/**
	 * Get Data from URL
	 * 
	 * @return Data ResponseMovies Url.
	 */
	private List<Movie> getDataFromUrl() {
		ResponseEntity<ResponseMovies> responseEntity = restTemplate
				.getForEntity("https://eron-movies.wiremockapi.cloud/api/movies/search?page=2", ResponseMovies.class);

		return responseEntity.getBody().getData();
	}

	/**
	 * Filter director and return list of name in order.
	 * 
	 * @param movies4Director
	 * @param threshold
	 * @return
	 */
	private List<String> getDirectorByThreshold(Map<String, Integer> movies4Director, int threshold) {
		List<String> nameOfDirector = new ArrayList<>();
		movies4Director.forEach((k, v) -> {
			if (v > threshold)
				nameOfDirector.add(k);
		});

		return nameOfDirector.stream().sorted().collect(Collectors.toList());
	}
}

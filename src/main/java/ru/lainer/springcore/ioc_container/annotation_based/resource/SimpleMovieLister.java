package ru.lainer.springcore.ioc_container.annotation_based.resource;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SimpleMovieLister {
  private MovieFinder movieFinder;

  @Resource
  public void setMovieFinder(MovieFinder movieFinder) {
    this.movieFinder = movieFinder;
  }

  public void printMovies() {
    System.out.println("SimpleMovieLister -> printMovies()");
    movieFinder.findMovie();
  }
}

package org.zerock.mreview.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.Movie;

import java.util.List;

public interface  MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m, mi, avg (coalesce(r.grade,0)), COUNT (distinct r) " +
            "FROM Movie m " +
            "LEFT OUTER JOIN MovieImage mi ON mi.movie = m " +
            "LEFT OUTER JOIN Review r ON r.movie = m GROUP BY m")
    Page<Object[]> getListPage(Pageable pageable);

    @Query("SELECT m, mi, avg (coalesce(r.grade, 0)), count (distinct (r)) " +
            "FROM Movie m " +
            "LEFT OUTER JOIN MovieImage mi ON mi.movie = m " +
            "LEFT OUTER JOIN Review r ON r.movie = m " +
            "WHERE m.mno = :mno GROUP BY mi")
    List<Object[]> getMovieWithAll(Long mno);
}

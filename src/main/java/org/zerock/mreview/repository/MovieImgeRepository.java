package org.zerock.mreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mreview.entity.MovieImage;

public interface MovieImgeRepository extends JpaRepository<MovieImage, Long> {
}

package org.zerock.mreview.service;

import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getListOfMovie(Long mno);

    Long register(ReviewDTO reviewDTO);

    void modify(ReviewDTO reviewDTO);

    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO reviewDTO){

        Review movieReview = Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .movie(Movie.builder().mno(reviewDTO.getMno()).build())
                .member(Member.builder().mid(reviewDTO.getMid()).build())
                .grade(reviewDTO.getGrade())
                .text(reviewDTO.getText())
                .build();
        return movieReview;
    }

    default ReviewDTO entityToDTO(Review review){

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
                .mno(review.getMovie().getMno())
                .mid(review.getMember().getMid())
                .nickname(review.getMember().getNickname())
                .email(review.getMember().getEmail())
                .grade(review.getGrade())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();

        return reviewDTO;
    }
}

package com.example.rentalManagement.mappers;

import com.example.rentalManagement.dtos.ReviewDto;
import com.example.rentalManagement.entities.Review;

public class ReviewMapper {

    public static ReviewDto toDto(Review review) {
        if (review == null) return null;

        ReviewDto dto = new ReviewDto();
        dto.setReviewId(review.getReviewId());
        dto.setUserId(review.getUser().getUserId());
        dto.setPropertyId(review.getProperty().getPropertyId());
        dto.setRating(review.getRating());
        dto.setReviewText(review.getReviewText());
        return dto;
    }

    public static Review toEntity(ReviewDto dto) {
        if (dto == null) return null;

        Review review = new Review();
        review.setReviewId(dto.getReviewId());
        review.setRating(dto.getRating());
        review.setReviewText(dto.getReviewText());
        return review;
    }
}

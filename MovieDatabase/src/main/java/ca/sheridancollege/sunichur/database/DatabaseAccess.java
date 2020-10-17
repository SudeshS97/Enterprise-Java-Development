package ca.sheridancollege.sunichur.database;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sunichur.beans.Review;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertReview(Review review) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "INSERT INTO review(name, review, user_rating, streaming_service, date_time) "
				+ "VALUES (:name, :review,:userRating, :streamingService, :dateTime)";
		namedParameters.addValue("name", review.getName());
		namedParameters.addValue("review", review.getReview());
		namedParameters.addValue("userRating", review.getUserRating());
		namedParameters.addValue("streamingService", review.getStreamingService());
		review.setDateTime(LocalDateTime.now().toLocalDate().toString() + " "
				+ LocalDateTime.now().toLocalTime().toString().substring(0, 8));
		namedParameters.addValue("dateTime", review.getDateTime());

		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted review into database");

	}

	public List<Review> getReviewList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM review";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Review>(Review.class));
	}
}

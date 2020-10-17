package ca.sheridancollege.sunichur.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
	private Long id;
	private String name;
	private String review;
	private int userRating;
	private String streamingService;
	private String dateTime;
}

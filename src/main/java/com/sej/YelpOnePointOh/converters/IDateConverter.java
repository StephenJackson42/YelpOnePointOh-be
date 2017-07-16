package com.sej.YelpOnePointOh.converters;

import java.time.LocalDateTime;

public interface IDateConverter {
	public LocalDateTime convertLongToLocalDateTime (Long epoch);
	public Long convertLocalDateTimeToLong (LocalDateTime localDateTime);
}

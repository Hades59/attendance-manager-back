package dev.attendancemanager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;


public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    public static final DateTimeFormatter FORMATTER = ofPattern("dd::MM::yyyy");

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(p.getValueAsString(), FORMATTER);
    }
    public LocalDateDeserializer() {
		// TODO Auto-generated constructor stub
	}
}
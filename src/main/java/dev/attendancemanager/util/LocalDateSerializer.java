package dev.attendancemanager.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;


public class LocalDateSerializer extends JsonSerializer<LocalDate> {
    public static final DateTimeFormatter FORMATTER = ofPattern("dd::MM::yyyy");

    public LocalDateSerializer() {
	}
    
    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(FORMATTER));
    }
}
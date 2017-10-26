package com.travix.medusa.busyflights.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class InstantSerializer extends JsonSerializer<Instant> {

        private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

        @Override
        public void serialize(Instant date, JsonGenerator generator, SerializerProvider arg2) throws IOException {
                generator.writeString(formatter.format(date));
        }
}
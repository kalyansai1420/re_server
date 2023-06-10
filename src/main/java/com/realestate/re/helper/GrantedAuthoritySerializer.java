package com.realestate.re.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;

public class GrantedAuthoritySerializer extends JsonSerializer<GrantedAuthority> {

    @Override
    public void serialize(GrantedAuthority authority, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(authority.getAuthority());
    }

    @Override
    public void serializeWithType(GrantedAuthority value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(value, gen, serializers);
    }
}


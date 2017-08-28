package com.epam.potatorecycler.serializers;


import com.epam.potatorecycler.bean.Potato;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class PotatoJsonSerializer implements Serializer<Potato> {

    public PotatoJsonSerializer() {
    }

    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Potato potato) {

        byte[] result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            result = objectMapper.writeValueAsBytes(potato);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() {

    }
}

package com.epam.potatorecycler.serializers;

import com.epam.potatorecycler.bean.Potato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class PotatoJsonDeserializer implements Deserializer<Potato> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Potato deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Potato potato = null;
        try {
            potato = mapper.readValue(data, Potato.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return potato;
    }

    @Override
    public void close() {

    }
}

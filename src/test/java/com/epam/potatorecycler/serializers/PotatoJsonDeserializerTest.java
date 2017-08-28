package com.epam.potatorecycler.serializers;

import com.epam.potatorecycler.bean.GoodPotato;
import com.epam.potatorecycler.bean.Potato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PotatoJsonDeserializerTest {

    private static final String TOPIC = "potato_topic";
    private PotatoJsonDeserializer deserializer;

    @BeforeMethod
    public void setUp() throws Exception {
        deserializer = new PotatoJsonDeserializer();
    }

    @Test
    public void testDeserialize() throws Exception {

        Potato actualPotato = new GoodPotato();
        actualPotato.setPercentOfBlackSpots(25);

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] result = objectMapper.writeValueAsBytes(actualPotato);

        Potato expectedPotato = deserializer.deserialize(TOPIC, result);

        Assert.assertEquals(actualPotato, expectedPotato);


    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

}
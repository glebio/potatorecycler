package com.epam.potatorecycler.serializers;

import com.epam.potatorecycler.bean.GoodPotato;
import com.epam.potatorecycler.bean.Potato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PotatoJsonSerializerTest {

    private static final String TOPIC = "potato_topic";
    private PotatoJsonSerializer serializer;

    @BeforeMethod
    public void setUp() throws Exception {
        serializer = new PotatoJsonSerializer();
    }

    @Test
    public void testSerialize() throws Exception {
        Potato actualPotato = new GoodPotato();
        actualPotato.setPercentOfBlackSpots(20);

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] result = serializer.serialize(TOPIC, actualPotato);
        Potato expectedPotato = objectMapper.readValue(result, GoodPotato.class);

        Assert.assertEquals(actualPotato, expectedPotato);
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

}
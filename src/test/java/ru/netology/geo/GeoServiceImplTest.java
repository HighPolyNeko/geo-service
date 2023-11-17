package ru.netology.geo;

import org.junit.Before;
import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTest {

    private GeoServiceImpl geoService;

    @Before
    public void setUp() {
        geoService = new GeoServiceImpl();
    }

    @Test
    public void testLocationByIpMoscow() {
        Location result = geoService.byIp(GeoServiceImpl.MOSCOW_IP);
        assertEquals(Country.RUSSIA, result.getCountry());
        assertEquals("Moscow", result.getCity());
    }

    @Test
    public void testLocationByIpNewYork() {
        Location result = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        assertEquals(Country.USA, result.getCountry());
        assertEquals("New York", result.getCity());
    }
}

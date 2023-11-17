package ru.netology.sender;

import org.junit.Before;
import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {

    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSender messageSender;

    @Before
    public void setUp() {
        geoService = mock(GeoService.class);
        localizationService = mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void testSendRussianTextForRussianIp() {
        when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        String result = messageSender.send(Collections.singletonMap(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11"));

        assertEquals("Добро пожаловать", result);
    }

    @Test
    public void testSendEnglishTextForAmericanIp() {
        when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        String result = messageSender.send(Collections.singletonMap(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149"));

        assertEquals("Welcome", result);
    }
}

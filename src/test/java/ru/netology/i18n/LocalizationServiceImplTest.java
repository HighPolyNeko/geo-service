package ru.netology.i18n;

import org.junit.Before;
import org.junit.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationServiceImplTest {

    private LocalizationServiceImpl localizationService;

    @Before
    public void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    public void testLocaleRussian() {
        String result = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", result);
    }

    @Test
    public void testLocaleAmerican() {
        String result = localizationService.locale(Country.USA);
        assertEquals("Welcome", result);
    }
}

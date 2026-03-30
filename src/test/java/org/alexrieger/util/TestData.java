package org.alexrieger.util;

public final class TestData {

    public static final String BASE_URL = "http://opencart.abstracta.us/";
    public static final String ACTOR_NAME = "Shopper";
    public static final String PRODUCT_ONE = "MacBook";
    public static final String PRODUCT_TWO = "iPhone";
    public static final String EXPECTED_ORDER_SUCCESS = "Your order has been placed!";

    public static final String FIRST_NAME = "Alex";
    public static final String LAST_NAME = "Rieger";
    public static final String EMAIL_PREFIX = "guest";
    public static final String EMAIL_DOMAIN = "test.com";
    public static final String TELEPHONE = "07123456789";
    public static final String ADDRESS_1 = "221B Baker Street";
    public static final String CITY = "Bristol";
    public static final String POST_CODE = "BS1 4DJ";
    public static final String COUNTRY = "United Kingdom";
    public static final String REGION = "Bristol";

    private TestData() {
    }

    public static String guestEmail() {
        return EMAIL_PREFIX + System.currentTimeMillis() + "@" + EMAIL_DOMAIN;
    }
}

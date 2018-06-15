package ro.skyah.comparator;

import org.junit.Test;

public class JSONCompareModeTests {

    @Test
    public void compareJSONObjectNonExtensible() {
        String expected = "{\"a\":true}";
        String actual = "{\"a\":true}";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONObjectNonExtensible_negative() {
        String expected = "{\"a\":true}";
        String actual = "{\"a\":true,\"b\":false}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONArrayNonExtensible() {
        String expected = "[1,2,3]";
        String actual = "[1,2,3]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONArrayNonExtensible_negative() {
        String expected = "[1,2,3]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONArrayViaJSONObjectNonExtensibleMode() {
        String expected = "[2,{\"a\":true}]";
        String actual = "[1,2,3,4,{\"a\":true},{\"b\":false}]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONArrayViaJSONObjectNonExtensibleMode_negative() {
        String expected = "[2,{\"a\":true}]";
        String actual = "[1,2,3,4,{\"a\":true,\"b\":false}]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareEmptyJSONArrayViaStrictOrder() {
        String expected = "[]";
        String actual = "[1,2]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareEmptyJSONArrayViaStrictOrder_negative() {
        String expected = "[2]";
        String actual = "[]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareEmptyJSONArrayViaJSONArrayNonExtensible() {
        String expected = "[]";
        String actual = "[]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareEmptyJSONArrayViaJSONArrayNonExtensible_negative() {
        String expected = "[]";
        String actual = "[1,2]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONObjectViaJSONArrayNonExtensibleMode() {
        String expected = "{\"a\":true,\"b\":[2,4,5,6]}";
        String actual = "{\"a\":true,\"c\":\"text\",\"b\":[6,5,2,4]}";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareJSONObjectViaJSONArrayNonExtensibleMode_negative() {
        String expected = "{\"a\":true,\"b\":[2,4,5,6]}";
        String actual = "{\"a\":true,\"c\":\"text\",\"b\":[6,5,2,4,2018]}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareViaJSONArrayAndJSONObjectNonExtensibleModes() {
        String expected = "{\"a\":true,\"b\":[2,4,5,6]}";
        String actual = "{\"b\":[6,5,2,4],\"a\":true}";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE,
                CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareViaJSONArrayAndJSONObjectNonExtensibleModes_negative() {
        String expected = "{\"a\":true,\"b\":[2,4,5,6]}";
        String actual = "{\"b\":[6,5,2,4,8],\"a\":true,\"c\":2}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE,
                CompareMode.JSON_OBJECT_NON_EXTENSIBLE);
    }

    @Test
    public void compareViaDoNotUseRegexMode() {
        String expected = "{\"a\":\"\\\\d+\"}";
        String actual = "{\"a\":\"\\\\d+\"}";
        JSONCompare.assertEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareViaDoNotUseRegexMode_negative() {
        String expected = "{\"a\":\"\\\\d+\"}";
        String actual = "{\"a\":\"2\"}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareBooleanStringViaDoNotUseRegexMode() {
        String expected = "{\"a\":\"true\"}";
        String actual = "{\"a\":\"true\"}";
        JSONCompare.assertEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareBooleanStringViaDoNotUseRegexMode_negative() {
        String expected = "{\"a\":\"true\"}";
        String actual = "{\"a\":true}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareViaDoNotUseRegexModeOnJsonFields() {
        String expected = "{\"\\\\d+\":\"text\"}";
        String actual = "{\"\\\\d+\":\"text\"}";
        JSONCompare.assertEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareViaDoNotUseRegexModeOnJsonFields_negative() {
        String expected = "{\"\\\\d+\":\"text\"}";
        String actual = "{\"2\":\"text\"}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareViaDoNotUseRegexModeAndDoNotFindUseCase() {
        String expected = "{\"!\\\\d+\":\"text\"}";
        String actual = "{\"10\":\"text\"}";
        JSONCompare.assertEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareViaDoNotUseRegexModeAndDoNotFindUseCase_negative() {
        String expected = "{\"!\\\\d+\":\"text\"}";
        String actual = "{\"\\\\d+\":\"text\"}";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.DO_NOT_USE_REGEX);
    }

    @Test
    public void compareWithJsonArrayStrictOrderMode() {
        String expected = "[1,2,3]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareWithJsonArrayStrictOrderMode_negative() {
        String expected = "[1,3,2]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareWithJsonArrayStrictOrderAndNonExtensibleMode() {
        String expected = "[1,2,3]";
        String actual = "[1,2,3]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER,
                CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareWithJsonArrayStrictOrderAndNonExtensibleMode_negative() {
        String expected = "[1,2,3]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER,
                CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareWithJsonArrayStrictOrderModeAndDoNotFindUseCase() {
        String expected = "[1,2,\"!4\"]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareWithJsonArrayStrictOrderModeAndDoNotFindUseCase_negative() {
        String expected = "[1,2,\"!3\"]";
        String actual = "[1,2,3,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareArraysWithDuplicatedElementsAndStrictOrderMode() {
        String expected = "[2,2,4,4,4]";
        String actual = "[2,2,4,4,4,4]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareArraysWithDuplicatedElementsAndStrictOrderMode_negative() {
        String expected = "[2,4,4,4,4]";
        String actual = "[2,2,4,4,4,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_STRICT_ORDER);
    }

    @Test
    public void compareArraysWithDuplicatedElementsAndNonExtensibleMode() {
        String expected = "[2,2,4,4,2]";
        String actual = "[2,2,2,4,4]";
        JSONCompare.assertEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareArraysWithDuplicatedElementsAndNonExtensibleMode_negative() {
        String expected = "[2,2,4,4]";
        String actual = "[2,2,2,4,4]";
        JSONCompare.assertNotEquals(expected, actual, CompareMode.JSON_ARRAY_NON_EXTENSIBLE);
    }

    @Test
    public void compareFieldsViaCaseInsensitiveMode() {
        String expected = "{\"firstname\":\"text to match\"}";
        String actual = "{\"firstName\":\"text to match\"}";
        JSONCompare.assertEquals(expected, actual, CompareMode.CASE_INSENSITIVE);
    }

    @Test
    public void compareFieldsViaCaseInsensitiveMode_negative() {
        String expected = "{\"firstname\":\"text to match\"}";
        String actual = "{\"firstName\":\"text to match\"}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void compareValuesViaCaseInsensitiveMode() {
        String expected = "{\"a\":\"Text To Match\",\"b\":[\"Some Text\"]}";
        String actual = "{\"a\":\"text to match\",\"b\":[\"some text\"]}";
        JSONCompare.assertEquals(expected, actual, CompareMode.CASE_INSENSITIVE);
    }

    @Test
    public void compareValuesViaCaseInsensitiveMode_negative() {
        String expected = "{\"a\":\"Text To Match\",\"b\":[\"Some Text\"]}";
        String actual = "{\"a\":\"Text To Match\",\"b\":[\"some text\"]}";
        JSONCompare.assertNotEquals(expected, actual);
    }
}
package io.json.compare.matcher;

import io.json.compare.CompareMode;
import io.json.compare.JSONCompare;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONConvertibleObjectsCompareTests {

    @Test
    public void compareMaps() {
        String expected = "{\"a\":1,\"b\":[4,2,\"\\\\d+\"]}";
        Map<String, Object> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", Arrays.asList(1, 2, 3, 4));
        JSONCompare.assertMatches(expected, actual);
        JSONCompare.assertNotMatches(expected, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_ARRAY_STRICT_ORDER)));
        JSONCompare.assertNotMatches(expected, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_ARRAY_NON_EXTENSIBLE)));
        JSONCompare.assertMatches(expected, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_OBJECT_NON_EXTENSIBLE)));

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("a", "1");
        expectedMap.put("b", Arrays.asList(4, 2, "\\d+"));
        JSONCompare.assertMatches(expectedMap, actual);
        JSONCompare.assertNotMatches(expectedMap, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_ARRAY_STRICT_ORDER)));
        JSONCompare.assertNotMatches(expectedMap, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_ARRAY_NON_EXTENSIBLE)));
        JSONCompare.assertMatches(expectedMap, actual, new HashSet<>(Arrays.asList(CompareMode.JSON_OBJECT_NON_EXTENSIBLE)));
    }

    @Test
    public void checkJsonConversionErrorMessage() {
        String expected = "{\"a\":1,\"b\":[4,2,d]}";
        Map<String, Object> actual = new HashMap<>();
        actual.put("a", 1);
        RuntimeException e = assertThrows(RuntimeException.class, () -> JSONCompare.assertMatches(expected, actual));
        assertTrue(e.getMessage().contains("Invalid JSON"));
        assertTrue(e.getMessage().contains(expected));
        RuntimeException e1 = assertThrows(RuntimeException.class, () -> JSONCompare.assertMatches("{\"a\":1}", "{\"a:1}"));
        assertTrue(e1.getMessage().contains("Invalid JSON"));
        RuntimeException e2 = assertThrows(RuntimeException.class, () -> JSONCompare.assertNotMatches("{\"a\":1}", "{\"a:2}"));
        assertTrue(e2.getMessage().contains("Invalid JSON"));
    }
}

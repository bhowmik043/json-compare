package io.json.compare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToolExecution {

    public static void main(String[] args) throws IOException {
    //    String expectedString =
    //        "{\n"
    //            + "  \"a\": 1,\n"
    //            + "  \"b\": [\n"
    //            + "    4,\n"
    //            + "    \"ipsum\",\n"
    //            + "    {\n"
    //            + "      \"A\": \"a\",\n"
    //            + "      \"B\": \"b\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"c\",\n"
    //            + "      \"B\": \"d\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"e\",\n"
    //            + "      \"B\": \"f\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"g\",\n"
    //            + "      \"B\": \"h\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"i\",\n"
    //            + "      \"B\": \"j\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"k\",\n"
    //            + "      \"B\": \"l\"\n"
    //            + "    }\n"
    //            + "  ],\n"
    //            + "  \"c\": true\n"
    //            + "}";
    //    String actualString =
    //        "{\n"
    //            + "  \"a\": 1,\n"
    //            + "  \"b\": [\n"
    //            + "    \"ipsum\",\n"
    //            + "    {\n"
    //            + "      \"A\": \"c\",\n"
    //            + "      \"B\": \"d\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"a\",\n"
    //            + "      \"B\": \"b\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"e\",\n"
    //            + "      \"B\": \"f\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"i\",\n"
    //            + "      \"B\": \"m\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"g\",\n"
    //            + "      \"B\": \"h\"\n"
    //            + "    },\n"
    //            + "    {\n"
    //            + "      \"A\": \"k\",\n"
    //            + "      \"B\": \"l\"\n"
    //            + "    },\n"
    //            + "    4\n"
    //            + "  ],\n"
    //            + "  \"c\": true\n"
    //            + "}";

    String expectedString =
        "{\n"
            + "  \"k1\": \"v1\",\n"
            + "  \"a1\": [\n"
            + "    {\n"
            + "      \"id\": \"a1v1\",\n"
            + "      \"name\":\"john\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": \"a1v2\",\n"
            + "      \"name\":\"brad\",\n"
            + "      \"a1_1\": [\n"
            + "        {\n"
            + "          \"id\":\"a1_1v1\",\n"
            + "          \"location\": [\n"
            + "            \"blr\",\n"
            + "            \"chd\"\n"
            + "          ]\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
    String actualString =
        "{\n"
            + "  \"k1\": \"v1\",\n"
            + "  \"a1\": [\n"
            + "    {\n"
            + "      \"id\": \"a1v1\",\n"
            + "      \"name\":\"john\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": \"a1v2\",\n"
            + "      \"name\":\"brad\",\n"
            + "      \"a1_1\": [\n"
            + "        {\n"
            + "          \"id\":\"a1_1v1\",\n"
            + "          \"location\": [\n"
            + "            \"blr1\",\n"
            + "            \"chd\"\n"
            + "          ]\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
    Path jsonSchemaPath = Paths.get("/Users/bhowmik/Workspace/json-compare/src/main/resources/schema-1");
    Set<CompareMode> compareModes = new HashSet<>();
    compareModes.add(CompareMode.JSON_ARRAY_PRIMARY_KEY_CHECK);
        System.out.println(JSONCompare.diffs(expectedString, actualString, compareModes, jsonSchemaPath));



//        String expectedStringPath = "/Users/bhowmik/Workspace/reltio-product-editions/velocitypackhea_20231/1.1.0/BusinessConfig.json";
//        String actualStringPath = "/Users/bhowmik/Workspace/reltio-product-editions/velocitypackhea_20231/2.0.0/BusinessConfig.json";
//        String expectedString =new String(Files.readAllBytes(Paths.get(expectedStringPath)));
//        String actualString =new String(Files.readAllBytes(Paths.get(actualStringPath)));
//        System.out.println(JSONCompare.diffs(expectedString, actualString));
    }
}

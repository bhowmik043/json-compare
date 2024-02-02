package io.json.compare;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.json.compare.JSONCompare.readJsonFromFile;
import static io.json.compare.JSONCompare.writeDifferencesToFilePretty;

public class ToolExecution {

    public static void main(String[] args) throws IOException {
//        String expectedStringPath = "/Users/bhowmik/Workspace/reltio-product-editions/velocitypackhea_20231/1.1.0/BusinessConfig.json";
//        String actualStringPath = "/Users/bhowmik/Workspace/reltio-product-editions/velocitypackhea_20231/2.0.0/BusinessConfig.json";
//        Path jsonSchemaPath = Paths.get("/Users/bhowmik/Workspace/json-compare/src/main/resources/schema-3");

        String expectedStringPath = "/Users/bhowmik/Workspace/json-compare/src/main/resources/expectedJson-1.json";
        String actualStringPath = "/Users/bhowmik/Workspace/json-compare/src/main/resources/actualJson-1.json";
        Path jsonSchemaPath = Paths.get("/Users/bhowmik/Workspace/json-compare/src/main/resources/schema-1");


        String expectedString = readJsonFromFile(expectedStringPath);
        String actualString = readJsonFromFile(actualStringPath);
        Set<CompareMode> compareModes = new HashSet<>();
        compareModes.add(CompareMode.JSON_ARRAY_PRIMARY_KEY_CHECK);
        compareModes.add(CompareMode.REGEX_DISABLED);
        final int[] i = {1};
        JSONCompare.diffs(expectedString, actualString, compareModes, jsonSchemaPath)
                .forEach(
                        e ->
                                System.out.println(
                                        "###############\t-["+i[0]+++"]-\t###############\n " + e));

//        List<String> differences = JSONCompare.diffs(expectedString, actualString, compareModes, jsonSchemaPath);
//        writeDifferencesToFilePretty(differences, "/Users/bhowmik/Desktop/diff.txt");
    }
}

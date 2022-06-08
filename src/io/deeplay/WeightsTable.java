package io.deeplay;

import java.util.HashMap;

public class WeightsTable {

    private static WeightsTable instance = new WeightsTable();
    private HashMap<Character, HashMap<String, Integer>> weightsTable;

    private WeightsTable() {
        //S
        HashMap<String, Integer> swampMapping = new HashMap<>();
        swampMapping.put("Human", 5);
        swampMapping.put("Swamper", 2);
        swampMapping.put("Woodman", 3);

        //W
        HashMap<String, Integer> waterMapping = new HashMap<>();
        waterMapping.put("Human", 2);
        waterMapping.put("Swamper", 2);
        waterMapping.put("Woodman", 3);

        //T
        HashMap<String, Integer> treeMapping = new HashMap<>();
        treeMapping.put("Human", 3);
        treeMapping.put("Swamper", 5);
        treeMapping.put("Woodman", 2);

        //P
        HashMap<String, Integer> plainMapping = new HashMap<>();
        plainMapping.put("Human", 1);
        plainMapping.put("Swamper", 1);
        plainMapping.put("Woodman", 2);

        this.weightsTable = new HashMap<>();
        weightsTable.put('S', swampMapping);
        weightsTable.put('W', waterMapping);
        weightsTable.put('T', treeMapping);
        weightsTable.put('P', plainMapping);
    }

    public static Integer getWeight(String person, char field) throws Exception {
        try {
            return instance.weightsTable.get(field).get(person);
        } catch (Exception e) {
            throw new Exception("Введённое поле или персонаж не существует! " +
                    "Проверьте вводные данные и повторите попытку");
        }
    }
}
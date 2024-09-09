class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> equationMap = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        double[] result = new double[queries.size()];

        // generate equation graph
        for (List<String> equation : equations) {
            List<String> equationList = equationMap.getOrDefault(equation.get(0), new ArrayList<>());
            equationList.add(equation.get(1));
            equationMap.put(equation.get(0), equationList);

            List<String> equationList2 = equationMap.getOrDefault(equation.get(1), new ArrayList<>());
            equationList2.add(equation.get(0));
            equationMap.put(equation.get(1), equationList2);
        }

        // generate value graph
        for (int i = 0; i < equations.size(); i++) {
            valueMap.put(equations.get(i).get(0) + "." + equations.get(i).get(1), values[i]);
            valueMap.put(equations.get(i).get(1) + "." + equations.get(i).get(0), 1 / values[i]);
        }

        // dfs
        for (int i = 0; i < queries.size(); i++) {
            double value = dfs(equationMap, valueMap, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
            result[i] = value;
        }

        return result;
    }

    private double dfs(Map<String, List<String>> equationMap, Map<String, Double> valueMap, String start, String target, Set<String> visited) {
        if (!equationMap.containsKey(start)) return -1.0;
        if (start.equals(target)) return 1.0;

        List<String> equations = equationMap.get(start);
        for (String equation : equations) {
            if (equation.equals(target)) return valueMap.get(start + "." + target);

            if (!visited.contains(equation)) {
                visited.add(start);
                double value = dfs(equationMap, valueMap, equation, target, visited);
                if (value != -1.0) {
                    return valueMap.get(start + "." + equation) * value;
                }
            }
        }

        return -1.0;
    }
}
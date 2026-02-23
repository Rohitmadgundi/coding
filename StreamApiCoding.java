import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiCoding {

    public static char firstNonRepeatingCharacter(String str){

//        if (str == null)
//            return 'c';
        return str.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        )).entrySet().stream()
                .filter(e -> e.getValue().equals(1L))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static void findDuplicateCharactersInString(String str){

        str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

//        return null;
    }

    public static LinkedHashMap<String,Integer> sortMapByValue(Map<String,Integer> map){

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2) -> e1,
                        LinkedHashMap::new
                ));

    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("rohit",24);
        map.put("shivraj",52);
        map.put("mahesh",26);
        map.put("geeta",47);
        map.put("bhaskar",29);

//        LinkedHashMap<String,Integer> sortedMap = sortMapByValue(map);

//        System.out.println(sortedMap);

//        findDuplicateCharactersInString("aaaafrohitbbbcrea");
        System.out.println(firstNonRepeatingCharacter("aaaafrohitbbbcrea"));
    }

}

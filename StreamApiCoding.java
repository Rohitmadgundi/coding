import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiCoding {

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

        LinkedHashMap<String,Integer> sortedMap = sortMapByValue(map);

        System.out.println(sortedMap);
    }

}

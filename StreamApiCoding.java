import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiCoding {

    public static int findMax(List<Integer> list){
        return list.stream().mapToInt(i -> i).max().orElse(0);
    }

    public static int lengthOfLongestSubstring(String str){
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < str.length(); right++){
            char ch = str.charAt(right);
            if (map.containsKey(ch)){
                left = Math.max(left, map.get(ch));
            }

            map.put(ch,right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static Map<Character,Long> frequencyOfCharactersInAString(String str){
        //frequency of characters in a string by excluding spaces

        return str.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

    }

    public static Map<Integer,String> convertListToMap(List<Employee> emp){

        return emp.stream()
                .collect(Collectors.toMap(
                        Employee::getAge,
                        Employee::getFirstName
                ));
    }

    public static int getMaxFromArray(int[] arr){
        return Arrays.stream(arr)
                .max().orElse(-1);
    }

    public static Optional<String> findWordWithMaximumLength(String str){

        return Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length));
    }

    public static List<String> covertStringsToLowerCase(List<String> strings){
        return strings.stream()
                .map(String::toLowerCase)
                .toList();
    }

    public static Optional<Employee> getEmployeeByMaxAge(List<Employee> employees){

        return employees.stream()
                .filter(employee -> employee.getLastName() !=null )
                .max(Comparator.comparingInt(Employee::getAge));
    }

    public static List<Employee> sortEmployeesByLastName(List<Employee> employees){

        return employees.stream().filter(emp -> emp.getLastName() != null)
                .sorted(Comparator.comparing(Employee::getLastName)).toList();
    }

    public static Map<String,Long> frequencyOfWordsInAString(String str){
        return Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    public static Optional<Character> firstNonRepeatingCharacter(String str){

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
                .findFirst();
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

        List<String> list = Arrays.asList("Rohit", "MAHESH", "Bhaskar", "GEETA", "ShIVraj");

        String str = "aaa bbb a rohit rohit ccc ccc dd dd";

        System.out.println(frequencyOfCharactersInAString(str));

        //        Map<String,Integer> map = new HashMap<>();
////
//        map.put("rohit",24);
//        map.put("shivraj",52);
//        map.put("mahesh",26);
//        map.put("geeta",47);
//        map.put("bhaskar",29);

//        LinkedHashMap<String,Integer> sortedMap = sortMapByValue(map);
//
//        System.out.println(sortedMap);

//        findDuplicateCharactersInString("aaaafrohitbbbcrea");
//        System.out.println(firstNonRepeatingCharacter("aaaafrohitbbbcrea"));

//        System.out.println(frequencyOfWordsInAString(str));

//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee(111, "Jiya", "Brein", 32, "Female"));
//        employeeList.add(new Employee(122, "Paul", null, 25, "Male"));
//        employeeList.add(new Employee(133, "Liza", "Theron", 29, "Female"));
//        employeeList.add(new Employee(144, "Murali", null, 28, "Male"));

//        List<Employee> employees = sortEmployeesByLastName(employeeList);
//
//        System.out.println(employees);
//        for (Employee emp : employees){
//            System.out.println(emp);
//        }

//        getEmployeeByMaxAge(employeeList).ifPresent(System.out::println);

//        List<String> lowerCaseStrings = covertStringsToLowerCase(list);
//
//        System.out.println(lowerCaseStrings);

//        findWordWithMaximumLength(str).ifPresent(System.out::println);

//        System.out.println(getMaxFromArray(new int[]{3,5,6,8}));

//        convertListToMap(employeeList).entrySet().forEach(System.out::println);
//        convertListToMap(employeeList).forEach((k,v) -> System.out.println(k + " -> " + v));
    }

}

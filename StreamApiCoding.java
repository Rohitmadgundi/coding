import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiCoding {

    public static Employee getEmployeeByMaxAge(List<Employee> employees){

        return employees.stream()
                .filter(employee -> employee.getLastName() !=null )
                .max(Comparator.comparingInt(Employee::getAge)).get();
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

//        String str = "aaa bbb a rohit rohit ccc ccc dd dd";
//        Map<String,Integer> map = new HashMap<>();
//
//        map.put("rohit",24);
//        map.put("shivraj",52);
//        map.put("mahesh",26);
//        map.put("geeta",47);
//        map.put("bhaskar",29);

//        LinkedHashMap<String,Integer> sortedMap = sortMapByValue(map);

//        System.out.println(sortedMap);

//        findDuplicateCharactersInString("aaaafrohitbbbcrea");
//        System.out.println(firstNonRepeatingCharacter("aaaafrohitbbbcrea"));

//        System.out.println(frequencyOfWordsInAString(str));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya", "Brein", 32, "Female"));
        employeeList.add(new Employee(122, "Paul", null, 25, "Male"));
        employeeList.add(new Employee(133, "Liza", "Theron", 29, "Female"));
        employeeList.add(new Employee(144, "Murali", null, 28, "Male"));

//        List<Employee> employees = sortEmployeesByLastName(employeeList);
//
//        System.out.println(employees);
//        for (Employee emp : employees){
//            System.out.println(emp);
//        }

        System.out.println(getEmployeeByMaxAge(employeeList));

    }

}

package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployee {

    public static Map<String, List<Employee>> groupEmployees(Employee[] employees) {
        Map<String, List<Employee>> result = Arrays.stream(employees)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment));
        return result;
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1, "John", "IT"),
                new Employee(2, "Mike", "HR"),
                new Employee(3, "David", "Finance"),
                new Employee(4, "Sam", "IT")
        };

        System.out.println(groupEmployees(employees));

    }

}

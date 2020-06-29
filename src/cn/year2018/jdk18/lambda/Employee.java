package cn.year2018.jdk18.lambda;

public class Employee {
    private String name, city;
    private Integer salary, age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(String name, String city, Integer salary, Integer age) {
        super();
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", city=" + city + ", salary=" + salary + ", age=" + age + "]";
    }

}

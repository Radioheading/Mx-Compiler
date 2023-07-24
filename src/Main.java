import java.io.*;
public class Main{

    public static void main(String[] args){
        /* 使用构造器创建两个对象 */
        Employee empOne = new Employee("qweryy0566");
        Employee empTwo = new Employee("micemice");

        // 调用这两个对象的成员方法
        empOne.empAge(20);
        empOne.empDesignation("范神");
        empOne.empSalary(1000);
        empOne.printEmployee();

        empTwo.empAge(18);
        empTwo.empDesignation("鼠鼠");
        empTwo.empSalary(0);
        empTwo.printEmployee();
    }
}
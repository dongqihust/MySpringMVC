import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 95 on 2015/12/27.
 */
public class ListArray {

    public static void main(String[] args){

        List<Person> arrayList = new ArrayList<Person>();
        arrayList.add(new Person("dongqi"));
        arrayList.add(new Person("dongqi1"));
        arrayList.add(new Person("dongqi3"));


        Person[] persons = new Person[10];
        arrayList= Arrays.asList(persons);
        System.out.println(arrayList);
    }


}
class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
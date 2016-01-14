import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Created by 95 on 2015/12/27.
 */
public class GuavaJoinerTest {

    @Test
    public void testJoiner(){

        Joiner joiner = Joiner.on(";").skipNulls();
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("dong"));
        list.add(new Person("qi"));


        assertEquals(list.toArray().length, 1);
        assertFalse(2>5);
        assertEquals(joiner.join(list), "dong;qi");

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
            return name;
        }
    }
}

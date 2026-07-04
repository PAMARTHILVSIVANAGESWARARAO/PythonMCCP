import java.util.ArrayList;


/**
 * InnerTrieUsingHashMap
 */
public class Student {

    private String name;
    private Integer rank;

    Student(String name, Integer rank){

        this.name = name ;
        this.rank = rank ;

    }
}
public class TrieUsingHashMap {
   
    ArrayList<Student> al = new ArrayList<>();
    Student obj = new Student("Siva", 10);
    al.add(obj);
    
}

package sorting;

public class Student implements Comparable<Student> {
    int id;
    String name;
    int rank;

    public Student(int id , String name , int rank){
        this.id = id;
        this.name = name;
        this.rank = rank;
    }
    @Override
    public int compareTo(Student s) {
//        return this.id - s.id;   // Sorting on the basis of id
//        return this.name.compareTo(s.name); // Sorting on the basis of name as name is String , which is a predefined class which implements comparable so directly use compareTo method with this
        return this.rank - s.rank; // Sorting as per rank of the object
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }

}

package service;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceIplm implements StudentService {
    private static final Map<Integer, Student> studentMap = new HashMap<>();

    static {
        studentMap.put(1, new Student(1, "Uy", 9, 4, 8));
        studentMap.put(2, new Student(1, "Uy", 8, 5, 10));
        studentMap.put(3, new Student(1, "Uy", 7, 6, 9));
        studentMap.put(4, new Student(1, "Uy", 6, 7, 7));
        studentMap.put(5, new Student(1, "Uy", 5, 8, 6));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void delete(int id) {
        studentMap.remove(id);
    }

    @Override
    public void update(int id, Student student) {
        studentMap.put(id, student);
    }
}

package Temp.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    HashMap<Integer,Student> map = new HashMap<>();

    @PostMapping("/registerStudent")
    public void addStudent(@RequestBody Student student){
        int key =student.getRollNo();

        map.put(key,student);
        System.out.println("Hasbeen addedd");

    }

    @GetMapping("/GetStudentInfo")
    public Student getStudentInfo(@RequestParam("rollNo")Integer rollNo){
        Student student=map.get(rollNo);
        return student;

    }

    @GetMapping("/GetAllStudent")
    public List<Student> GetAllStudent(){
        List<Student> result =new ArrayList<>();

        for(Student student :map.values()){
            result.add(student);
        }

        return result ;

    }

    @DeleteMapping("/DeleteData")
    public void DeleteData(@RequestParam("rollNo")Integer rollNo){
       // map.remove(rollNo);
        boolean flag1 =false;

        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            int  key = entry.getKey();
            Student student = entry.getValue();

            if(key==rollNo){


                flag1=true;
            }
            // Process the key-value pair (rollNo, student)
        }

        if(flag1==true)map.remove(rollNo);
        else System.out.println("Wrong key");




    }

    @PutMapping("/UpdateData")
    public void UpdateData(@RequestParam("rollNo")Integer rollNo,@RequestBody Student student){
       if(map.containsKey(rollNo)){
           map.put(rollNo,student);
       }


    }

    @GetMapping("/GetAllRollNumbers")
    public List<Integer> getAllRollNumbers() {
        return new ArrayList<>(map.keySet());
    }

    @GetMapping("/GetStudentCount")
    public int getStudentCount() {
        return map.size();
    }

    @DeleteMapping("/ClearAllData")
    public ResponseEntity<String> clearAllData() {
        map.clear();
        return ResponseEntity.ok("All student data cleared successfully");
    }

}

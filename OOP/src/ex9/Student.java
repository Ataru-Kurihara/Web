package ex9;

public class Student {
    private String studentNumber;
    private String name;
    private String address;
    private String tel;

    public static void main(String args[]) {
        Student student = new Student("10","taro","tokyo","000");
        System.out.println(student);
    }
    public Student(String studentNumber,String name,String address,String tel) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }
        public String getStudentNumber() {
            return studentNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            
        }
        
        public String getTel() {
            return tel;
        }
        
        public void setTel(String tel) {
            
        }
        
        public String toString() {
            return "a Student(学籍番号"+studentNumber+","+"氏名"+name+","+"住所"+address+","+"電話番号"+ tel+")"; 
        }
        
    }




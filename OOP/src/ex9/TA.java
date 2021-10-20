package ex9;

public class TA extends Student{
    private String subject;
    private String extension;

    public static void main(String args[]) {

        TA ta = new TA("20","takuma","kyoto","111","math","000");
        System.out.println(ta);
    }

    public TA(String studentNumber, String name, String address, String tel,String subject,String extension) {
        super(studentNumber, name, address, tel);
        this.extension = extension;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        
    }
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        
    }
    public String toString() {
    	return "a TA(学籍番号"+getStudentNumber()+","+"氏名"+getName()+","+"住所"+getAddress()+","+"電話番号"+ getTel()+","+"担当科目"+subject+","+"内線番号"+extension+")";
    }

}

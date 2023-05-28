public class Student {
    private String studentName; // variable for student's name
    private String studentID; // variable for student's ID
    private int credits; // variable for student's credits
    
    // Constructor for creating a new Student object
    public Student(String name, String id, int credits) {
        this.studentName = name;
        this.studentID = id;
        this.credits = credits;
    }
    
    // Getter method for retrieving student's name
    public String getName() {
        return studentName;
    }
    
    // Getter method for retrieving student's ID
    public String getstudentID() {
        return studentID;
    }
    
    // Getter method for retrieving student's credits
    public int getCredits() {
        return credits;
    }
    
    // Method for generating a short form of the student's name and ID
    public String getLgName() {
        String lgName = "";
        if (studentName.length() >= 4) { // if student's name has 4 or more characters
            lgName = studentName.substring(0, 4); // take the first 4 characters of the name
        } else {
            lgName = studentName; // otherwise, use the entire name
        }
        lgName += studentID.substring(0, 3); // add the first 3 characters of the student's ID to the name
        return lgName; // return the short form of the student's name and ID
    }
}


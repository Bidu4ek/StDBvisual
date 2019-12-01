package Classes;

public class Structure {

    public int[] getAssessment() {
        return assessment;
    }

    public void setAssessment(int[] assessment) {
        this.assessment = assessment;
    }

    int[] assessment = new int[4];

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    String[] subject = new String[4];

    public String[] getLecturer() {
        return lecturer;
    }

    public void setLecturer(String[] lecturer) {
        this.lecturer = lecturer;
    }

    String[] lecturer = new String[4];
}

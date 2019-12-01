package Classes;

import java.util.ArrayList;

    public class StudentDB extends Student {


        public ArrayList<Student> getList(){
            return list;
        }

        private ArrayList<Student> list = new ArrayList<>();

        public ArrayList add(Student student){

            if(!isInList(student.numberRecord)){
                this.list.add(student);
                return getList();
            }
            return null;
        }

        public StudentDB(){
            this.list = new ArrayList<>();
        }

        public  StudentDB(int length){
            this.list = new ArrayList<>(length);
        }

        public boolean isInList(String numZ){
            for(Student student:this.list){
                if(numZ.equals(student.getNumberRecord()))
                    return true;
            }
            return false;
        }

    }

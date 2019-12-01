package Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class FileHandler {
//
//public void writeF(String nameFile, StudentDB sDB) throws IOException {
//    FileWriter fW = new FileWriter(nameFile + "(1).txt");
//    Iterator<Student> stIterator = sDB.student.iterator();
//    while (stIterator.hasNext()){
//        Student nextSt = stIterator.next();
//        String suLeAs;
//
//        suLeAs = nextSt.structure.subject[0];
//        suLeAs += "\r\n";
//        suLeAs += nextSt.structure.lecturer[0];
//
//        suLeAs += "\r\n";
//        suLeAs += Integer.toString(nextSt.structure.assessment[0]);
//
//        if(nextSt.structure.subject[1]!=null){
//            suLeAs += nextSt.structure.subject[1];
//            suLeAs += "\r\n";
//            suLeAs += nextSt.structure.lecturer[1];
//
//            suLeAs += "\r\n";
//            suLeAs += Integer.toString(nextSt.structure.assessment[1]);
//            if(nextSt.structure.subject[2]!=null){
//                suLeAs += nextSt.structure.subject[2];
//                suLeAs += "\r\n";
//                suLeAs += nextSt.structure.lecturer[2];
//
//                suLeAs += "\r\n";
//                suLeAs += Integer.toString(nextSt.structure.assessment[2]);
//                if(nextSt.structure.subject[3]!=null){
//                    suLeAs += nextSt.structure.subject[3];
//                    suLeAs += "\r\n";
//                    suLeAs += nextSt.structure.lecturer[3];
//
//                    suLeAs += "\r\n";
//                    suLeAs += Integer.toString(nextSt.structure.assessment[3]);
//                }
//            }
//        }
//
//        fW.write(nextSt.getName()+"\r\n"+nextSt.getFaculty()+"\r\n"+Integer.toString(nextSt.getCourse())+"\r\n"
//        + nextSt.getNumberRecord() + "\r\n" + suLeAs + "\r\n@\r\n");
//    }
//    fW.close();
//}

}

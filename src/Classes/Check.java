package Classes;

public class Check {
    public boolean isCorrect;
    public boolean numIsCorrect(String number) {
        try {
            Integer.parseInt(number);
            if(Integer.parseInt(number)<0)
                isCorrect = false;
            else
                isCorrect = true;
        } catch (IllegalArgumentException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public boolean cursIsCorrect(String number) {
        try {
            Integer.parseInt(number);
            if(Integer.parseInt(number)<0 || Integer.parseInt(number)>6)
                isCorrect = false;
            else
                isCorrect = true;
        } catch (IllegalArgumentException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public boolean assIsCorrect(String number) {
        try {
            Integer.parseInt(number);
            if(Integer.parseInt(number)<0 || Integer.parseInt(number)>5)
                isCorrect = false;
            else
                isCorrect = true;
        } catch (IllegalArgumentException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public  String status(int assessment){
        if(assessment<=2)
            return "badly";
        else if(assessment == 5)
            return "perfect";
        else
            return "good";
    }
}

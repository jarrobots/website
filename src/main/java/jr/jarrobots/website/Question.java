package jr.jarrobots.website;

import java.util.*;


public class Question {
    private final String name;
    private final String group;
    private final ArrayList<String> answers;




    public Question( String group, String name, ArrayList<String> answers) {
        this.answers = answers;
        this.group = group;
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }
    public ArrayList<String> getAnswers(){
        return answers;
    }
}

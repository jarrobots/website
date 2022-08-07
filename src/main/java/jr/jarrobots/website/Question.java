package jr.jarrobots.website;

import java.util.*;


public class Question {
    private String name;
    private String group;
    private ArrayList<String> answers;

    public Question( String group, String name, ArrayList<String> answers ) {
        this.answers = answers;
        this.group = group;
        this.name = name;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }
}

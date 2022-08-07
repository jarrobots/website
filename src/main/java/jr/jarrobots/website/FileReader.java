package jr.jarrobots.website;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    File file;
    private final Scanner scanner;

    public FileReader(String url) throws FileNotFoundException
    {
        file = new File(url);
        scanner = new Scanner(file);

    }
    public ArrayList<Question> getQuestions()
    {
        String group;
        String quest;
        ArrayList<String> ans =new ArrayList<>();
        ArrayList<Question> QuestionList = new ArrayList<>();
        while(scanner.hasNextLine()){
            String[] string = scanner.nextLine().split(";");
            group = string[0];
            quest = string[1];
            ans.addAll(Arrays.asList(string).subList(2, string.length));
            Question question = new Question(group, quest, ans);
            QuestionList.add(question);
        }
        return QuestionList;
    }
    @Override
    public void finalize(){
        scanner.close();
    }

}
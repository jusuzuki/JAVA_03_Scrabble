import java.io.Console;
import java.util.Arrays;
import java.util.List;
import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class Scrabble {
    public static void main(String[] args) {
        String layout = "templates/layout.vtl";
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/scrabbler", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/scrabbler.vtl");

            String scrabbleWord = request.queryParams("scrabbler");
            Integer scoreCount = scoreCount(scrabbleWord);

            model.put("scrabbler", request.queryParams("scrabbler"));
            model.put("scoreCount", scoreCount);
            return new ModelAndView(model, layout);}
            , new VelocityTemplateEngine());

        //Console myConsole=System.console();

        //System.out.println("What is your Scrabble word?");
        //String scrabbleWord = myConsole.readLine();
        //scoreCount(scrabbleWord);




        }


    public static Integer scoreCount(String scrabbleWord) {

        Integer totalScore = 0;



        char[] scrabbleChar = scrabbleWord.toLowerCase().toCharArray();

        Character [] arrayLetter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Integer[] arrayValue = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

        for(Integer index=0; index<scrabbleWord.length(); index++){

            Integer findLetter = Arrays.asList(arrayLetter).indexOf(scrabbleChar[index]);

            Integer findValue = arrayValue[findLetter];


            totalScore = totalScore + findValue;

            }

        return totalScore;


    }
}

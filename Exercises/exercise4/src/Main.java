import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String[] patterns = {
                "W[0-9]S",
                "h{3}",
                "[a-z](\\d)",
                "[$&+,:;=\\\\\\\\?@#|/'<>.^*()%!-]",
                "^(.+)@(\\S+)$"
        };
        String[] positive_matchers = {
                "Visit W3School",
                "It is super good hhhhhh I love it!",
                "northeastern2023",
                "hope_it_is_strong_password_with_^*&",
                "luna.yumiki@gmail.com"
        };
        String[] negative_matchers = {
                "Visit W2023School",
                "It is super good I love it!",
                "2023sanjose",
                "hope_it_is_strong_password_with_abc123",
                "luna.yumiki$at$gmail.com"
        };
        for(int i=0;i<patterns.length;i++){
            System.out.println("---  running regular expression test  ---");
            System.out.println("pattern: "+ patterns[i] + " and matcher: "+ positive_matchers[i]);
            regexTest(patterns[i], positive_matchers[i]);
        }
        for(int i=0;i<patterns.length;i++){
            System.out.println("---  running regular expression test  ---");
            System.out.println("pattern: "+ patterns[i] + " and matcher: "+ negative_matchers[i]);
            regexTest(patterns[i], negative_matchers[i]);
        }
    }

    public static boolean regexTest(String str_a, String str_b){
        Pattern pattern = Pattern.compile(str_a, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str_b);
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
            System.out.println("Pattern found from position " + matcher.start() +
                    " to " + (matcher.end()-1));
            System.out.println(str_b.substring(matcher.start(), matcher.end()));
        } else {
            System.out.println("Match not found");
        }
        return matchFound;
    }
}
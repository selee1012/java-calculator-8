package calculator;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inp = sc.nextLine();
        inp = inp.trim();

        if (inp.length() == 0)
            System.out.println("결과 : 0");
        else{
            List<Character> target = new ArrayList<>(Arrays.asList(',', ':'));
            if (inp.length() >= 5) {
                if ((inp.charAt(0) == '/') && (inp.charAt(1) == '/') && (inp.charAt(3) == '\\') && (inp.charAt(4) == 'n')) {
                    target.add(inp.charAt(2));
                    inp = inp.substring(5);
                }
            }

            for (Character c : target) {
                inp = inp.replace(c.toString(), ",");
            }

            String[] result = inp.split(",");

            int count = 0;
            try {
                for (int i=0; i<result.length; i++) {
                    count += Integer.parseInt(result[i]);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }

            System.out.println("결과 : " + count);
        }
        sc.close();
    }
}

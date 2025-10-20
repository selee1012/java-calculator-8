package calculator;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inp = sc.nextLine();
        List<Character> target = new ArrayList<>(Arrays.asList(',', ':'));
        if (inp.startsWith("//")) {
            int nl = inp.indexOf('\n');     // 실제 개행 문자
            if (nl > 2) {
                target.add(inp.charAt(2));
                inp = inp.substring(nl + 1);
            }
        }

        for (Character c : target) {
             inp = inp.replace(c.toString(), " ");
        }

        String[] result = inp.split(" ");

        int count = 0;
        try {
            for (int i=0; i<result.length; i++) {
                count += Integer.parseInt(result[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }

        System.out.println("결과 : " + count);
        sc.close();
    }
}

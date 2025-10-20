package calculator;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inp = sc.nextLine();

        // 빈 문자열 → 0
        if (inp == null || inp.trim().isEmpty()) {
            System.out.println("결과 : 0");
            sc.close();
            return;
        }

        List<Character> target = new ArrayList<>(Arrays.asList(',', ':'));

        // 커스텀 구분자 처리: //x\n...
        if (inp.startsWith("//")) {
            int nl = inp.indexOf('\n');  // 실제 개행 문자
            if (nl < 3) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
            target.add(inp.charAt(2));
            inp = inp.substring(nl + 1);
        }

        // 구분자를 공백으로 통일
        for (Character c : target) {
            inp = inp.replace(String.valueOf(c), " ");
        }

        inp = inp.trim();
        if (inp.isEmpty()) {
            System.out.println("결과 : 0");
            sc.close();
            return;
        }

        String[] result = inp.split("\\s+");
        int sum = 0;

        try {
            for (String token : result) {
                sum += Integer.parseInt(token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }

        // 출력 형식 유지
        System.out.println("결과 : " + sum);
        sc.close();
    }
}

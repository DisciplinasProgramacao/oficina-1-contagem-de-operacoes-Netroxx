package src;

import java.util.*;

public class Futebol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] skills = new int[n];

        for (int i = 0; i < n; i++) {
            skills[i] = scanner.nextInt();
        }

        Arrays.sort(skills);

        int maxTeamSize = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            while (skills[end] - skills[start] > 5) {
                start++;
            }
            maxTeamSize = Math.max(maxTeamSize, end - start + 1);
        }

        System.out.println(maxTeamSize);
    }
}

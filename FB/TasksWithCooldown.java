package FB;

import java.util.HashMap;

public class TasksWithCooldown {
	public static String coolDown(int[] tasks, int cooldown) {
        StringBuilder res = new StringBuilder();
        if (tasks == null || tasks.length == 0) {
            return res.toString();
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j = 0;
        for(int i = 0; i < tasks.length; i++) {
            while (map.containsKey(tasks[i]) && map.get(tasks[i]) + cooldown >= j) {
                res.append("_");
                j++;
            }
            res.append(tasks[i] + "");
            map.put(tasks[i], j);
            j++;
        }
        return res.toString();
    }
	
	public static void main(String[] args){
		int[] tasks = { 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4};
		System.out.println(coolDown(tasks, 6));
	}
}

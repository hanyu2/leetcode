package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	//http://www.jianshu.com/p/38b54e28dfe2
	public static List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if (tickets.length == 0) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<String, List<String>>();

        for (int i = 0; i < tickets.length; i++) {
            if (graph.get(tickets[i][0]) == null) {
                graph.put(tickets[i][0], new ArrayList<String>());
            }
            List<String> list = graph.get(tickets[i][0]);
            list.add(tickets[i][1]);
            if (graph.get(tickets[i][1]) == null) {
                graph.put(tickets[i][1], new ArrayList<String>());
            }
        }

        for (Map.Entry<String, List<String>> entry: graph.entrySet()) {
            Collections.sort(entry.getValue(), Collections.reverseOrder());
        }

        result.add("JFK");
        List<String> list = graph.get("JFK");
        int index = 1;
        while (tickets.length + 1 > result.size()) {
            List<String> tmp = new ArrayList<String>();
            while(list.size() > 0) {
                String next = list.get(list.size() - 1);
                tmp.add(next);
                list.remove(list.size() - 1);
                list = graph.get(next);
            }

            result.addAll(index, tmp);

            for (int i = result.size() -1; i >= 0; i--) {
                if (graph.get(result.get(i)).size() > 0) {
                    list = graph.get(result.get(i));
                    index = i + 1;
                    break;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		//String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		System.out.println(findItinerary(tickets));
	}
}

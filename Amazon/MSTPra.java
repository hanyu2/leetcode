package Amazon;
import java.util.*;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;
class ConnectionPra {
	String node1;
	String node2;
	int cost;

	public ConnectionPra(String a, String b, int c) {
		node1 = a;
		node2 = b;
		cost = c;
	}
}
public class MSTPra {
	public static List<ConnectionPra> getLowCost(ArrayList<ConnectionPra> connections) {
		if(connections.size() == 0){
			return null;
		}
		Collections.sort(connections, new Comparator<ConnectionPra>(){
			public int compare(ConnectionPra c1, ConnectionPra c2){
				return c1.cost - c2.cost;
			}
		});
		Set<String> set = new HashSet<String>();
		Map<String, String> map = new HashMap<String, String>();
		for(ConnectionPra c : connections){
			String cityA = c.node1;
			String cityB = c.node2;
			set.add(cityA);
			set.add(cityB);
			map.put(cityA, cityA);
			map.put(cityB, cityB);
		}
		List<ConnectionPra> res = new ArrayList<ConnectionPra>();
		for(ConnectionPra c : connections){
			if(union(c.node1, c.node2, map)){
				res.add(c);
			}
		}
		if(set.size() - 1 != res.size()){
			return null;
		}
		Collections.sort(res, new Comparator<ConnectionPra>(){
			public int compare(ConnectionPra c1, ConnectionPra c2){
				if(c1.node1.equals(c2.node1)){
					return c1.node2.compareTo(c2.node2);
				}
				return c1.node1.compareTo(c2.node1);
			}
		});
		return res;
	}
	
	public static boolean union(String n1, String n2, Map<String, String> map){
		String cityA = find(n1, map);
		String cityB = find(n2, map);
		if(cityA.equals(cityB)){
			return false;
		}
		map.put(cityB, cityA);
		return true;
	}
	
	public static String find(String s, Map<String, String> map){
		if(s.equals(map.get(s))){
			return s;
		}
		String parent = find(map.get(s), map);
		return  parent;
	}
	
	public static void main(String[] args) {
		ArrayList<ConnectionPra> connections = new ArrayList<>();
		// 这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
		connections.add(new ConnectionPra("A", "B", 6));
		connections.add(new ConnectionPra("B", "C", 4));
		connections.add(new ConnectionPra("C", "D", 5));
		connections.add(new ConnectionPra("D", "E", 8));
		connections.add(new ConnectionPra("E", "F", 1));
		connections.add(new ConnectionPra("B", "F", 10));
		connections.add(new ConnectionPra("E", "C", 9));
		connections.add(new ConnectionPra("F", "C", 7));
		connections.add(new ConnectionPra("B", "E", 3));
		connections.add(new ConnectionPra("A", "F", 1));

		List<ConnectionPra> res = getLowCost(connections);
		for (ConnectionPra c : res) {
			System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
		}
	}
}

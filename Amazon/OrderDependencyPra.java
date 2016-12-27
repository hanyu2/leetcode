package Amazon;

import java.util.*;


class OrderPra {
	String orderName;

	public OrderPra(String string) {
		this.orderName = string;
	}
}

public class OrderDependencyPra {
	OrderPra cur;
	OrderPra pre;

	public OrderDependencyPra(OrderPra pre, OrderPra cur) {
		this.pre = pre;
		this.cur = cur;
	}

	public static List<OrderPra> solution(List<OrderDependencyPra> orderDependencies) {
		if(orderDependencies.size() == 0){
			return new ArrayList<OrderPra>();
		}
		Map<String, Integer> inMap = new HashMap<String, Integer>();
		Map<String, List<String>> outMap = new HashMap<String, List<String>>();
		Map<String, OrderPra> map = new HashMap<String, OrderPra>();
		Set<String> set = new HashSet<String>();
		for(OrderDependencyPra order : orderDependencies){
			OrderPra pre = order.pre;
			OrderPra cur = order.cur;
			String preName = pre.orderName;
			String curName = cur.orderName;
			set.add(preName);
			set.add(curName);
			if(!map.containsKey(preName)){
				map.put(preName, pre);
			}
			if(!map.containsKey(curName)){
				map.put(curName, cur);
			}
			if(!inMap.containsKey(curName)){
				inMap.put(curName, 1);
			}else{
				inMap.put(curName, inMap.get(curName) + 1);
			}
			if(!inMap.containsKey(preName)){
				inMap.put(preName, 0);
			}
			List<String> temp = new ArrayList<String>();
			if(outMap.containsKey(preName)){
				temp = outMap.get(preName);
			}
			temp.add(curName);
			outMap.put(preName, temp);
			if(!outMap.containsKey(curName)){
				outMap.put(curName, new ArrayList<String>());
			}
		}
		Queue<String> q = new LinkedList<String>();
		for(String s : inMap.keySet()){
			if(inMap.get(s) == 0){
				q.offer(s);
			}
		}
		List<OrderPra> res = new ArrayList<OrderPra>();
		while(!q.isEmpty()){
			String top = q.poll();
			res.add(map.get(top));
			List<String> outs = outMap.get(top);
			for(String next :  outs){
				inMap.put(next, inMap.get(next) - 1);
				if(inMap.get(next) == 0){
					q.offer(next);
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		OrderPra o1 = new OrderPra("泡面");
		OrderPra o2 = new OrderPra("泡面");
		OrderPra o3 = new OrderPra("SF");
		OrderPra o4 = new OrderPra("租车");
		OrderPra o5 = new OrderPra("SF");
		OrderPra o6 = new OrderPra("泡面");
		OrderPra o7 = new OrderPra("租车");
		OrderPra o8 = new OrderPra("SF");
		OrderPra o9 = new OrderPra("爽(每个行为只输出了一次对吧)");
		OrderDependencyPra od1 = new OrderDependencyPra(o1, o3);
		OrderDependencyPra od2 = new OrderDependencyPra(o2, o7);
		OrderDependencyPra od3 = new OrderDependencyPra(o3, o9);
		OrderDependencyPra od4 = new OrderDependencyPra(o4, o3);
		OrderDependencyPra od5 = new OrderDependencyPra(o6, o9);
		OrderDependencyPra od6 = new OrderDependencyPra(o8, o9);
		OrderDependencyPra od7 = new OrderDependencyPra(o2, o5);

		List<OrderDependencyPra> list = new ArrayList<>();
		list.add(od1);
		list.add(od2);
		list.add(od3);
		list.add(od4);
		list.add(od5);
		list.add(od6);
		list.add(od7);
		// 最后输出就是这种形式
		List<OrderPra> res = solution(list);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).orderName);
			if (i + 1 < res.size()) {
				System.out.print(" -> ");
			}
		}
	}
}

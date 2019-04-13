package L26_April13;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Apr-2019
 *
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);

		for (String key : vtx.nbrs.keySet()) {
			vtces.get(key).nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		int size = 0;

		for (String key : vtces.keySet()) {

			Vertex vtx = vtces.get(key);
			size += vtx.nbrs.size();

		}

		return size / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("----------------------");

		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " -> " + vtx.nbrs);
		}

		System.out.println("----------------------");
	}

	@Override
	public String toString() {

		String str = "----------------------\n";

		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			str += key + " -> " + vtx.nbrs;
			str += "\n";
		}

		str += "----------------------";

		return str;
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed, String str) {

		if (processed.containsKey(src)) {
			return false;
		}

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			System.out.println(str + dst);
			return true;
		}

		for (String nbr : vtces.get(src).nbrs.keySet()) {

			if (hasPath(nbr, dst, processed, str + nbr)) {
				return true;
			}
		}

		return false;

	}

	public void printAllPaths(String src, String dst, HashMap<String, Boolean> processed, String asf) {

		if (src.equals(dst)) {
			System.out.println(asf);
			return;
		}

		processed.put(src, true);

		for (String nbr : vtces.get(src).nbrs.keySet()) {

			if (!processed.containsKey(nbr))
				printAllPaths(nbr, dst, processed, asf + nbr);
		}

		processed.remove(src);

	}

	private class Pair {
		String vname;
		String psf;
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// 1. create a new pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		queue.addLast(sp);

		// 2. work till queue is not empty
		while (!queue.isEmpty()) {

			// 2.1 remove the pair
			Pair rp = queue.removeFirst();

			// 2.2 ignore the second C
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 2.3 processed
			processed.put(rp.vname, true);

			// 2.4 direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.5 process only unprocessed nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// 1. create a new pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		stack.addFirst(sp);

		// 2. work till queue is not empty
		while (!stack.isEmpty()) {

			// 2.1 remove the pair
			Pair rp = stack.removeFirst();

			// 2.2 ignore the second C
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 2.3 processed
			processed.put(rp.vname, true);

			// 2.4 direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 2.5 process only unprocessed nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			queue.addLast(sp);

			// 2. work till queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 remove the pair
				Pair rp = queue.removeFirst();

				// 2.2 ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.3 processed
				processed.put(rp.vname, true);

				// 2.4 syso
				System.out.println(rp.vname + " via " + rp.psf);

				// 2.5 process only unprocessed nbrs
				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. create a new pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			stack.addFirst(sp);

			// 2. work till queue is not empty
			while (!stack.isEmpty()) {

				// 2.1 remove the pair
				Pair rp = stack.removeFirst();

				// 2.2 ignore the second C
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 2.3 processed
				processed.put(rp.vname, true);

				// 2.4 syso
				System.out.println(rp.vname + " via " + rp.psf);

				// 2.5 process only unprocessed nbrs
				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}

	}

}

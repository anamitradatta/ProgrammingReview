package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class testGraph 
{
	
	public static class Vertex
	{
		private String name;
		private ArrayList<Edge> edges;
		
		public Vertex(String n)
		{
			name=n;
			edges= new ArrayList<Edge>();
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String n)
		{
			name=n;
		}
		
		public void addEdge(Vertex to, int weight)
		{
			edges.add(new Edge(this, to, weight));
		}
		
		public void removeEdge(Vertex to)
		{
			Edge edgeToRemove=null;
			for(Edge e: edges)
			{
				if(e.getTo()==to && e.getFrom()==this)
				{
					edgeToRemove=e;
				}
			}
			if(edgeToRemove==null)
			{
				System.out.println("Edge from " + this.getName() + " to " + to.getName() + " does not exist");
			}
			else
			{
			    edges.remove(edgeToRemove);
			}
		}
		
		public ArrayList<Edge> getEdges()
		{
			return edges;
		}
		
		public void printEdges()
		{
			if(edges.size()==0)
			{
				System.out.println("Vertex " + name + " has no edges");
			}
			else
			{
				for(Edge e: edges)
				{
					System.out.println("(" + e.getFrom().getName() + ") -> (" + e.getTo().getName() + ")");
				}
			}
		}
		
		public int getNumEdges()
		{
			return edges.size();
		}
		
	}
	
	public static class Edge
	{
		private final Vertex from;
		private final Vertex to;
		private int weight;
		
		public Edge(Vertex f, Vertex t)
		{
			from=f;
			to=t;
			weight=1;
		}
		
		public Edge(Vertex f, Vertex t, int w)
		{
			from=f;
			to=t;
			weight=w;
		}
		
		public Vertex getFrom()
		{
			return from;
		}
		
		public Vertex getTo()
		{
			return to;
		}
		
		public int getWeight()
		{
			return weight;
		}
		
		public void setWeight(int w)
		{
			weight=w;
		}
		
	}
	
	private static int numVertices;
	private static ArrayList<Vertex> graph;
	boolean isUndirected;
	
	public testGraph()
	{
		numVertices=0;
		graph=new ArrayList<Vertex>();
		isUndirected=false;
	}
	
	public testGraph(boolean isUd)
	{
		numVertices=0;
		graph=new ArrayList<Vertex>();
		isUndirected=isUd;
	}
	
	public int getNumVertices()
	{
		return numVertices;
	}
	
	public ArrayList<Vertex> getGraph()
	{
		return graph;
	}
	
	public ArrayList<Edge> getEdges()
	{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		if(numVertices!=0)
		{
			for(Vertex v: graph)
			{
				ArrayList<Edge> vEdges = v.getEdges();
				edges.addAll(vEdges);
			}
			return edges;
		}
		else
		{
			return null;
		}
	}
	
	public void addVertex(Vertex v)
	{
		for(Vertex x: graph)
		{
			if(x.getName().equals(v.getName()))
			{
				System.out.println("vertex "+ v.getName() + " already exists in graph");
				return;
			}
		}
		graph.add(v);
		numVertices++;
	}
	
	public void removeVertex(Vertex v)
	{
		if (graph.remove(v)) numVertices--;
	}
	
	public void addEdge(Vertex v1, Vertex v2, int weight)
	{
		if(!graph.contains(v1))
		{
			System.out.println("v1 " + v1.getName() + " is not in graph");
			return;
		}
		
		if(!graph.contains(v2))
		{
			System.out.println("v2 " + v2.getName() + " is not in graph");
			return;
		}
		
		ArrayList<Edge> edges = getEdges();
		for(Edge e: edges)
		{
			if(!isUndirected)
			{
				if(e.getFrom()==v1 && e.getTo()==v2)
				{
					System.out.println("Edge "+ v1.getName() + "->" + v2.getName() + " already exists in the graph");
					return;
				}
			}
			else
			{
				if((e.getFrom()==v1 && e.getTo()==v2) || (e.getFrom()==v2 && e.getTo()==v1) )
				{
					System.out.println("Edge "+ v1.getName() + "->" + v2.getName() + " already exists in the graph");
					System.out.println("Edge "+ v2.getName() + "->" + v1.getName() + " already exists in the graph");
					return;
				}
			}
			
		}
		
		if(isUndirected)
		{
		    v1.addEdge(v2, weight);
		    v2.addEdge(v1, weight);
		}
		else
		{
			v1.addEdge(v2, weight);
		}
	}
	
	public void removeEdge(Edge e)
	{
		ArrayList<Edge> edges = getEdges();
		for(Edge ea: edges)
		{
			if(!isUndirected)
			{
				if(ea.getTo()==e.getTo() && ea.getFrom()==e.getFrom() && ea.getWeight()==e.getWeight())
				{
					ea.getFrom().removeEdge(ea.getTo());
				}
			}
			else
			{
				if((ea.getTo()==e.getTo() && ea.getFrom()==e.getFrom()) || (ea.getFrom()==e.getTo() && ea.getTo()==e.getFrom()) && ea.getWeight()==e.getWeight())
				{
					ea.getFrom().removeEdge(ea.getTo());
					ea.getTo().removeEdge(ea.getFrom());
				}
			}
		}
	}
	
	public static ArrayList<Vertex> bfs(Vertex from)
	{
		ArrayList<Vertex> bfsl = new ArrayList<Vertex>();
		if(!graph.contains(from))
		{
			System.out.println("vertex " + from.getName() + " does not exist in the graph");
			return null;
		}
		if(from.getEdges().size() == 0)
		{
			System.out.println(from.getName());
			return null;
		}
		else
		{
			ArrayList<Vertex> visited = new ArrayList<Vertex>();
			Queue<Vertex> q = new LinkedList<Vertex>();
			q.add(from);
			while(!q.isEmpty())
			{
				Vertex val = q.poll();
				if(!visited.contains(val))
				{
					bfsl.add(val);
				}
				visited.add(val);
				ArrayList<Edge> edges = val.getEdges();
				for(Edge e: edges)
				{
					if(!visited.contains(e.getTo()))
					{
					    q.add(e.getTo());
					}
				}
			}
		}
		return bfsl;
	}
	
	public ArrayList<Vertex> dfs(Vertex from)
	{
		ArrayList<Vertex> dfsl = new ArrayList<Vertex>();
		if(!graph.contains(from))
		{
			System.out.println("vertex " + from.getName() + " does not exist in the graph");
			return null;
		}
		if(from.getEdges().size() == 0)
		{
			System.out.println(from.getName());
			return null;
		}
		else
		{
			ArrayList<Vertex> visited = new ArrayList<Vertex>();
			Stack<Vertex> s = new Stack<Vertex>();
			s.push(from);
			while(!s.isEmpty())
			{
				Vertex val = s.pop();
				if(!visited.contains(val))
				{
					dfsl.add(val);
				}
				visited.add(val);
				ArrayList<Edge> edges = val.getEdges();
				for(Edge e: edges)
				{
					if(!visited.contains(e.getTo()))
					{
					    s.push(e.getTo());
					}
				}
			}
		}
		return dfsl;
	}
	
	public static HashMap<Vertex,Integer> dijkstra(Vertex source)
	{
		HashMap<Vertex,Integer> dd = new HashMap<Vertex,Integer>();
		HashMap<Vertex,Integer> ddf = new HashMap<Vertex,Integer>();
		
		List<Vertex> unvisited = new ArrayList<Vertex>();
		List<Vertex> visited = new ArrayList<Vertex>();
		Vertex current = source;
		int pathWeight = 0;
		while(true)
		{
			//add all edges and compare
			if(current.getNumEdges()!=0)
			{
				for(Edge e: current.getEdges())
				{
					//if we have not visited the node and its not the source, add it
					if(!unvisited.contains(e.getTo()) && e.getTo()!=source)
					{
						unvisited.add(e.getTo());
						dd.put(e.getTo(), pathWeight+e.getWeight());
					}
					//if its the source node or we already visited it, ignore and continue
					else if(e.getTo()==source || visited.contains(e.getTo()))
					{
						continue;
					}
					else
					{
						//if the current path weight is less than the old path weight, replace it
						if(pathWeight+e.getWeight()<dd.get(e.getTo()))
						{
							dd.put(e.getTo(), pathWeight+e.getWeight());
						}
					}
				}
			}
			
			//no new nodes; done
			if(dd.isEmpty() && current!=source)
			{
				break;
			}
			
			//get minimum vertex and weights
			Vertex minVertex = Collections.min(dd.entrySet(), Map.Entry.comparingByValue()).getKey();
			int minValue =  Collections.min(dd.entrySet(), Map.Entry.comparingByValue()).getValue();
			
			dd.remove(minVertex);
			ddf.put(minVertex, minValue);
			visited.add(minVertex);
			unvisited.remove(minVertex);
			
			pathWeight=minValue;
			current = minVertex;
			
		}
		return ddf;
	}
	
	public static HashMap<Vertex,Integer> bellman_ford(Vertex source)
	{
		HashMap<Vertex,Integer> bf = new HashMap<Vertex,Integer>();
		HashMap<Vertex,Boolean> visited = new HashMap<Vertex,Boolean>();
		
		//get list of nodes in graph connected from source
		ArrayList<Vertex> cg = new ArrayList<Vertex>();
		cg=bfs(source);
		int nv = cg.size();
		
		//initialize distance from source to inf (max val)
		for(int i=0;i<cg.size();i++)
		{
			if(cg.get(i)!=source)
			{
				bf.put(cg.get(i), Integer.MAX_VALUE);
				visited.put(cg.get(i), false);
			}
			else
			{
				bf.put(cg.get(i), 0);
				visited.put(cg.get(i), true);
			}
		}
		
		//maximum numVertices-1 iterations
		//we need to set number of iterations in case the graph has a negative cycle
		//otherwise, it will infinitely loop
		for(int i=0;i<nv-1;i++)
		{
			ArrayList<Vertex> visitedNodes = new ArrayList<Vertex>();
			boolean update=false;
			for(Vertex v: cg)
			{
				//only consider nodes we have visited already
				if(visited.get(v)==true)
				{
					for(Edge e: v.getEdges())
					{
						//if new unvisited node
						if(!visited.get(e.getTo()))
						{
							bf.put(e.getTo(),e.getWeight()+bf.get(v));
							visitedNodes.add(e.getTo());
							update=true;
						}
						//ignore source node
						else if(e.getTo()==source)
						{
							continue;
						}
						else
						{
							//if the current path weight is less than the old path weight, replace it
							if(bf.get(e.getTo())>bf.get(e.getFrom())+e.getWeight())
							{
								bf.put(e.getTo(),bf.get(e.getFrom())+e.getWeight());
								update=true;
							}
						}
					}
				}
			}
			//update visited nodes we saw in this iteration
			for(Vertex v: visitedNodes)
			{
				visited.replace(v, true);
			}
			//if no nodes have been updated, we can exit, optimal paths have been chosen
			if(update==false)
			{
				break;
			}
		}
		
		//check for negative cycles
		for(Vertex v: cg)
		{
			for(Edge e: v.getEdges())
			{
				if(bf.get(e.getTo())>bf.get(e.getFrom())+e.getWeight())
				{
					System.out.println("negative cycle found");
					return null;
				}
			}
		}
		bf.remove(source);
		return bf;
	}
	
	// Approach: DFS, returns when there's a back edge to a node previously visited
	public boolean hasCycle(Vertex source)
	{
		ArrayList<Vertex> dfsl = new ArrayList<Vertex>();
		if(!graph.contains(source))
		{
			System.out.println("vertex " + source.getName() + " does not exist in the graph");
			return false;
		}
		if(source.getEdges().size() == 0)
		{
			return false;
		}
		else
		{
			ArrayList<Vertex> visited = new ArrayList<Vertex>();
			Stack<Vertex> s = new Stack<Vertex>();
			s.push(source);
			while(!s.isEmpty())
			{
				Vertex val = s.pop();
				if(!visited.contains(val))
				{
					dfsl.add(val);
				}
				visited.add(val);
				ArrayList<Edge> edges = val.getEdges();
				for(Edge e: edges)
				{
					if(!visited.contains(e.getTo()))
					{
					    s.push(e.getTo());
					}
					else
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		testGraph g = new testGraph();
	
		Vertex vS = new Vertex("S");
		Vertex vA = new Vertex("A");
		Vertex vB = new Vertex("B");
		Vertex vC = new Vertex("C");
		Vertex vD = new Vertex("D");
		Vertex vE = new Vertex("E");
		Vertex vF = new Vertex("F");
		g.addVertex(vA);
		g.addVertex(vB);
		g.addVertex(vC);
		g.addVertex(vD);
		g.addVertex(vE);
		g.addVertex(vS);
		g.addVertex(vF);
		
		/*
		g.addEdge(vS,vE, 8);
		g.addEdge(vS,vA, 10);
		g.addEdge(vE,vD, 1);
		g.addEdge(vD,vA, -4);
		g.addEdge(vD,vC, -1);
		g.addEdge(vA,vC, 2);
		g.addEdge(vC,vB, -2);
		g.addEdge(vB,vA, 1);
		*/
		
		 g.addEdge(vE, vB,1);
	     g.addEdge(vE, vS,1);
	     g.addEdge(vD, vS,1);
	     g.addEdge(vD, vA,1);
	     g.addEdge(vB, vC,1);
	     g.addEdge(vC, vA,1);
		
		
	}

}

package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {

	private Graph<String, DefaultWeightedEdge> graph;
	private List<String> vertici;
	private FoodDao dao;

	public String creaGrafo(int C) {
		dao = new FoodDao();
		this.vertici = dao.listPorzioniByCalories(C);
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.graph, vertici);

		List<Arco> archi = dao.getArchi();
		for (Arco a : archi) {
			if (this.graph.vertexSet().contains(a.getTipoDiPorzione1()) && 
					this.graph.vertexSet().contains(a.getTipoDiPorzione2())) {
				Graphs.addEdge(this.graph, a.getTipoDiPorzione1(), a.getTipoDiPorzione2(), a.getNfoodCode()); }
		}
		
		return String.format("Grafo creato (%d vertici, %d archi)\n", 
				this.graph.vertexSet().size(), this.graph.edgeSet().size());

	}
	
	public List<PorzioneAdiacente> getAdiacenti(String porzione) {
		List<String> vicini = Graphs.neighborListOf(this.graph, porzione) ;
		List<PorzioneAdiacente> result = new ArrayList<>();
		for(String v: vicini) {
			double peso = this.graph.getEdgeWeight(this.graph.getEdge(porzione, v)) ;
			result.add(new PorzioneAdiacente(v, peso)) ;
		}
		return result ;
	}

	public List<String> getPorzioni() {
		return dao.listAllTipiDiPorzione(); }
	
	public List<String> getVerticiGrafo() {
		return this.vertici;
	}

}
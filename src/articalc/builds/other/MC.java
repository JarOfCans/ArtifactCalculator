package articalc.builds.other;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class MC extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Anemo(character, 0.2f));
		cb.add(new Geo(character, 0.2f));
		cb.add(new Electro(character, 0.2f));
		cb.add(new Dendro(character, 0.4f));
	}

}

class Anemo extends Build {

	public Anemo(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Viridescent, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Anemo, 1f);
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.7f);
		stats.put(Stat.CD, 0.7f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.6f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.CR, 0.8f);
		stats.put(Stat.CD, 0.8f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}

class Geo extends Build {

	public Geo(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 0.8f);
		stats.put(Stat.ER, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.ArchaicPetra, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.ATKP, 0.8f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATK, 0.3f);
	}
	
}

class Electro extends Build {

	public Electro(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Emblem, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Electro, 1f);
		stats.put(Stat.EM, 0.8f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.EM, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.CD, 0.9f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}

class Dendro extends Build {

	public Dendro(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.Dendro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.EM, 0.9f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.CD, 0.9f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
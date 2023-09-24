package articalc.builds.dendro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Nahida extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Deepwood(character, 0.75f));
		cb.add(new Dreams(character, 0.25f));

	}

}

class Deepwood extends Build {

	public Deepwood(Characters character, float priority) {
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
		stats.put(Stat.Dendro, 0.8f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.8f);
		stats.put(Stat.CD, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.ER, 0.3f);
	}
	
}

class Dreams extends Build {

	public Dreams(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Gilded, 0.8f);
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Golden, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 0.85f);
		stats.put(Stat.Dendro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 0.85f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.ER, 0.3f);
	}
	
}
package articalc.builds.dendro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Kaveh extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new DiscountNilou(character, 0.4f));
		cb.add(new Briefcase(character, 0.6f));
	}

}

class DiscountNilou extends Build {

	public DiscountNilou(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.85f);
		stats.put(Stat.EM, 0.75f);
		stats.put(Stat.Dendro, 0.75f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.OceanHued, 1f);
		sets.put(Set.ParadiseLost, 0.9f);
		sets.put(Set.Gilded,0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.9f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ER, 0.95f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.CD, 0.5f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.ATK, 0.15f);
	}
	
}

class Briefcase extends Build {

	public Briefcase(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.EM, 0.9f);
		stats.put(Stat.Dendro, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Gilded,0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Dendro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.9f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 0.95f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
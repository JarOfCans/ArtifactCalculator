package articalc.builds.electro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Yae extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new FoxTotems(character, 1f));
	}

}

class FoxTotems extends Build {

	public FoxTotems(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Electro, 0.75f);
		stats.put(Stat.ER, 0.6f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.EM, 0.7f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Golden, 1f);
		sets.put(Set.Gilded, 0.9f);
		sets.put(Set.Emblem, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.EM, 0.85f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Electro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.75f);
		stats.put(Stat.ER, 0.85f);
		stats.put(Stat.EM, 0.85f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATK, 0.3f);
	}
	
}
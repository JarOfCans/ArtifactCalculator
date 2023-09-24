package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Klee extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new ThirtyTwo(character, 1f));
	}

}
/**
 * It's alot of bombs
 *
 */
class ThirtyTwo extends Build {

	public ThirtyTwo(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 0.95f);
		stats.put(Stat.ATKP, 0.85f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Crimson, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
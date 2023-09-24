package articalc.builds.hydro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Childe extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new TheChilde(character, 1f));
	}

}

class TheChilde extends Build {

	public TheChilde(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Hydro, 0.8f);
		stats.put(Stat.ATKP, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Nymph, 1f);
		sets.put(Set.HeartOfDepth, 0.85f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Hydro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 0.95f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 0.95f);
		stats.put(Stat.ATKP, 0.75f);
		stats.put(Stat.ATKP, 0.3f);
		stats.put(Stat.ER, 0.75f);
		stats.put(Stat.EM, 0.85f);
	}
	
}
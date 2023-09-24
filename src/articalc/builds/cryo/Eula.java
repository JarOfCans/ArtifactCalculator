package articalc.builds.cryo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Eula extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new TheNoblesse(character, 1f));
	}

}

class TheNoblesse extends Build {

	public TheNoblesse(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Physical, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Pale, 1f);
		sets.put(Set.Emblem, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.75f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Physical, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
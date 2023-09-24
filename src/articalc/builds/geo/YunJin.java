package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class YunJin extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new TheGrandFinale(character, 1f));
	}
}

class TheGrandFinale extends Build {

	public TheGrandFinale(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 0.8f);
		sets.put(Set.Husk, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.DEFP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
		stats.put(Stat.CR, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 0.3f);
		stats.put(Stat.DEF, 0.4f);
		stats.put(Stat.ATKP, 0.2f);
	}
	
}
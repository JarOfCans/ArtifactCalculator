package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Gorou extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new GoodBoi(character, 1f));
	}

}

class GoodBoi extends Build {

	public GoodBoi(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.DEFP, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Exile, 0.9f);
		sets.put(Set.Noblesse, 1f);
		sets.put(Set.Husk, 0.8f);
		sets.put(Set.DaysPast, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
		stats.put(Stat.DEFP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.DEFP, 0.6f);
		stats.put(Stat.CD, 0.6f);
		stats.put(Stat.HB, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 0.7f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.DEFP, 0.9f);
		stats.put(Stat.ATKP, 0.2f);
		stats.put(Stat.DEF, 0.35f);
		stats.put(Stat.ATK, 0.05f);
	}
	
}
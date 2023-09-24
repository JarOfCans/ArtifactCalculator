package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Noelle extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new NormalMaidThings(character, 1f));
	}

}


class NormalMaidThings extends Build {

	public NormalMaidThings(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Husk, 1f);
		sets.put(Set.Gladiator, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
		stats.put(Stat.ATKP, 0.7f);
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
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.DEFP, 0.7f);
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.DEF, 0.25f);
		stats.put(Stat.ATK, 0.2f);
	}
}
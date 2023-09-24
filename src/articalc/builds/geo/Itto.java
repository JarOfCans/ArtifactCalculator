package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Itto extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new UngaBunga(character, 1f));
	}
}

class UngaBunga extends Build {

	public UngaBunga(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Husk, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
		stats.put(Stat.ATKP, 0.8f);
		stats.put(Stat.ER, 0.7f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.DEFP, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 0.95f);
		stats.put(Stat.DEFP, 0.85f);
		stats.put(Stat.ATKP, 0.65f);
		stats.put(Stat.DEF, 0.2f);
		stats.put(Stat.ATK, 0.15f);
	}
	
}
package articalc.builds.cryo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Mika extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new GoodBirbSupport(character, 1f));

	}

}

class GoodBirbSupport extends Build {

	public GoodBirbSupport(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 1f);
		sets.put(Set.DaysPast, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.6f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HB, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HPP, 0.9f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.HP, 0.25f);
		stats.put(Stat.CD, 0.45f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.EM, 0.1f);
		
	}
	
}
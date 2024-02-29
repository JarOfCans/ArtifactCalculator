package articalc.builds.anemo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Xianyun extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new BirdPlusPlus(character, 1f));
	}

}

class BirdPlusPlus extends Build {

	public BirdPlusPlus(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.85f);
		stats.put(Stat.ATKP, 0.85f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Viridescent, 1f);
		sets.put(Set.OceanHued, 0.95f);
		sets.put(Set.Noblesse, 0.9f);
		sets.put(Set.DaysPast, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.CR, 0.9f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ATK, 0.5f);
		stats.put(Stat.CR, 0.5f);
		stats.put(Stat.EM, 0.2f);
		stats.put(Stat.CD, 0.2f);
	}
	
}
package articalc.builds.electro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Lisa extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Healer(character, 1f));
	}

}

class Healer extends Build {

	public Healer(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.HB, 0.8f);
		stats.put(Stat.ER, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.DaysPast, 0.9f);
		sets.put(Set.Maiden, 0.8f);
		sets.put(Set.Noblesse, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Electro, 1f);
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 0.85f);
		stats.put(Stat.CD, 0.85f);
		stats.put(Stat.HB, 1f);
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 0.6f);
		stats.put(Stat.CD, 0.6f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.EM, 0.8f);
	}
	
}
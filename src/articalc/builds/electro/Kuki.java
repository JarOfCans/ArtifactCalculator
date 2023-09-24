package articalc.builds.electro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Kuki extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new EMKuki(character, 1f));
	}
}

class EMKuki extends Build {

	public EMKuki(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 0.85f);
		stats.put(Stat.HPP, 0.7f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Gilded, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.Electro, 0.7f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.8f);
		stats.put(Stat.CD, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.HP, 0.25f);
		stats.put(Stat.ATKP, 0.3f);
		stats.put(Stat.ATK, 0.1f);
	}
	
}
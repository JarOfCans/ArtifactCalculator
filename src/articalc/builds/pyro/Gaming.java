package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Gaming extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new LionBird(character, 1f));
	}

}

class LionBird extends Build {

	public LionBird(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.Pyro, 0.75f);
		stats.put(Stat.ER, 0.75f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Marechaussee, 1f);
		sets.put(Set.Crimson, 0.95f);
		sets.put(Set.Gilded, 0.85f);
		sets.put(Set.Vermillion, 0.7f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.EM, 0.95f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 0.95f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
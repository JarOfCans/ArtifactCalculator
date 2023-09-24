package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Amber extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Sniper(character, 0.3f));
		cb.add(new NoblessBrrr(character, 0.7f));
	}

}

class Sniper extends Build {

	public Sniper(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 0.9f);
		stats.put(Stat.ATKP, 0.75f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Wanderers, 1f);
		sets.put(Set.Shimenawa, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.85f);
		stats.put(Stat.CR, 0.8f);
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.EM, 0.85f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}

class NoblessBrrr extends Build {

	public NoblessBrrr(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 1f);
		sets.put(Set.Emblem, 0.6f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 0.8f);
		stats.put(Stat.EM, 0.6f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
		stats.put(Stat.ATKP, 0.6f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 0.95f);
		stats.put(Stat.CD, 0.95f);
		stats.put(Stat.EM, 0.6f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Chevreuse extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new BuffGun(character, 0.5f));
		cb.add(new Gun(character, 0.5f));
	}

}

class BuffGun extends Build {

	public BuffGun(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 0.8f);
		sets.put(Set.DaysPast, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.ER, 0.8f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.CR, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HPP, 0.9f);
		stats.put(Stat.CD, 0.8f);
		stats.put(Stat.EM, 0.75f);
		stats.put(Stat.ATKP, 0.65f);
		stats.put(Stat.HP, 0.35f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}
class Gun extends Build {

	public Gun(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Skill, 0.8f);
		stats.put(Stat.Burst, 0.95f);
		stats.put(Stat.Pyro, 0.9f);
		stats.put(Stat.ER, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Emblem, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 0.95f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.EM, 0.4f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.HP, 0.2f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}
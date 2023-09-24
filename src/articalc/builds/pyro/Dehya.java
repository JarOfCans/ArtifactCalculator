package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Dehya extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new BudgetXinyan(character, 1f));
	}

}

class BudgetXinyan extends Build {

	public BudgetXinyan(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.85f);
		stats.put(Stat.Pyro, 0.7f);
		stats.put(Stat.ATKP, 0.5f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Emblem, 1f);
		sets.put(Set.Glow, 0.95f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.ATKP, 0.8f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Pyro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
		stats.put(Stat.HPP, 0.5f);
		stats.put(Stat.HP, 0.15f);
		stats.put(Stat.EM, 0.4f);
	}
	
}
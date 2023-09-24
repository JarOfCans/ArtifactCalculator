package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Bennett extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new BennettBrrrr(character, 0.3f));
		cb.add(new BennettHeal(character, 0.7f));
	}
}

class BennettBrrrr extends Build {

	public BennettBrrrr(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
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
		stats.put(Stat.ATKP, 0.75f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATK, 0.25f);
		stats.put(Stat.HPP, 0.6f);
		stats.put(Stat.HP, 0.2f);
	}
	
}

class BennettHeal extends Build {

	public BennettHeal(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 1f);
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
		stats.put(Stat.HB, 1f);
		stats.put(Stat.HPP, 0.7f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 0.6f);
		stats.put(Stat.CD, 0.6f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.HPP, 0.9f);
		stats.put(Stat.HP, 0.3f);
	}
	
}
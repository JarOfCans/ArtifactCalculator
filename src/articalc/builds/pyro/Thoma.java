package articalc.builds.pyro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Thoma extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Tonk(character, 0.2f));
		cb.add(new Burgeon(character, 0.5f));
		cb.add(new BurgeonMix(character, 0.3f));
	}

}

class Tonk extends Build {

	public Tonk(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.HPP, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HP, 0.35f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.ATK, 0.15f);
		stats.put(Stat.EM, 0.6f);
		stats.put(Stat.CR, 0.8f);
		stats.put(Stat.CD, 0.6f);
	}
	
}

class Burgeon extends Build {

	public Burgeon(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.HPP, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.ParadiseLost, 1f);
		sets.put(Set.Gilded, 0.98f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.EM, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.95f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HP, 0.35f);
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.ATK, 0.1f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.95f);
		stats.put(Stat.CD, 1f);
	}
	
}


class BurgeonMix extends Build {

	public BurgeonMix(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.HPP, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.ParadiseLost, 1f);
		sets.put(Set.Gilded, 0.98f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.EM, 0.9f);
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HPP, 0.8f);
		stats.put(Stat.CR, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.9f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HP, 0.35f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.ATK, 0.1f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.7f);
		stats.put(Stat.CD, 0.7f);
	}
	
}
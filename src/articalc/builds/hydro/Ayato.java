package articalc.builds.hydro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Ayato extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new AyatoThings(character, 0.7f));
		cb.add(new MindingDamage(character, 0.3f));
	}

}

class AyatoThings extends Build {

	public AyatoThings(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Nymph, 1f);
		sets.put(Set.HeartOfDepth, .95f);
		sets.put(Set.Gladiator, 0.9f);
		sets.put(Set.Echoes, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Hydro, 1f);
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
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.ATK, 0.3f);
		stats.put(Stat.HPP, 0.5f);
		stats.put(Stat.HP, 0.2f);
		stats.put(Stat.EM, 0.6f);
	}
	
}

class MindingDamage extends Build {

	public MindingDamage(Characters character, float priority) {
		super(character, priority);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.Hydro, 0.8f);
		stats.put(Stat.ATKP, 0.7f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Emblem, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Hydro, 1f);
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
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATK, 0.25f);
		stats.put(Stat.HPP, 0.4f);
		stats.put(Stat.EM, 0.6f);
	}
	
}
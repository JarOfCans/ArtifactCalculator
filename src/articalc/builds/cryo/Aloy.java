package articalc.builds.cryo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Aloy extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new NewOneNobless(character, 0.6f));
		cb.add(new FunnyExplosionBuild(character, 0.4f));
	}

}

class NewOneNobless extends Build {

	public NewOneNobless(Characters character, float priority) {
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
		stats.put(Stat.Cryo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CD, 0.9f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.EM, 0.5f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}

class FunnyExplosionBuild extends Build {

	public FunnyExplosionBuild(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 0.8f);
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.ATKP, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Emblem, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.EM, 0.6f);
		
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.CD, 0.95f);
		stats.put(Stat.CR, 0.95f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.EM, 0.5f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
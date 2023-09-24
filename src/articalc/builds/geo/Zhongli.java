package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Zhongli extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Rock(character, 0.6f));
		cb.add(new AFK(character, 0.4f));
	}
}

class Rock extends Build {

	public Rock(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.Geo, 0.9f);
		stats.put(Stat.HPP, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Tenacity, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 0.9f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.HP, 0.25f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}

class AFK extends Build {

	public AFK(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Tenacity, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
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
		stats.put(Stat.CD, 0.5f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 0.4f);
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.ATKP, 0.25f);
		stats.put(Stat.HP, 0.3f);
	}
	
}
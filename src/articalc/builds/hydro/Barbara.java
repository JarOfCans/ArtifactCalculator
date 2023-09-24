package articalc.builds.hydro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Barbara extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Healer(character, 0.45f));
		cb.add(new DPS(character, 0.05f));
		cb.add(new BloomSupport(character, 0.5f));
	}

}

class Healer extends Build {

	public Healer(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.HB, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.OceanHued, 1f);
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
		stats.put(Stat.HPP, 0.85f);
		stats.put(Stat.HB, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.HP, 0.4f);
		stats.put(Stat.ER, 0.75f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 0.3f);
		stats.put(Stat.CD, 0.3f);
		stats.put(Stat.ATKP, 0.2f);
	}
}

class DPS extends Build {

	public DPS(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.Hydro, 0.8f);
		stats.put(Stat.EM, 0.7f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.HeartOfDepth, 0.8f);
		sets.put(Set.Shimenawa, 0.8f);
		sets.put(Set.Wanderers, 1f);
		sets.put(Set.OceanHued, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.EM, 0.6f);
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
		stats.put(Stat.ATKP, 0.6f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.HPP, 0.8f);
		stats.put(Stat.HP, 0.2f);
	}
	
}

class BloomSupport extends Build {

	public BloomSupport(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.HB, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.ParadiseLost, 1f);
		sets.put(Set.Gilded, 1f);
		sets.put(Set.OceanHued, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HB, 0.8f);
		stats.put(Stat.HPP, 0.4f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.HP, 0.4f);
		stats.put(Stat.ER, 0.5f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.CR, 0.5f);
		stats.put(Stat.CD, 0.5f);
	}
	
}
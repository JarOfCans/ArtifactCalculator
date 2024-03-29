package articalc.builds.cryo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Charlotte extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new CameraSupport(character, 0.5f));
		cb.add(new TruthBombDPS(character, 1f));
	}

}

class CameraSupport extends Build {

	public CameraSupport(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.8f);
		stats.put(Stat.ER, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Tenacity, 1f);
		sets.put(Set.Noblesse, 1f);
		sets.put(Set.Blizzard, 0.9f);
		sets.put(Set.DaysPast, 0.8f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HB, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ATKP, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.ATKP, 0.8f);
		stats.put(Stat.CD, 0.7f);
		stats.put(Stat.ATK, 0.2f);
		stats.put(Stat.HPP, 0.1f);
		stats.put(Stat.DEFP, 0.1f);
		stats.put(Stat.EM, 0.1f);
	}
	
}

class TruthBombDPS extends Build {

	public TruthBombDPS(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Blizzard, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
		stats.put(Stat.ATKP, 0.9f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.ATKP, 0.9f);
		stats.put(Stat.HB, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.ATKP, 0.9f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATK, 0.3f);
	}
	
}
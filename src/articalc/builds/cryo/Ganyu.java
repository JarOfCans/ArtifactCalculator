package articalc.builds.cryo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Ganyu extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new IceMix(character, 0.4f));
		cb.add(new Melt(character, 0.4f));
		cb.add(new Freeze(character, 0.2f));
	}

}

class IceMix extends Build {

	public IceMix(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
		stats.put(Stat.ER, 0.5f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.EM, 0.3f);
		
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Blizzard, 1f);
		sets.put(Set.Wanderers, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.3f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.CR, 0.85f);
		stats.put(Stat.ATKP, 0.75f);
		stats.put(Stat.EM, 0.5f);
		stats.put(Stat.ATK, 0.3f);
	}
	
}

class Melt extends Build {

	public Melt(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 0.7f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.ER, 0.3f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Wanderers, 1f);
		sets.put(Set.Shimenawa, 0.8f);
		sets.put(Set.Gilded, 0.75f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		stats.put(Stat.ATKP, 0.75f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
		stats.put(Stat.EM, 0.5f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 0.9f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 0.9f);
		stats.put(Stat.EM, 0.95f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
		stats.put(Stat.ER, 0.4f);
	}
	
}

class Freeze extends Build {

	public Freeze(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 0.7f);
		stats.put(Stat.ATKP, 0.6f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Blizzard, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.ER, 0.4f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Cryo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 0.6f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 0.7f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.9f);
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.ATK, 0.3f);
		
	}
	
}
package articalc.builds.dendro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Baizhu extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new Dead(character, 1f));
	}

}

class Dead extends Build {

	public Dead(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 0.8f);
		sets.put(Set.OceanHued, 1f);
		sets.put(Set.Noblesse, 0.9f);
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
		stats.put(Stat.HB, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.ER, 1f);
		stats.put(Stat.HP, 0.35f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.CR, 0.2f);
		stats.put(Stat.CD, 0.2f);
		
	}
	
}
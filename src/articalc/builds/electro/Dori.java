package articalc.builds.electro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Dori extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		cb.add(new daGoods(character, 1f));
	}

}

class daGoods extends Build {

	public daGoods(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Noblesse, 0.8f);
		sets.put(Set.Gilded, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
		
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.EM, 0.7f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 1f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 0.7f);
		stats.put(Stat.HPP, 0.9f);
		stats.put(Stat.HP, 0.3f);
		stats.put(Stat.ATKP, 0.5f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}
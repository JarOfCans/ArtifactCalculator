package articalc.builds.dendro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class YaoYao extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		//TODO add more
		cb.add(new LilHealer(character, 0.6f));
		cb.add(new YaoYaoKill(character, 0.4f));
	}

}

class LilHealer extends Build {

	public LilHealer(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Tenacity, 0.75f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.ER, 0.7f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.HB, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HPP, 0.8f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HPP, 0.85f);
		stats.put(Stat.ER, 0.9f);
		stats.put(Stat.CD, 0.5f);
		stats.put(Stat.EM, 0.7f);
		stats.put(Stat.HP, 0.3f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.ATK, 0.1f);
	}
	
}
class YaoYaoKill extends Build {

	public YaoYaoKill(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Tenacity, 0.7f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Dendro, 1f);
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.EM, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.HPP, 0.6f);
		stats.put(Stat.ER, 0.95f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.EM, 1f);
		stats.put(Stat.HP, 0.2f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.ATK, 0.25f);
	}
	
}
package articalc.builds.dendro;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Kirara extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		//cb.add(new BoxDamage(character, 0.4f));
		cb.add(new BoxShield(character, 1f));
	}

}

class BoxDamage extends Build {

	public BoxDamage(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.Dendro, 0.9f);
		stats.put(Stat.EM, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Tenacity, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.7f);
		stats.put(Stat.ATKP, 1f);
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.EM, 0.9f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Dendro, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 0.7f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ER, 0.85f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.ATKP, 0.7f);
		stats.put(Stat.HP, 0.2f);
		stats.put(Stat.ATK, 0.2f);
	}
	
}

class BoxShield extends Build {

	public BoxShield(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Deepwood, 1f);
		sets.put(Set.Noblesse, 0.8f);
		sets.put(Set.Tenacity, 0.8f);
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
		stats.put(Stat.CR, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.HPP, 1f);
		stats.put(Stat.EM, 0.8f);
		stats.put(Stat.ER, 0.8f);
		stats.put(Stat.CR, 0.7f);
		stats.put(Stat.CD, 0.5f);
		stats.put(Stat.ATKP, 0.4f);
		stats.put(Stat.HP, 0.4f);
		stats.put(Stat.ATK, 0.1f);
	}
	
}
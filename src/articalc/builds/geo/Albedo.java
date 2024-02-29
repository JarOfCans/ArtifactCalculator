package articalc.builds.geo;

import java.util.ArrayList;
import java.util.HashMap;

import articalc.brute.CharacterBuilds;
import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class Albedo extends CharacterBuilds {

	@Override
	public void assignBuilds(ArrayList<Build> cb) {
		// TODO Auto-generated method stub
		cb.add(new Flower(character, 0.9f));
		cb.add(new TrailMix(character, 0.1f));
	}

}

class Flower extends Build {

	public Flower(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 0.7f);
		stats.put(Stat.Geo, 0.8f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Husk, 1f);
		sets.put(Set.Golden, 1f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
		stats.put(Stat.DEFP, 0.9f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 0.5f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
		stats.put(Stat.DEFP, 0.75f);
		stats.put(Stat.DEF, 0.2f);
		stats.put(Stat.ER, 0.4f);
	}
	
}

class TrailMix extends Build {

	public TrailMix(Characters character, float priority) {
		super(character, priority);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 0.8f);
		stats.put(Stat.Geo, 0.9f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		sets.put(Set.Husk, 1f);
		sets.put(Set.Golden, 0.9f);
	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ER, 0.75f);
		stats.put(Stat.DEFP, 1f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		stats.put(Stat.Geo, 1f);
	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		stats.put(Stat.CR, 1f);
		stats.put(Stat.CD, 1f);
	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.CD, 1f);
		stats.put(Stat.CR, 1f);
		stats.put(Stat.ER, 0.75f);
		stats.put(Stat.DEFP, 0.8f);
		stats.put(Stat.ATKP, 0.45f);
		stats.put(Stat.DEF, 0.25f);
		stats.put(Stat.ATK, 0.15f);
	}
	
}
package articalc.builds.other;

import java.util.HashMap;

import articalc.character.Build;
import articalc.enums.Characters;
import articalc.enums.Set;
import articalc.enums.Stat;

public class TestCharacter extends Build {

	public TestCharacter() {
		super(null, 1f);
	}

	@Override
	public void twoPiece(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.7f);
	}

	@Override
	public void fourPiece(HashMap<Set, Float> sets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sands(HashMap<Stat, Float> stats) {
		stats.put(Stat.ATKP, 0.7f);
	}

	@Override
	public void goblet(HashMap<Stat, Float> stats) {
		// TODO Auto-generated method stub

	}

	@Override
	public void circlet(HashMap<Stat, Float> stats) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subs(HashMap<Stat, Float> stats) {
		stats.put(Stat.DEFP, 0.7f);
		stats.put(Stat.Pyro, 1f);
		stats.put(Stat.Anemo, 1f);
		stats.put(Stat.Hydro, 1f);
	}

}

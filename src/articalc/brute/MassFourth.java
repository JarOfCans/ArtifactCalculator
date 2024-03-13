package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import articalc.artifact.Artifact;
import articalc.artifact.ArtifactParser;
import articalc.enums.Stat;
import articalc.math.FutureSubs;

public class MassFourth {

	public static void main(String[] args) {
		ArtifactParser parse = new ArtifactParser("genshinData_GOOD_2024_03_02_11_46.json");
		ArrayList<DataPack> adp = new ArrayList<DataPack>(2000);
		for (Artifact art: parse.artifacts) {
			if (art.level < 20) {
				adp.add(FutureSubs.getFourthSubArray(art));
				if (adp.size()%100 == 0) {
					System.out.println("Fourth sub #" + adp.size() + " written.");
				}
			}
		}
		Collections.sort(adp);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("LevelsTo4.txt"))) {
			for (DataPack dp: adp) {
				System.out.println(dp.toString());
				bw.write(dp.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

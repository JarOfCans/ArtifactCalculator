package articalc.brute;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import articalc.artifact.Artifact;
import articalc.enums.Domain;
import articalc.enums.Set;
import articalc.math.FutureSubs;

public class MassArtSubs {

	final float[] levelRequirements = new float[]{.1f, .2f, .2f, .2f, .2f};
	final int[] expEffectiveCosts = new int[] {0,-2706,22,4095,10445,21694,270475};
	int[][] runDepth = new int[5][101];
	int[] runCount = new int[5];
	public int depth = 16;
	
	public static void main(String[] args) {
		new MassArtSubs();
	}
	
	public MassArtSubs() {

		//
		// TODO Auto-generated method stub
		for (int i = 0; i < runDepth.length; i++) {
			runDepth[i] = new int[101];
			runCount[i] = 0;
			for (int j = 0; j < 101;j++) {
				runDepth[i][j] = 0;
			}
		}
		int runs = 10000;
		for (int i =0; i < runs; i++) {
			RunDomain(Domain.SolitaryEnlightenment);
			if (i%20 == 0) {
				System.out.printf("Run: %d complete%s", i, System.lineSeparator());
			}
		}
		float totalTwenties[] = new float[] {0,0,0,0,0};
		for (int cDepth = 0; cDepth <= depth/4; cDepth++) {
			for (int i = 0; i < 101; i++) {
				totalTwenties[cDepth] += runDepth[cDepth][i]*i/100f;
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("testing.csv"))) {
		for (int cDepth = 0; cDepth <= depth/4; cDepth++) {
			float totalTotalTwenties = 0;
			int sum = 0;
			System.out.println("---------Level: " + cDepth*4 + " ----------");
			bw.write("Level " + cDepth*4 + ";=SUMPRODUCT(A" + (cDepth*102 + 2) + ":A" + ((cDepth+1)*102) + ",B" + (cDepth*102 + 2) + ":B" + ((cDepth+1)*102) + ")/100;");
			int levelRequirement = (int)(levelRequirements[cDepth]*100.01f);
			switch (cDepth) {
			case 0:
				bw.write("Strongbox:;=SUM(B" +(cDepth*102 + 2) + ":B" + (cDepth*102 + levelRequirement+1) + ")");
				break;
			case 4:
				bw.write("After Leveling:" + ";=SUMPRODUCT(A" + (cDepth*102 + 2 + levelRequirement) + ":A" + ((cDepth+1)*102) + ",B" + (cDepth*102 + 2 + levelRequirement) + ":B" + ((cDepth+1)*102) + ")/100;");
				bw.write("EXP Lost:;=SUM(B" +(cDepth*102 + 2) + ":B" + (cDepth*102 + levelRequirement+1) + ")*" + expEffectiveCosts[cDepth]);
				bw.write("+SUMPRODUCT(B" +(cDepth*102 + levelRequirement + 2) + ":B" + ((cDepth+1)*102) + ",A" +(cDepth*102 + levelRequirement + 2) + ":A" + ((cDepth+1)*102) + ")/100*" + expEffectiveCosts[cDepth+2]);
				bw.write("+(SUM(B" +(cDepth*102 + 2 + levelRequirement) + ":B" + ((1+cDepth)*102) + ")-SUMPRODUCT(B" +(cDepth*102 + levelRequirement + 2) + ":B" + ((cDepth+1)*102) + ",A" +(cDepth*102 + levelRequirement + 2) + ":A" + ((cDepth+1)*102) + ")/100)*" + expEffectiveCosts[cDepth+1]);
				//bw.write("+(1-SUMPRODUCT(B" +(cDepth*102 + levelRequirement + 2) + ":B" + ((cDepth+1)*102) + "))*" + expEffectiveCosts[cDepth+1]);
				//bw.write("EXP Lost:;=SUM(B" +(cDepth*102 + 2) + ":B" + (cDepth*102 + levelRequirement+1) + ")*" + expEffectiveCosts[cDepth]);
				break;
			default:
				bw.write("EXP Lost:;=SUM(B" +(cDepth*102 + 2) + ":B" + (cDepth*102 + levelRequirement+1) + ")*" + expEffectiveCosts[cDepth]);
				break;
			}
			bw.newLine();
			for (int i = 0; i < 101; i++) {
			sum += runDepth[cDepth][i];
			totalTotalTwenties += (i > 0)?(runDepth[cDepth][i]*i/100f):0f;
			bw.write(i + "; " + runDepth[cDepth][i]);
			bw.newLine();
			System.out.printf("%d%c: %d (Total: %.1f%c, Twenties: %.1f%c)%s", i, '%', runDepth[cDepth][i], (float)sum*100/runCount[cDepth],'%', totalTotalTwenties*100/totalTwenties[cDepth],'%', System.lineSeparator());
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void RunDomain(Domain d) {
		Artifact newArt = d.runDomain();
		for (int i = 0; i <= depth; i += 4) {
			int depthInt = i/4;
			float chance = FutureSubs.getFutureValue(newArt);
			runDepth[depthInt][(int)(chance*100)]++;
			runCount[depthInt]++;
			//System.out.println(depthInt);
			if (chance >= levelRequirements[depthInt]) {
				newArt.randomlyLevel(4);
			}
			else {
				break;
			}
		}
	}
	
	public float runStrongbox(Set artifactSet) {
		Artifact art = Artifact.newRandomArtifactStrongbox(artifactSet);
		return FutureSubs.getFutureValue(art);
	}

}
